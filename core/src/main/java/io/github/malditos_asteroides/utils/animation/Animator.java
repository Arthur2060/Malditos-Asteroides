package io.github.malditos_asteroides.utils.animation;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation;

import java.util.ArrayList;
import java.util.List;

public class Animator {
    private final List<ActiveAnimationCase> activeAnimations = new ArrayList<>();

    private final SpriteBatch spriteBatch;

    private float stateTime;

    public Animator(AnimiationCase[] newAnimations, SpriteBatch spriteBatch) {
        List<Animation<TextureRegion>> animationList = new ArrayList<>();

        for (AnimiationCase animationCase : newAnimations) {
            Animation<TextureRegion> animation = animationCase.toAnimation();

            animationList.add(animation);
        }

        this.spriteBatch = spriteBatch;
    }

    public Animator(SpriteBatch spriteBatch) {
        this.spriteBatch = spriteBatch;
    }

    public void draw() {
        for (ActiveAnimationCase animation : activeAnimations) {
            TextureRegion currentFrame = animation.animation.getKeyFrame(stateTime, animation.loop);

            spriteBatch.draw(currentFrame, animation.position[0], animation.position[1]);
        }

        activeAnimations.clear();
    }

    public void logic(float delta) {
        stateTime += delta;
    }

    public void animate(AnimiationCase animiationCase, int[] position, boolean loop) {
        activeAnimations.add(
            new ActiveAnimationCase(
                animiationCase.toAnimation(),
                position,
                loop
            ));
    }
}
