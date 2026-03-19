package io.github.malditos_asteroides.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;

public class Score {
    private int score = 0000;

    private final BitmapFont bitmapFont;
    private final SpriteBatch spriteBatch;

    public Score(SpriteBatch spriteBatch, BitmapFont bitmapFont) {
        this.spriteBatch = spriteBatch;
        this.bitmapFont = bitmapFont;
    }

    public Score(SpriteBatch spriteBatch) {
        this.spriteBatch = spriteBatch;
        this.bitmapFont = new BitmapFont();
        bitmapFont.setColor(Color.WHITE);
    }

    public void draw() {
        bitmapFont.draw(spriteBatch, Integer.toString(score), Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
    }

    public int getScore() {
        return score;
    }

    public void addScore(int value) {
        score += value;
        System.out.printf("Score: %d\n", score);
    }

    public void zeroScore() {
        score = 0000;
    }
}
