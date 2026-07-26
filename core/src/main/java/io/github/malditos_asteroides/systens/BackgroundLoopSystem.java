package io.github.malditos_asteroides.systens;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import io.github.malditos_asteroides.components.TransformComponent;
import io.github.malditos_asteroides.factories.BackgroundFactory;
import io.github.malditos_asteroides.factories.EntityFactory;

public class BackgroundLoopSystem extends EntitySystem {

    private final ComponentMapper<TransformComponent> tcMapper;

    private final Texture background;
    private final Array<Entity> copies;
    private final EntityFactory backgroundFactory;

    public BackgroundLoopSystem() {
        this.tcMapper = ComponentMapper.getFor(TransformComponent.class);

        this.background = new Texture("Backgrounds/darkPurple.png");
        this.copies = new Array<Entity>();
        this.backgroundFactory = new BackgroundFactory();
    }

    @Override
    public void addedToEngine(Engine engine) {
        super.addedToEngine(engine);
        copies.add(backgroundFactory.create(
            engine,
            new Vector3(
                (float) Gdx.graphics.getWidth() / 2,
                (float) Gdx.graphics.getHeight(),
                -10
            )
        ));
        copies.add(backgroundFactory.create(
            engine,
            new Vector3(
                (float) Gdx.graphics.getWidth() / 2,
                (float) Gdx.graphics.getHeight() / 2,
                -10
            )
        ));
        copies.add(backgroundFactory.create(
            engine,
            new Vector3(
                (float) Gdx.graphics.getWidth() / 2,
                0f,
                -10
            )
        ));
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);

        for (Entity entity : copies) {
            TransformComponent tc = tcMapper.get(entity);

            if (tc.position.y <= (float) -background.getHeight() * tc.scale.y / 2) {
                tc.position.y = Gdx.graphics.getHeight() + (float) (background.getHeight() * tc.scale.y / 2) - 5;
            }
        }
    }
}
