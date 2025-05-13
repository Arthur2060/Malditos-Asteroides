package io.github.cornos_espaciais.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Jogador extends Ator{
    private final Integer HP = 3;
    private final Texture SPRITE = new Texture("assets/jogador-spr.png");
    private final Float SPEED = 200f;
    private final List<Projetil> PROJETEIS = new ArrayList<>();

    private Float x = (float) (Gdx.graphics.getWidth() - SPRITE.getWidth()) / 2;
    private Float y = 100f;
    private SpriteBatch batch;

    public Jogador(SpriteBatch batch) {
        this.batch = batch;
    }

    @Override
    public void movimento(Float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.A) ||
            Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            setX(getX() - SPEED * delta);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D) ||
            Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            setX(getX() + SPEED * delta);
        }
    }

    public void tiro() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            PROJETEIS.add(new Projetil(getX()));
        }

        Iterator<Projetil> projetilIterator = PROJETEIS.iterator();
        while (projetilIterator.hasNext()) {
            Projetil projetil = projetilIterator.next();
            projetil.movimento(Gdx.graphics.getDeltaTime());
            projetil.render(batch);
            if (projetil.getY() > Gdx.graphics.getHeight()) {
                projetil.dispose();
                projetilIterator.remove();
            }
        }
    }

    public void tiro(Projetil projetil) {
        projetil.dispose();
        PROJETEIS.remove(projetil);
    }

    public void render() {
        batch.draw(SPRITE, getX(), getY());
    }

    public void dispose() {
        SPRITE.dispose();
    }

    public Integer getHP() {
        return HP;
    }

    public Texture getSPRITE() {
        return SPRITE;
    }

    public Float getX() {
        return x;
    }

    public Float getY() {
        return y;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public void setY(Float y) {
        this.y = y;
    }

    public Float getSPEED() {
        return SPEED;
    }

    public List<Projetil> getPROJETEIS() {
        return PROJETEIS;
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public void setBatch(SpriteBatch batch) {
        this.batch = batch;
    }
}
