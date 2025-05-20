package io.github.malditos_asteroides.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Ator {
    protected Integer hp;
    protected Texture sprite;
    protected Float xPosition;
    protected Float yPosition;
    protected Float speed;
    protected SpriteBatch batch;
    protected Boolean ativo = true;

    public Ator() {
    }

    public abstract void movimento(Float delta);

    public void render() {
        batch.draw(sprite, xPosition, yPosition);
    }

    public void dispose() {
        sprite.dispose();
        setAtivo(false);
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Texture getSprite() {
        return sprite;
    }

    public void setSprite(Texture sprite) {
        this.sprite = sprite;
    }

    public Float getxPosition() {
        return xPosition;
    }

    public void setxPosition(Float xPosition) {
        this.xPosition = xPosition;
    }

    public Float getyPosition() {
        return yPosition;
    }

    public void setyPosition(Float yPosition) {
        this.yPosition = yPosition;
    }

    public Float getSpeed() {
        return speed;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public void setBatch(SpriteBatch batch) {
        this.batch = batch;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public void dano() {
        setHp(getHp() - 1);
    }
}
