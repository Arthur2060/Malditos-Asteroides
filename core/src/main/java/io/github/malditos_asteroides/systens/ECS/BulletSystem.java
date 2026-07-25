package io.github.malditos_asteroides.systens.ECS;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import io.github.malditos_asteroides.components.AsteroidComponent;
import io.github.malditos_asteroides.components.BulletComponent;
import io.github.malditos_asteroides.components.CollisionComponent;
import io.github.malditos_asteroides.components.TransformComponent;

public class BulletSystem extends IteratingSystem {

    private final ComponentMapper<TransformComponent> tcMapper;
    private final ComponentMapper<CollisionComponent> ccMapper;

    public BulletSystem() {
        super(
            Family.all(
                BulletComponent.class
            ).get()
        );

        this.tcMapper = ComponentMapper.getFor(TransformComponent.class);
        this.ccMapper = ComponentMapper.getFor(CollisionComponent.class);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        TransformComponent tc = tcMapper.get(entity);
        CollisionComponent cc = ccMapper.get(entity);

        if (
            tc.position.y > Gdx.graphics.getHeight() ||
            (cc.collidedWith != null && cc.collidedWith.getComponent(AsteroidComponent.class) != null)
        ) {
            getEngine().removeEntity(entity);
        }
    }
}
