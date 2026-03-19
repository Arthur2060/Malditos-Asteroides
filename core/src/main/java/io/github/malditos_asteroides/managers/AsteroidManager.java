package io.github.malditos_asteroides.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.malditos_asteroides.entities.Asteroid;

import java.util.ArrayList;
import java.util.List;

public class AsteroidManager {
    private final List<Asteroid> asteroids = new ArrayList<>();
    private final List<Asteroid> asteroidsDestroyed = new ArrayList<>();
    private final SpriteBatch spriteBatch;
    private float timelapsed;
    private float delay = 2f;

    private boolean active = false;

    public AsteroidManager(SpriteBatch spriteBatch) {
        this.spriteBatch = spriteBatch;
    }

    public void draw() {
        for (Asteroid asteroid : asteroids) {
            asteroid.draw();
        }
    }

    public void logic(float delta) {
        if (!active) {
            return;
        }

        spawn(delta);

        for (Asteroid asteroid : asteroids) {
            asteroid.logic(delta);
        }

        checkAsteroids();
    }

    public void spawn(float delta) {
        timelapsed += delta;

        if (timelapsed > delay) {
            asteroids.add(new Asteroid(spriteBatch, (int) (Math.random() * (Gdx.graphics.getWidth() + 1)), Gdx.graphics.getHeight()));
            timelapsed = 0;
        }
    }

    public void checkAsteroids() {
        asteroids.removeIf(asteroid ->
            asteroid.getPosition()[1] < 0 ||
                asteroid.getPosition()[0] > Gdx.graphics.getWidth() ||
                asteroidsDestroyed.contains(asteroid)
        );
        for (Asteroid asteroid : asteroids) {
            if (asteroid.getHp() <= 0) {
                asteroidsDestroyed.add(asteroid);
                System.out.println("THAT`S A LOT OF DAMAGE!!!");
            }
        }
    }

    public List<Asteroid> getAsteroids() {
        return asteroids;
    }

    public void setDelay(int newDelay) {
        if (newDelay > 0) {
            delay = newDelay;
        }
    }

    public void setActive(boolean state) {
        active = state;
    }

    public List<Asteroid> getAsteroidsDestroyed() {
        return asteroidsDestroyed;
    }
}
