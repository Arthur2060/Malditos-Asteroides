package io.github.cornos_espaciais;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import io.github.cornos_espaciais.entities.Asteroide;
import io.github.cornos_espaciais.entities.GerenciadorDeColisao;
import io.github.cornos_espaciais.entities.Jogador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Jogador player;

    private List<Asteroide> asteroides;
    private Integer SPAWN_TIME = 3;
    private Float timeLapsed;
    private GerenciadorDeColisao col;

    @Override
    public void create() {
        batch = new SpriteBatch();
        player = new Jogador(batch);
        asteroides = new ArrayList<>();
        timeLapsed = 0f;
        col = new GerenciadorDeColisao(player, asteroides);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0f, 0f, 0f, 1f);
        batch.begin();

        player.movimento(Gdx.graphics.getDeltaTime());
        player.render();
        col.colisao();
        player.tiro();

        timeLapsed += Gdx.graphics.getDeltaTime();
        if (timeLapsed >= SPAWN_TIME) {
            asteroides.add(new Asteroide());
            timeLapsed = 0f;
        }

        for (Asteroide asteroide: asteroides) {
            asteroide.movimento(Gdx.graphics.getDeltaTime());
            asteroide.render(batch);
        }

        Iterator<Asteroide> asteroideIterator = asteroides.iterator();
        while (asteroideIterator.hasNext()) {
            Asteroide asteroide = asteroideIterator.next();
            if (asteroide.getY() <= (asteroide.getSprite().getHeight() * -1) ||
            asteroide.getHp() <= 0) {
                asteroide.dispose();
                asteroideIterator.remove();
            }
        }



        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
