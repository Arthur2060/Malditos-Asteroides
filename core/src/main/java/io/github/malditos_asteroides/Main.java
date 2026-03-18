package io.github.malditos_asteroides;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import io.github.malditos_asteroides.entities.Player;

public class Main extends ApplicationAdapter {
    private SpriteBatch spriteBatch;
    private Player player;

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();

        player = new Player(Gdx.graphics.getWidth() / 2, 0, spriteBatch);
    }

    @Override
    public void resize (int width, int height) {
    }

    @Override
    public void render() {

        input();
        draw();
        logic();
    }

    @Override
    public void pause () {
    }

    @Override
    public void resume () {
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
    }

    private void input() {
        float delta = Gdx.graphics.getDeltaTime();

        player.input(delta);
    }

    private void draw() {
        ScreenUtils.clear(0f, 0f, 0f, 1f);
        spriteBatch.begin();

        player.draw();

        spriteBatch.end();
    }

    private void logic() {
        player.logic();
    }
}
