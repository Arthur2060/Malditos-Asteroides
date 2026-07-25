package io.github.malditos_asteroides.systens.ECS;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.utils.Array;
import io.github.malditos_asteroides.components.AsteroidComponent;
import io.github.malditos_asteroides.components.CollisionComponent;
import io.github.malditos_asteroides.components.TransformComponent;

public class KillAsteroidSystem extends IteratingSystem {

    private final ComponentMapper<TransformComponent> tcMapper;
    private final ComponentMapper<CollisionComponent> ccMapper;

    private final Array<Entity> entities;

    public KillAsteroidSystem() {
        super(
            Family.all(
                AsteroidComponent.class,
                TransformComponent.class
            ).get()
        );

        this.tcMapper = ComponentMapper.getFor(TransformComponent.class);
        this.ccMapper = ComponentMapper.getFor(CollisionComponent.class);

        this.entities = new Array<Entity>();
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        entities.add(entity);
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);

        for (Entity entity : entities) {
            TransformComponent tc = tcMapper.get(entity);
            CollisionComponent cc = ccMapper.get(entity);

            if (
                tc.position.y < 0 ||
                cc.collidedWith != null
            ) {
                getEngine().removeEntity(entity);
            }
        }

        entities.clear();
    }
}
