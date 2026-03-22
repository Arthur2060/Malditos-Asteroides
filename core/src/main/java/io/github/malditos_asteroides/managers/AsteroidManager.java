package io.github.malditos_asteroides.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import io.github.malditos_asteroides.entities.Asteroid;
import io.github.malditos_asteroides.entities.Asteroids.BigAsteroid;
import io.github.malditos_asteroides.entities.Asteroids.LittleAsteroid;
import io.github.malditos_asteroides.entities.Asteroids.MediumAsteroid;

import java.util.ArrayList;
import java.util.List;

public class AsteroidManager {
    private final List<Asteroid> asteroids = new ArrayList<>();
    private final List<Asteroid> asteroidsDestroyed = new ArrayList<>();
    private final SpriteBatch spriteBatch;

    private float elapsedTime;
    private float delay = 0.10f;

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

        elapsedTime += delta;

        if (elapsedTime >= delay) {
            spawn();
            elapsedTime = 0;
        }

        if (!active) {
            return;
        }

        for (Asteroid asteroid : asteroids) {
            asteroid.logic(delta);
        }

        checkAsteroids();
    }

    public void spawn() {
        double rng = Math.random() * 100;
        int randomFloorPoint = MathUtils.random(0, Gdx.graphics.getWidth() - 1);
        Asteroid newAsteroid;

        if (rng < 50) {
            newAsteroid = new LittleAsteroid(spriteBatch, randomFloorPoint, Gdx.graphics.getHeight());
        } else if (rng < 70) {
            newAsteroid = new MediumAsteroid(spriteBatch, randomFloorPoint, Gdx.graphics.getHeight());
        } else {
            newAsteroid = new BigAsteroid(spriteBatch, randomFloorPoint, Gdx.graphics.getHeight());
        }

        asteroids.add(newAsteroid);
    }

    public void checkAsteroids() {
        asteroids.removeIf(asteroid ->
            asteroid.getPosition()[1] < -asteroid.getDimension() ||
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

    public void restart() {
        asteroids.clear();
        asteroidsDestroyed.clear();
    }
}
