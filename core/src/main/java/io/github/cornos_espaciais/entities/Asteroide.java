package io.github.cornos_espaciais.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

public class Asteroide {
    private Integer HP = 3;
    private final Texture[] POSSIVEISSPRITES = {
        new Texture("assets/asteroide-1.png"),
        new Texture("assets/asteroide-2.png"),
        new Texture("assets/asteroide-3.png")
    };

    private Float speed = (new Random().nextFloat() * 100) + 10;
    private Texture sprite;
    private Float x;
    private Float y;

    public Asteroide() {
        this.sprite = POSSIVEISSPRITES[new Random().nextInt(3)];
        this.x = new Random().nextFloat() * (Gdx.graphics.getWidth());
        this.y = (float) Gdx.graphics.getHeight();
    }

    public void movimento(Float delta) {
        setY(getY() - speed * delta);
    }

    public void render(SpriteBatch batch) {
        batch.draw(sprite, getX(), getY());
    }

    public void dispose() {
        sprite.dispose();
    }

    public void dano() {
        setHP(getHp() - 1);
    }

    public Integer getHp() {
        return HP;
    }

    public Texture getSprite() {
        return sprite;
    }

    public void setSprite(Texture sprite) {
        this.sprite = sprite;
    }

    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }

    public void setHP(Integer HP) {
        this.HP = HP;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }
}
