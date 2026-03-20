package io.github.malditos_asteroides.entities.Asteroids;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.malditos_asteroides.entities.Asteroid;

public class LittleAsteroid extends Asteroid {
    public LittleAsteroid(SpriteBatch spriteBatch, int x, int y) {
        super(spriteBatch, x, y);
        hp = 2;
        speed = 350f;
    }

    public LittleAsteroid(SpriteBatch spriteBatch) {
        super(spriteBatch);
    }
}
