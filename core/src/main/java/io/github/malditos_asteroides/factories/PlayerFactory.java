package io.github.malditos_asteroides.factories;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;
import io.github.malditos_asteroides.components.*;
import io.github.malditos_asteroides.utils.Assets;

public class PlayerFactory implements EntityFactory{

    @Override
    public Entity create(Engine engine, Vector3 position) {
        Entity entity = engine.createEntity();

        TransformComponent tc = new TransformComponent();
        RenderComponent rc = new RenderComponent();
        PlayerComponent pc = new PlayerComponent();
        MovementComponent mc = new MovementComponent();
        CollisionComponent cc = new CollisionComponent();
        LifeComponent lc = new LifeComponent();

        rc.sprite = Assets.player;

        tc.position.x = position.x;
        tc.position.y = position.y;
        tc.position.z = position.z;

        tc.scale.x = 0.5f;
        tc.scale.y = 0.5f;

        lc.hp = 3;

        cc.hitbox.set(tc.position.x, tc.position.y, rc.sprite.getWidth(), rc.sprite.getHeight());

        entity
            .add(tc)
            .add(pc)
            .add(lc)
            .add(cc)
            .add(rc)
            .add(mc);

        engine.addEntity(entity);
        return entity;
    }
}
