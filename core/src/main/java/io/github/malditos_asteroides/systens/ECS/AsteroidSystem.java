package io.github.malditos_asteroides.systens.ECS;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.utils.Array;
import io.github.malditos_asteroides.components.*;

public class AsteroidSystem extends IteratingSystem {

    private final ComponentMapper<TransformComponent> tcMapper;
    private final ComponentMapper<RenderComponent> rcMapper;
    private final ComponentMapper<CollisionComponent> ccMapper;
    private final ComponentMapper<LifeComponent> lcMapper;

    public AsteroidSystem() {
        super(
            Family.all(
                AsteroidComponent.class
            ).get()
        );

        this.tcMapper = ComponentMapper.getFor(TransformComponent.class);
        this.rcMapper = ComponentMapper.getFor(RenderComponent.class);
        this.ccMapper = ComponentMapper.getFor(CollisionComponent.class);
        this.lcMapper = ComponentMapper.getFor(LifeComponent.class);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        TransformComponent tc = tcMapper.get(entity);
        RenderComponent rc = rcMapper.get(entity);
        CollisionComponent cc = ccMapper.get(entity);
        LifeComponent lc = lcMapper.get(entity);

        tc.rotation += 40f * deltaTime;

        if (
            lc.hp <= 0 ||
                tc.position.y < -(rc.sprite.getHeight() * tc.scale.y)
        ) {
            getEngine().removeEntity(entity);
        }

        for (Entity entity1 : cc.collidedWith) {
            if (
                entity1.getComponent(PlayerComponent.class) != null
            ) {
                getEngine().removeEntity(entity);
            }
        }

        cc.collidedWith.clear();
    }
}
