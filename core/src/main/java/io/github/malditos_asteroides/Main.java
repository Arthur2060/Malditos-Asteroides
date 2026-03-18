package io.github.malditos_asteroides;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import io.github.malditos_asteroides.entities.Ator;
import io.github.malditos_asteroides.entities.gerenciadores.GerenciadorDeAsteroides;
import io.github.malditos_asteroides.entities.gerenciadores.GerenciadorDeColisao;
import io.github.malditos_asteroides.entities.Jogador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main extends ApplicationAdapter {
    private SpriteBatch spriteBatch;
    private FitViewport viewport;

    private Jogador player;
    private GerenciadorDeAsteroides asteroide;

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();
        viewport = new FitViewport(8, 5);

        player = new Jogador(spriteBatch);
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

    }

    private void draw() {
        ScreenUtils.clear(0f, 0f, 0f, 1f);
        viewport.apply();
        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
        spriteBatch.begin();



        spriteBatch.end();
    }

    private void logic() {
        asteroide.update();
        player.update(Gdx.graphics.getDeltaTime());
    }
}
