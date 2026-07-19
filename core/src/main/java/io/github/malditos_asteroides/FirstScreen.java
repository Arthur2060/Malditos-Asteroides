package io.github.malditos_asteroides;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.malditos_asteroides.components.RenderComponent;
import io.github.malditos_asteroides.components.TransformComponent;
import io.github.malditos_asteroides.systens.RenderSystem;

public class FirstScreen implements Screen {
    private final Main parent;

    private SpriteBatch spriteBatch;
    private PooledEngine engine;

    public FirstScreen(Main parent) {
        this.parent = parent;
        this.spriteBatch = parent.spriteBatch;
        this.engine = parent.pooledEngine;
    }

    @Override
    public void show() {
        engine.addSystem(new RenderSystem(spriteBatch));
    }

    @Override
    public void render(float delta) {

        engine.update(delta);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
