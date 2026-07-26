package io.github.malditos_asteroides;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.malditos_asteroides.factories.EntityFactory;
import io.github.malditos_asteroides.factories.PlayerFactory;
import io.github.malditos_asteroides.systens.*;
import io.github.malditos_asteroides.utils.Assets;

public class Main extends Game {
    public SpriteBatch spriteBatch;

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();
        Assets.load();

        setScreen(new GameScreen(this));
    }

    @Override
    public void render() {
        Gdx.gl20.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

        super.render();
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
    }
}
