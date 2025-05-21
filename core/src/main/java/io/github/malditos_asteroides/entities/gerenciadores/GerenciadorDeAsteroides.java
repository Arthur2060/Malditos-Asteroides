package io.github.malditos_asteroides.entities.gerenciadores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.malditos_asteroides.Main;
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

    public GerenciadorDeAsteroides(float delay, float asteroidSpeed, SpriteBatch batch, Jogador player) {
        this.batch = batch;
        this.delay = delay;
        this.asteroidSpeed = asteroidSpeed;
        this.player = player;
    }

    public GerenciadorDeAsteroides(SpriteBatch batch, Jogador player) {
        this.batch = batch;
        delay = 3;
        asteroidSpeed = 200;
        this.player = player;
    }

    private void gerarAsteroide() {
        asteroides.add(new Asteroide(
            batch,
            asteroidSpeed
        ));
    }

    public void update() {
        float timeLapsed = 0f;

        timeLapsed += Gdx.graphics.getDeltaTime();
        System.out.println(timeLapsed);
        if (timeLapsed >= delay) {
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
