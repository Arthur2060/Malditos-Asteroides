package io.github.malditos_asteroides.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bullet {
    private final Texture sprite = new Texture("assets/projetil.png");
    private float speed = 500.0f;

    private int[] position = {0, 0};
    private final SpriteBatch spriteBatch;

    public Bullet(int x, int y, SpriteBatch spriteBatch) {
        this.position[0] = x;
        this.position[1] = y;
        this.spriteBatch = spriteBatch;
    }

    public Bullet(int[] playerPosition, SpriteBatch spriteBatch) {
        this.position[0] = playerPosition[0];
        this.position[1] += playerPosition[1] + (sprite.getHeight() / 2);
        this.spriteBatch = spriteBatch;
    }

    public void draw() {
        spriteBatch.draw(sprite, position[0], position[1]);
    }

    public void logic(float delta) {
        position[1] += (int) (speed * delta);
    }

    public int[] getPosition() {
        return position;
    }

    public int getDimension() {
        return sprite.getWidth();
    }
}
