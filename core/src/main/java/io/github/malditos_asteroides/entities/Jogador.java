package io.github.malditos_asteroides.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Jogador extends Ator{
    private final List<Ator> PROJETEIS = new ArrayList<>();

    public Jogador(SpriteBatch batch) {
        setHp(3);
        setSprite(new Texture("assets/jogador-spr.png"));
        setxPosition((float) (Gdx.graphics.getWidth() - getSprite().getWidth()) / 2);
        setyPosition(100f);
        setSpeed(200f);
        this.batch = batch;
    }

    @Override
    public void movimento(Float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.A) ||
            Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            setxPosition(getxPosition() - speed * delta);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D) ||
            Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            setxPosition(getxPosition() + speed * delta);
        }
    }

    public void tiro() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            PROJETEIS.add(new Projetil(getxPosition(), batch));
        }

        Iterator<Ator> projetilIterator = PROJETEIS.iterator();
        while (projetilIterator.hasNext()) {
            Ator projetil = projetilIterator.next();
            projetil.movimento(Gdx.graphics.getDeltaTime());
            projetil.render();
            if (projetil.getyPosition() > Gdx.graphics.getHeight()) {
                projetil.dispose();
                projetilIterator.remove();
            }
        }
    }

    public void update() {
        movimento(Gdx.graphics.getDeltaTime());
        render();
        tiro();
    }

    public List<Ator> getPROJETEIS() {
        return PROJETEIS;
    }
}
