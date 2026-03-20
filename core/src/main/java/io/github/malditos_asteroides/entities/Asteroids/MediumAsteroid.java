package io.github.malditos_asteroides.entities.Asteroids;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.malditos_asteroides.entities.Asteroid;

public class MediumAsteroid extends Asteroid {
    public MediumAsteroid(SpriteBatch spriteBatch, int x, int y) {
        super(spriteBatch, x, y);
        hp = 5;
        speed = 250f;
        points = 20;
    }

    public MediumAsteroid(SpriteBatch spriteBatch) {
        super(spriteBatch);
    }

    @Override
    public void draw() {
        spriteBatch.draw(sprite, position[0], position[1], sprite.getWidth() * 2, sprite.getHeight() * 2);
    }

    @Override
    public int getDimension() {
        return sprite.getWidth() * 2;
    }
}
