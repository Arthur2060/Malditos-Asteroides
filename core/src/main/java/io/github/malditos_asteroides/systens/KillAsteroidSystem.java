package io.github.malditos_asteroides.systens;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.utils.Array;
import io.github.malditos_asteroides.components.AsteroidComponent;
import io.github.malditos_asteroides.components.TransformComponent;

public class KillAsteroidSystem extends IteratingSystem {

    private final ComponentMapper<TransformComponent> tcMapper;

    private final Array<Entity> entities;

    public KillAsteroidSystem() {
        super(
            Family.all(
                AsteroidComponent.class,
                TransformComponent.class
            ).get()
        );

        this.tcMapper = ComponentMapper.getFor(TransformComponent.class);

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

            if (tc.position.y < 0) {
                getEngine().removeEntity(entity);
            }
        }

        entities.clear();
    }
}
