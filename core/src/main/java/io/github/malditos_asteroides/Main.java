package io.github.malditos_asteroides;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import io.github.malditos_asteroides.entities.Asteroide;
import io.github.malditos_asteroides.entities.Ator;
import io.github.malditos_asteroides.entities.GerenciadorDeColisao;
import io.github.malditos_asteroides.entities.Jogador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Jogador player;

    private List<Ator> asteroides;
    private static final Float SPAWN_TIME = 1.5f;
    private Float timeLapsed;

    @Override
    public void create() {
        batch = new SpriteBatch();
        player = new Jogador(batch);
        asteroides = new ArrayList<>();
        timeLapsed = 0f;
    }

    @Override
    public void render() {
        ScreenUtils.clear(0f, 0f, 0f, 1f);
        batch.begin();

        player.movimento(Gdx.graphics.getDeltaTime());
        player.render();
        player.tiro();

        timeLapsed += Gdx.graphics.getDeltaTime();
        if (timeLapsed >= SPAWN_TIME) {
            timeLapsed = 0f;
        }

        for (Ator asteroide: asteroides) {
            asteroide.movimento(Gdx.graphics.getDeltaTime());
            asteroide.render();
        }

        Iterator<Ator> asteroideIterator = asteroides.iterator();
        while (asteroideIterator.hasNext()) {
            Ator asteroide = asteroideIterator.next();
            if (asteroide.getyPosition() <= (asteroide.getSprite().getHeight() * -1) ||
            asteroide.getHp() <= 0) {
                asteroide.dispose();
                asteroideIterator.remove();
            }

            if (GerenciadorDeColisao.colisaoEntreAtorEAtores(asteroide, player.getPROJETEIS())) {
                asteroide.dano();
            }
        }

        if (GerenciadorDeColisao.colisaoEntreAtorEAtores(player, asteroides)) {
            player.dano();
        }

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
