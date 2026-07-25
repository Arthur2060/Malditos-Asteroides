package io.github.malditos_asteroides.factories;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;
import io.github.malditos_asteroides.components.MovementComponent;
import io.github.malditos_asteroides.components.PlayerComponent;
import io.github.malditos_asteroides.components.RenderComponent;
import io.github.malditos_asteroides.components.TransformComponent;

public class PlayerFactory implements EntityFactory{

    @Override
    public Entity create(Engine engine, Vector3 position) {
        Entity entity = engine.createEntity();

        TransformComponent tc = new TransformComponent();
        RenderComponent rc = new RenderComponent();
        PlayerComponent pc = new PlayerComponent();
        MovementComponent mc = new MovementComponent();

        rc.sprite = new Sprite(new Texture("PNG/playerShip1_blue.png"));

        tc.position.x = position.x;
        tc.position.y = position.y;
        tc.position.z = position.z;

        pc.hp = 3;

        entity
            .add(tc)
            .add(pc)
            .add(rc)
            .add(mc);

        engine.addEntity(entity);
        return entity;
    }
}
