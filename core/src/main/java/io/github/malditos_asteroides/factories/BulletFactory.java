package io.github.malditos_asteroides.factories;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;
import io.github.malditos_asteroides.components.CollisionComponent;
import io.github.malditos_asteroides.components.MovementComponent;
import io.github.malditos_asteroides.components.RenderComponent;
import io.github.malditos_asteroides.components.TransformComponent;

public class BulletFactory implements EntityFactory{

    @Override
    public Entity create(Engine engine, Vector3 position) {
        Entity entity = engine.createEntity();

        TransformComponent tc = new TransformComponent();
        RenderComponent rc = new RenderComponent();
        CollisionComponent cc = new CollisionComponent();
        MovementComponent mc = new MovementComponent();

        tc.position.y = position.y;
        tc.position.x = position.x;

        rc.sprite = new Sprite(new Texture("PNG/Lasers/laserBlue01.png"));

        cc.hitbox.set(tc.position.x, tc.position.y, rc.sprite.getWidth(), rc.sprite.getHeight());

        mc.velocity.y = 1000f;

        entity
            .add(tc)
            .add(rc)
            .add(cc)
            .add(mc);

        engine.addEntity(entity);
        return entity;
    }
}
