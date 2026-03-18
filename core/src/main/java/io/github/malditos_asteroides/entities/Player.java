package io.github.malditos_asteroides.entities;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player{
    private int hp = 3;
    private float speed = 200.0f;

    private final Texture sprite = new Texture("assets/jogador-spr.png");
    private final int[] position = {0, 0};
    private final SpriteBatch spriteBatch;

    public Player (int x, int y, SpriteBatch spriteBatch) {
        this.position[0] = x;
        this.position[1] = y;
        this.spriteBatch = spriteBatch;
    }

    public void draw() {
        spriteBatch.draw(sprite, position[0], position[1]);
    }

    public void input(float delta) {
        if(
            Gdx.input.isKeyPressed(Input.Keys.W) ||
            Gdx.input.isKeyPressed(Input.Keys.UP)
        ) {
            position[1] += (int) (speed * delta);
        }

        if(
            Gdx.input.isKeyPressed(Input.Keys.S) ||
            Gdx.input.isKeyPressed(Input.Keys.DOWN)
        ) {
            position[1] -= (int) (speed * delta);
        }

        if(
            Gdx.input.isKeyPressed(Input.Keys.D) ||
            Gdx.input.isKeyPressed(Input.Keys.RIGHT)
            ) {
            position[0] += (int) (speed * delta);
        }

        if(
            Gdx.input.isKeyPressed(Input.Keys.A) ||
                Gdx.input.isKeyPressed(Input.Keys.LEFT)
        ) {
            position[0] -= (int) (speed * delta);
        }
    }

    public void logic() {
    }
}
