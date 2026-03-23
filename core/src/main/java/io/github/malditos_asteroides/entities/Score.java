package io.github.malditos_asteroides.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Score {
    private int score = 0;

    private final BitmapFont bitmapFont;
    private final SpriteBatch spriteBatch;

    public Score(SpriteBatch spriteBatch, BitmapFont bitmapFont) {
        this.spriteBatch = spriteBatch;
        this.bitmapFont = bitmapFont;
    }

    public Score(SpriteBatch spriteBatch) {
        this.spriteBatch = spriteBatch;
        this.bitmapFont = new BitmapFont(Gdx.files.internal("assets/fonts/Jersey.fnt"));
        bitmapFont.setColor(Color.WHITE);
    }

    public void draw() {
        int screenHeigth = Gdx.graphics.getHeight();
        int screenWidth = Gdx.graphics.getWidth();

        bitmapFont.draw(
            spriteBatch,
            Integer.toString(score),
            screenWidth - ((float) screenWidth / 10),
            screenHeigth - ((float) screenHeigth / 10));
    }

    public int getScore() {
        return score;
    }

    public void setScore(int value) {
        score = value;
    }

    public void zeroScore() {
        score = 0;
    }
}
