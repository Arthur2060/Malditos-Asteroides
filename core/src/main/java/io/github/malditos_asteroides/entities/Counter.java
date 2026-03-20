package io.github.malditos_asteroides.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Counter {
    private int points = 0;
    private final SpriteBatch spriteBatch;
    private final int[] CounterPosition = {Gdx.graphics.getWidth(), Gdx.graphics.getHeight()};

    public Counter(SpriteBatch spriteBatch) {
        this.spriteBatch = spriteBatch;
    }

    public void addPoints(int newPoints) {
        points += newPoints;
    }

    public int getPoints() {
        return points;
    }

    public void draw() {

    }
}
