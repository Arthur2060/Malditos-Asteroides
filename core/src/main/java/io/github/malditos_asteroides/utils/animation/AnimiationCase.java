package io.github.malditos_asteroides.utils.animation;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimiationCase {
    private final Texture animationSheet;

    private final int[] FRAME_COLS_ROWS;
    private final float FPS;

    public AnimiationCase(
        Texture animationSheet,
        int[] FRAME_COLS_ROWS,
        final float FPS
    ) {
        this.animationSheet = animationSheet;
        this.FRAME_COLS_ROWS = FRAME_COLS_ROWS;
        this.FPS = FPS;
    }

    public Animation<TextureRegion> toAnimation() {
        TextureRegion[][] tmp = TextureRegion.split(
            animationSheet,
            animationSheet.getWidth() / FRAME_COLS_ROWS[0],
            animationSheet.getHeight() / FRAME_COLS_ROWS[1]
        );

        TextureRegion[] frames = new TextureRegion[FRAME_COLS_ROWS[0] * FRAME_COLS_ROWS[1]];

        int index = 0;

        for (TextureRegion[] textureRegions : tmp) {
            for (TextureRegion textureRegion : textureRegions) {
                frames[index++] = textureRegion;
            }
        }

        return new Animation<TextureRegion>(FPS, frames);
    }
}
