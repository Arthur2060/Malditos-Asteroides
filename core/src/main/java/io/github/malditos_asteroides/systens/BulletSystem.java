package io.github.malditos_asteroides.systens;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import io.github.malditos_asteroides.GameScreen;
import io.github.malditos_asteroides.components.*;

public class BulletSystem extends IteratingSystem {

    private final ComponentMapper<TransformComponent> tcMapper;
    private final ComponentMapper<CollisionComponent> ccMapper;
    private final ComponentMapper<LifeComponent> lcMapper;

    public BulletSystem() {
        super(
            Family.all(
                BulletComponent.class
            ).get()
        );

        this.tcMapper = ComponentMapper.getFor(TransformComponent.class);
        this.ccMapper = ComponentMapper.getFor(CollisionComponent.class);
        this.lcMapper = ComponentMapper.getFor(LifeComponent.class);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        TransformComponent tc = tcMapper.get(entity);
        CollisionComponent cc = ccMapper.get(entity);

        if (
            tc.position.y > Gdx.graphics.getHeight()
        ) {
            getEngine().removeEntity(entity);
        }

        for (Entity entity1 : cc.collidedWith) {
            if (entity1.getComponent(AsteroidComponent.class) != null) {
                LifeComponent lcAsteroid = lcMapper.get(entity1);

                if (lcAsteroid.hp == 1) {
                    ScoreSystem.score += 10;
                }
                lcAsteroid.hp--;

                getEngine().removeEntity(entity);
            }
        }
    }
}
