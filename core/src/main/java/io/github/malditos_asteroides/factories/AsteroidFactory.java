package io.github.malditos_asteroides.factories;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;
import io.github.malditos_asteroides.components.*;
import io.github.malditos_asteroides.utils.AsteroidType;

public class AsteroidFactory implements EntityFactory{

    @Override
    public Entity create(Engine engine, Vector3 position) {
        Entity entity = engine.createEntity();

        TransformComponent tc = new TransformComponent();
        RenderComponent rc = new RenderComponent();
        AsteroidComponent ac = new AsteroidComponent();
        MovementComponent mc = new MovementComponent();
        CollisionComponent cc = new CollisionComponent();

        double rng = Math.random() * 100;

        if (rng < 50) {
            ac.type = AsteroidType.ONE;
        } else if (rng < 70) {
            ac.type = AsteroidType.TWO;
        } else {
            ac.type = AsteroidType.THREE;
        }

        switch (ac.type) {
            case ONE:
                rc.sprite = new Sprite(new Texture("PNG/Meteors/meteorBrown_big1.png"));

                tc.position.x = position.x;
                tc.position.y = position.y;
                tc.position.z = position.z;

                tc.scale.x = 0.5f;
                tc.scale.y = 0.5f;

                mc.velocity.y = -200f;
                break;
            case TWO:
                rc.sprite = new Sprite(new Texture("PNG/Meteors/meteorBrown_big2.png"));

                tc.position.x = position.x;
                tc.position.y = position.y;
                tc.position.z = position.z;

                mc.velocity.y = -150f;
                break;
            case THREE:
                rc.sprite = new Sprite(new Texture("PNG/Meteors/meteorBrown_big3.png"));

                tc.position.x = position.x;
                tc.position.y = position.y;
                tc.position.z = position.z;

                tc.scale.x = 2;
                tc.scale.y = 2;

                mc.velocity.y = -100f;
                break;
        }

        cc.hitbox.set(tc.position.x, tc.position.y, rc.sprite.getWidth(), rc.sprite.getHeight());

        entity
            .add(tc)
            .add(ac)
            .add(cc)
            .add(mc)
            .add(rc);

        engine.addEntity(entity);

        return entity;
    }
}
