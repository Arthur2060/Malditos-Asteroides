package io.github.malditos_asteroides.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeAsteroides {
    private final List<Asteroide> asteroides = new ArrayList<Asteroide>();
    private SpriteBatch batch;
    private float delay;
    private float asteroidSpeed;

    public GerenciadorDeAsteroides(float delay, float asteroidSpeed, SpriteBatch batch) {
        this.batch = batch;
        this.delay = delay;
        this.asteroidSpeed = asteroidSpeed;
    }

    public GerenciadorDeAsteroides(SpriteBatch batch) {
        this.batch = batch;
        delay = 3;
        asteroidSpeed = 200;
    }

    private void gerarAsteroide() {
        asteroides.add(new Asteroide(
            batch,
            asteroidSpeed
        ));
    }

    public List<Asteroide> getAsteroides() {
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
