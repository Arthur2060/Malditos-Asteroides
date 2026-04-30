package io.github.malditos_asteroides.entities.Asteroids;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class Asteroid{
    protected int hp;
    protected float speed;
    protected int points;

    protected final Texture sprite = new Texture("assets/sprites/staticSprites/asteroide-1.png");
    protected final int[] position = {0, 0};
    protected final SpriteBatch spriteBatch;

    public Asteroid(SpriteBatch spriteBatch, int x, int y) {
        this.position[0] = x;
        this.position[1] = y;
        this.spriteBatch = spriteBatch;
    }

    public void draw() {
        spriteBatch.draw(sprite, position[0], position[1]);
    }

    public void logic(float delta) {
        position[1] -= (int) (speed * delta);
    }

    public int getDimension() {
        return sprite.getWidth();
    }

    public void damage() {
        hp--;
    }
}
