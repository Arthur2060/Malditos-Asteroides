package io.github.malditos_asteroides.systens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import io.github.malditos_asteroides.entities.Asteroids.Asteroid;
import io.github.malditos_asteroides.entities.Player;
import io.github.malditos_asteroides.entities.Score;
import io.github.malditos_asteroides.utils.animation.Animator;
import io.github.malditos_asteroides.utils.animation.AnimiationCase;

public class Engine {
    private final Player player;
    private final BulletSystem bulletSystem;
    private final AsteroidSystem asteroidSystem;
    private final Score score;
    private final Animator animator;

    private final AnimiationCase[] animations = new AnimiationCase[] {
        new AnimiationCase(
            new Texture(Gdx.files.internal("assets/sprites/animations/player_invincible.png")),
            new int[]{2, 1},
            0.060f
        ),
        new AnimiationCase(
            new Texture(Gdx.files.internal("assets/sprites/animations/explosion.png")),
            new int[]{3, 2},
            0.001f
        )
    };

    private float timeElapsed;

    public Engine(Player player,
                  BulletSystem bulletSystem,
                  AsteroidSystem asteroidSystem,
                  Score score,
                  Animator animator
    ) {
        this.asteroidSystem = asteroidSystem;
        this.bulletSystem = bulletSystem;
        this.player = player;
        this.score = score;
        this.animator = animator;
    }

    public void input(float delta) {
        bulletSystem.input(delta);
        player.input(delta);
    }

    public void logic(float delta) {
        if (!checkPlayer()) {
            gameOver(delta, player.getPosition());
        } else {
            player.setSprite(new Texture("assets/sprites/staticSprites/jogador-spr.png"));
            checkAsteroidDestroyed();
        }

        player.logic(delta);
        asteroidSystem.logic(delta);
        bulletSystem.logic(delta);
        animator.logic(delta);
    }

    public void draw() {
        player.draw();
        asteroidSystem.draw();
        bulletSystem.draw();
        score.draw();
        animator.draw();
    }

    public void start() {
        player.setPosition(new int[] {Gdx.graphics.getWidth() / 2, 0});
        player.setHp(3);
        player.setActive(true);

        asteroidSystem.setDelay(2);
        asteroidSystem.setActive(true);

        bulletSystem.setActive(true);

        score.zeroScore();
    }

    public boolean checkPlayer() {
        if (player.isInvincible() && player.getHp() > 0) {
            player.setSprite(null);
            animator.animate(animations[0], player.getPosition(), true);
        }

        return player.getHp() > 0;
    }

    public void gameOver(float delta, int[] lastPlayerPosition) {
        timeElapsed += delta;

        asteroidSystem.restart();
        bulletSystem.restart();

        player.setSprite(null);
        animator.animate(animations[1], player.getPosition(), true);
        player.setActive(false);

        if (timeElapsed > 1.0f) {
            start();
            timeElapsed = 0;
        }
    }

    public void checkAsteroidDestroyed() {
        int finalScore = 0;

        for (Asteroid asteroid : asteroidSystem.getAsteroidsDestroyed()) {
            animator.animate(animations[1], asteroid.getPosition(), false);
            finalScore += asteroid.getPoints();
        }

        score.setScore(finalScore);
    }
}
