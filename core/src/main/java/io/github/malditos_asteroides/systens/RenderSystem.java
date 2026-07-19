package io.github.malditos_asteroides.systens;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.SortedIteratingSystem;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import io.github.malditos_asteroides.components.RenderComponent;
import io.github.malditos_asteroides.components.TransformComponent;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RenderSystem extends SortedIteratingSystem {

    private final ComponentMapper<RenderComponent> rcMapper;
    private final ComponentMapper<TransformComponent> tcMapper;

    private final SpriteBatch batch;
    private final Viewport viewport;
    private final OrthographicCamera camera;

    private final List<Entity> entities;

    public RenderSystem(SpriteBatch batch) {
        super(
            Family.all(
                RenderComponent.class,
                TransformComponent.class
            ).get(),
            new ZComparator()
        );

        this.rcMapper = ComponentMapper.getFor(RenderComponent.class);
        this.tcMapper = ComponentMapper.getFor(TransformComponent.class);

        this.batch = batch;
        this.camera = new OrthographicCamera();
        this.viewport = new FitViewport(10, 10, camera);


        this.entities = new ArrayList<Entity>();
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        entities.add(entity);
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);

        batch.begin();

        for (Entity entity : entities) {
            TransformComponent tc = tcMapper.get(entity);
            RenderComponent rc = rcMapper.get(entity);

            rc.sprite.setScale(tc.scale.x, tc.scale.y);
            rc.sprite.setPosition(tc.position.x, tc.position.y);
            rc.sprite.setRotation(tc.rotation);

            rc.sprite.draw(batch);
        }

        batch.end();

        entities.clear();
    }

    private static class ZComparator implements Comparator<Entity> {

        private final ComponentMapper<TransformComponent> tcMapper;

        public ZComparator() {
            tcMapper = ComponentMapper.getFor(TransformComponent.class);
        }

        @Override
        public int compare(Entity o1, Entity o2) {
            TransformComponent tc1 = tcMapper.get(o1);
            TransformComponent tc2 = tcMapper.get(o2);

            return (int) (tc1.position.z - tc2.position.z);
        }
    }
}
