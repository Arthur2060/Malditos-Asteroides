package io.github.cornos_espaciais.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Projetil {
    private final Texture SPRITE = new Texture("assets/projetil.png");
    private final Float SPEED = 400f;

    private boolean ativo = true;
    private Float x;
    private Float y = 100f;

    public Projetil(Float x) {
        this.x = x;
    }

    public void movimento(Float delta) {
        setY(getY() + SPEED * delta);
    }

    public void render(SpriteBatch batch) {
        batch.draw(SPRITE, getX(), getY());
    }

    public void dispose() {
        SPRITE.dispose();
        ativo = false;
    }

    public Texture getSPRITE() {
        return SPRITE;
    }

    public Float getSPEED() {
        return SPEED;
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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
