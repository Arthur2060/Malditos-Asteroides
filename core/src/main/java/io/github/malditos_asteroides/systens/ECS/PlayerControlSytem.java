package io.github.malditos_asteroides.systens.ECS;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.Gdx;
import io.github.malditos_asteroides.components.MovementComponent;
import io.github.malditos_asteroides.components.PlayerComponent;
import io.github.malditos_asteroides.components.TransformComponent;
import io.github.malditos_asteroides.factories.BulletFactory;
import io.github.malditos_asteroides.factories.EntityFactory;

public class PlayerControlSytem extends EntitySystem {

    private final ComponentMapper<PlayerComponent> pcMapper;
    private final ComponentMapper<MovementComponent> mcMapper;
    private final ComponentMapper<TransformComponent> tcMapper;

    private final EntityFactory bulletFactory;
    private final Entity entity;

    public PlayerControlSytem(Entity entity) {
        this.entity = entity;

        this.pcMapper = ComponentMapper.getFor(PlayerComponent.class);
        this.mcMapper = ComponentMapper.getFor(MovementComponent.class);
        this.tcMapper = ComponentMapper.getFor(TransformComponent.class);

        this.bulletFactory = new BulletFactory();
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);

        PlayerComponent pc = pcMapper.get(entity);
        TransformComponent tc = tcMapper.get(entity);
        MovementComponent mc = mcMapper.get(entity);

        if (Gdx.input.isKeyPressed(pc.up)) {
            mc.velocity.y = pc.speed;
        } else if (Gdx.input.isKeyPressed(pc.down)) {
            mc.velocity.y = -pc.speed;
        } else {
            mc.velocity.y = 0;
        }

        if (Gdx.input.isKeyPressed(pc.left)) {
            mc.velocity.x = -pc.speed;
        } else if (Gdx.input.isKeyPressed(pc.right)) {
            mc.velocity.x = pc.speed;
        } else {
            mc.velocity.x = 0;
        }

        if (Gdx.input.isKeyJustPressed(pc.fire)) {
            bulletFactory.create(getEngine(), tc.position);
        }
    }
}
