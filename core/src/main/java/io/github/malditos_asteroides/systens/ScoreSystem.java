package io.github.malditos_asteroides.systens;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.malditos_asteroides.GameScreen;

public class ScoreSystem extends EntitySystem {

    private final SpriteBatch spriteBatch;
    private final BitmapFont font;

    public static int score;

    public ScoreSystem(SpriteBatch spriteBatch) {
        score = 0;

        this.spriteBatch = spriteBatch;
        this.font = new BitmapFont();
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);

        spriteBatch.begin();

        font.draw(
            spriteBatch,
            Integer.toString(score),
            Gdx.graphics.getWidth() - 50f,
            Gdx.graphics.getHeight() - 50f
        );

        spriteBatch.end();
    }
}
