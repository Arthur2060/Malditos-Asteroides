package io.github.cornos_espaciais.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Projetil extends Ator{
    private boolean ativo = true;

    public Projetil(Float x, SpriteBatch batch) {
        this.sprite = new Texture("assets/projetil.png");
        this.xPosition = x;
        this.speed = 400f;
        this.yPosition = 100f;
        this.batch = batch;
    }

    public void movimento(Float delta) {
        setyPosition(getyPosition() + speed * delta);
    }

    public void render(SpriteBatch batch) {
        batch.draw(getSprite(), getxPosition(), getyPosition());
    }

    public boolean isAtivo() {
        return ativo;
    }
}
