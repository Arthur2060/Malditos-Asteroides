package io.github.malditos_asteroides.systens.ECS;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.utils.Array;
import io.github.malditos_asteroides.components.CollisionComponent;
import io.github.malditos_asteroides.components.TransformComponent;

public class CollisionSystem extends IteratingSystem {

    private final ComponentMapper<TransformComponent> tcMapper;
    private final ComponentMapper<CollisionComponent> ccMapper;

    private final Array<Entity> entities;

    public CollisionSystem() {
        super(
            Family.all(
                CollisionComponent.class,
                TransformComponent.class
            ).get()
        );

        this.tcMapper = ComponentMapper.getFor(TransformComponent.class);
        this.ccMapper = ComponentMapper.getFor(CollisionComponent.class);

        this.entities = new Array<Entity>();
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        TransformComponent tc = tcMapper.get(entity);
        CollisionComponent cc = ccMapper.get(entity);

        cc.hitbox.y = tc.position.y;
        cc.hitbox.x = tc.position.x;

        entities.add(entity);
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);

        for (Entity entity : entities) {
            CollisionComponent cc = ccMapper.get(entity);

            Array<Entity> otherEntities = new Array<>(entities);
            otherEntities.removeIndex(entities.indexOf(entity, true));

            for (Entity otherEntity : otherEntities) {
                CollisionComponent otherCc = ccMapper.get(otherEntity);

                if (cc.hitbox.overlaps(otherCc.hitbox)) {
                    cc.collidedWith.add(otherEntity);
                }
            }
        }

        entities.clear();
    }
}
