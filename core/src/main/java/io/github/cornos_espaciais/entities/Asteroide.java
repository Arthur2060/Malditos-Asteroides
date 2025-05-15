package io.github.cornos_espaciais.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

public class Asteroide extends Ator{
    private final Texture[] POSSIVEISSPRITES = {
        new Texture("assets/asteroide-1.png"),
        new Texture("assets/asteroide-2.png"),
        new Texture("assets/asteroide-3.png")
    };

    public Asteroide(SpriteBatch batch) {
        this.sprite = POSSIVEISSPRITES[new Random().nextInt(3)];
        this.xPosition = new Random().nextFloat() * (Gdx.graphics.getWidth());
        this.yPosition = (float) Gdx.graphics.getHeight();
        this.batch = batch;
        this.speed = (new Random().nextFloat() * 100) + 10;
        this.hp = 3;
    }

    public void movimento(Float delta) {
        setyPosition(getyPosition() - speed * delta);
    }
}
