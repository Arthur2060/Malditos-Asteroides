package io.github.malditos_asteroides.entities.gerenciadores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.malditos_asteroides.entities.Asteroide;
import io.github.malditos_asteroides.entities.Ator;
import io.github.malditos_asteroides.entities.Jogador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GerenciadorDeAsteroides {
    private final List<Ator> asteroides = new ArrayList<>();
    private final SpriteBatch batch;
    private float delay;
    private float asteroidSpeed;
    private final Jogador player;
    private float timeLapsed;

    public GerenciadorDeAsteroides(float delay, float asteroidSpeed, SpriteBatch batch, Jogador player) {
        this.batch = batch;
        this.delay = delay;
        this.asteroidSpeed = asteroidSpeed;
        this.player = player;
    }

    public GerenciadorDeAsteroides(SpriteBatch batch, Jogador player) {
        this.batch = batch;
        delay = 3;
        asteroidSpeed = 10;
        this.player = player;
    }

    private void gerarAsteroide() {
        asteroides.add(new Asteroide(
            batch,
            asteroidSpeed
        ));
    }

    public void update() {
        spawn();
        atualizarAsteroides();
        atualizarColisao();
    }

    private void spawn() {
        timeLapsed += Gdx.graphics.getDeltaTime();
        if (timeLapsed > delay) {
            gerarAsteroide();
            timeLapsed = 0;
        }
    }

    private void atualizarAsteroides() {
        for (Ator asteroide : asteroides) {
            asteroide.movimento(Gdx.graphics.getDeltaTime());
            asteroide.render();
        }

        asteroides.removeIf(asteroide -> {
            boolean foraDaTela = asteroide.getyPosition() <= asteroide.getSprite().getHeight() * -1;
            boolean vidaVazia = asteroide.getHp() <= 0;

            if (foraDaTela || vidaVazia) {
                asteroide.dispose();
                return true;
            }
            return false;
        });
    }

    private void atualizarColisao() {
        for (Ator asteroide : asteroides) {
            if (GerenciadorDeColisao.colisaoEntreAtorEAtores(asteroide, player.getPROJETEIS())) {
                asteroide.dano();
            }
            if (GerenciadorDeColisao.colisaoEntreAtorEAtores(player, asteroides)) {
                player.dano();
            }
        }
    }

    public List<Ator> getAsteroides() {
        return asteroides;
    }

    public float getDelay() {
        return delay;
    }

    public void setDelay(float delay) {
        this.delay = delay;
    }

    public float getAsteroidSpeed() {
        return asteroidSpeed;
    }

    public void setAsteroidSpeed(float asteroidSpeed) {
        this.asteroidSpeed = asteroidSpeed;
    }
}
