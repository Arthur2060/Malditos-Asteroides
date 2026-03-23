package io.github.malditos_asteroides.entities.Asteroids;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.malditos_asteroides.entities.Asteroid;

public class BigAsteroid extends Asteroid {

    public BigAsteroid(SpriteBatch spriteBatch, int x, int y) {
        super(spriteBatch, x, y);
        hp = 10;
        speed = 100f;
        points = 30;
    }

    @Override
    public void draw() {
        spriteBatch.draw(sprite, position[0], position[1], sprite.getWidth() * 3, sprite.getHeight() * 3);
    }

    @Override
    public int getDimension() {
        return sprite.getWidth() * 3;
    }
}
