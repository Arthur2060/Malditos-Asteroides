package io.github.malditos_asteroides.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Asteroid{
    private int hp = 2;
    private float speed = 100.0f;

    private final Texture sprite = new Texture("assets/sprites/staticSprites/asteroide-1.png");
    private final int[] position = {0, 0};
    private final SpriteBatch spriteBatch;

    public Asteroid(SpriteBatch spriteBatch, int x, int y) {
        this.position[0] = x;
        this.position[1] = y;
        this.spriteBatch = spriteBatch;
    }

    public Asteroid(SpriteBatch spriteBatch) {
        this.spriteBatch = spriteBatch;
    }

    public void draw() {
        spriteBatch.draw(sprite, position[0], position[1]);
    }

    public void logic(float delta) {
        position[1] -= (int) (speed * delta);
    }

    public int[] getPosition() {
        return position;
    }

    public int getDimension() {
        return sprite.getWidth();
    }

    public int getHp() {
        return hp;
    }

    public void damage() {
        hp--;
    }
}
