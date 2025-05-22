package io.github.malditos_asteroides;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import io.github.malditos_asteroides.entities.Ator;
import io.github.malditos_asteroides.entities.gerenciadores.GerenciadorDeAsteroides;
import io.github.malditos_asteroides.entities.gerenciadores.GerenciadorDeColisao;
import io.github.malditos_asteroides.entities.Jogador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Jogador player;
    private GerenciadorDeAsteroides asteroide;

    @Override
    public void create() {
        batch = new SpriteBatch();
        player = new Jogador(batch);
        asteroide = new GerenciadorDeAsteroides(batch, player);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0f, 0f, 0f, 1f);
        batch.begin();

        asteroide.update();
        player.update(Gdx.graphics.getDeltaTime());

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
