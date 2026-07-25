package io.github.malditos_asteroides.systens.ECS;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.utils.Array;
import io.github.malditos_asteroides.components.MovementComponent;
import io.github.malditos_asteroides.components.TransformComponent;

public class MovementSystem extends IteratingSystem {

    private final ComponentMapper<MovementComponent> mcMapper;
    private final ComponentMapper<TransformComponent> tcMapper;

    private final Array<Entity> entities;

    public MovementSystem() {
        super(
            Family.all(
                MovementComponent.class,
                TransformComponent.class
            ).get()
        );

        this.tcMapper = ComponentMapper.getFor(TransformComponent.class);
        this.mcMapper = ComponentMapper.getFor(MovementComponent.class);

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
            MovementComponent mc = mcMapper.get(entity);

            tc.position.x += mc.velocity.x * deltaTime;
            tc.position.y += mc.velocity.y * deltaTime;
        }

        entities.clear();
    }
}
