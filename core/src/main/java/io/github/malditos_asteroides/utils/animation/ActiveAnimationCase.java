package io.github.malditos_asteroides.utils.animation;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ActiveAnimationCase {
    public final Animation<TextureRegion> animation;
    public final int[] position;
    public final boolean loop;

    public ActiveAnimationCase(
        Animation<TextureRegion> animation,
        int[] position,
        boolean loop
    ) {
        this.animation = animation;
        this.position = position;
        this.loop = loop;
    }
}
