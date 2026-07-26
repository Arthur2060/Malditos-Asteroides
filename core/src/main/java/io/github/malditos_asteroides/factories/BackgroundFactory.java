package io.github.malditos_asteroides.factories;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;
import io.github.malditos_asteroides.components.MovementComponent;
import io.github.malditos_asteroides.components.RenderComponent;
import io.github.malditos_asteroides.components.TransformComponent;
import io.github.malditos_asteroides.utils.Assets;

public class BackgroundFactory implements EntityFactory{

    @Override
    public Entity create(Engine engine, Vector3 position) {
        Entity entity = engine.createEntity();

        TransformComponent tc = new TransformComponent();
        MovementComponent mc = new MovementComponent();
        RenderComponent rc = new RenderComponent();

        tc.position = position;

        tc.scale.x = 3.3f;
        tc.scale.y = 3.3f;

        rc.sprite = Assets.background;

        rc.sprite.setCenter(tc.position.x, tc.position.y);
        rc.sprite.setOriginCenter();

        mc.velocity.y = -100f;

        entity
            .add(tc)
            .add(mc)
            .add(rc);

        engine.addEntity(entity);
        return entity;
    }
}
