package io.github.malditos_asteroides;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import io.github.malditos_asteroides.managers.GerenciadorDeAsteroides;
import io.github.malditos_asteroides.entities.Player;

public class Main extends ApplicationAdapter {
    private SpriteBatch spriteBatch;
    private FitViewport viewport;

    private Player player;
    private GerenciadorDeAsteroides asteroide;

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();
        viewport = new FitViewport(8, 5);

        player = new Player(viewport.getScreenWidth() / 2, viewport.getScreenHeight() / 2);
        asteroide = new GerenciadorDeAsteroides(spriteBatch, player);
    }

    @Override
    public void resize (int width, int height) {
        viewport.update(width, height, true);
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
        viewport.apply();
        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
        spriteBatch.begin();

        player.draw(spriteBatch);

        spriteBatch.end();
    }

    private void logic() {
        asteroide.update();
        player.logic();
    }
}
