package io.github.malditos_asteroides.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.malditos_asteroides.entities.Asteroid;

import java.util.ArrayList;
import java.util.List;

public class AsteroidManager {
    private List<Asteroid> asteroids = new ArrayList<>();
    private SpriteBatch spriteBatch;
    private float timelapsed;
    private float delay = 2f;

    public AsteroidManager(SpriteBatch spriteBatch) {
        this.spriteBatch = spriteBatch;
    }

    public void draw() {
        for (Asteroid asteroid : asteroids) {
            asteroid.draw();
        }
    }

    public void logic(float delta) {
        timelapsed += delta;

        if (timelapsed > delay) {
            asteroids.add(new Asteroid(spriteBatch, (int) (Math.random() * (Gdx.graphics.getWidth() + 1)), Gdx.graphics.getHeight()));
            timelapsed = 0;
        }

        for (Asteroid asteroid : asteroids) {
            asteroid.logic(delta);
        }

        asteroids.removeIf(asteroid ->
            asteroid.getPosition()[1] < 0 ||
            asteroid.getPosition()[0] > Gdx.graphics.getWidth()
        );
    }

    public List<Asteroid> getAsteroids() {
        return asteroids;
    }
}
