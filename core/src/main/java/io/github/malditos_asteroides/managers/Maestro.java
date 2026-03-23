package io.github.malditos_asteroides.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import io.github.malditos_asteroides.entities.Asteroid;
import io.github.malditos_asteroides.entities.Player;
import io.github.malditos_asteroides.entities.Score;
import io.github.malditos_asteroides.utils.animation.Animator;
import io.github.malditos_asteroides.utils.animation.AnimiationCase;

public class Maestro {
    private final Player player;
    private final BulletManager bulletManager;
    private final AsteroidManager asteroidManager;
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

    public Maestro(Player player,
                   BulletManager bulletManager,
                   AsteroidManager asteroidManager,
                   Score score,
                   Animator animator
    ) {
        this.asteroidManager = asteroidManager;
        this.bulletManager = bulletManager;
        this.player = player;
        this.score = score;
        this.animator = animator;
    }

    public void input(float delta) {
        bulletManager.input(delta);
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
        asteroidManager.logic(delta);
        bulletManager.logic(delta);
        animator.logic(delta);
    }

    public void draw() {
        player.draw();
        asteroidManager.draw();
        bulletManager.draw();
        score.draw();
        animator.draw();
    }

    public void start() {
        player.setPosition(new int[] {Gdx.graphics.getWidth() / 2, 0});
        player.setHp(3);
        player.setActive(true);

        asteroidManager.setDelay(2);
        asteroidManager.setActive(true);

        bulletManager.setActive(true);

        score.zeroScore();
    }

    public boolean checkPlayer() {
        if (player.getInvincible() && player.getHp() > 0) {
            player.setSprite(null);
            animator.animate(animations[0], player.getPosition(), true);
        }

        return player.getHp() > 0;
    }

    public void gameOver(float delta, int[] lastPlayerPosition) {
        timeElapsed += delta;

        asteroidManager.restart();
        bulletManager.restart();

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

        for (Asteroid asteroid : asteroidManager.getAsteroidsDestroyed()) {
            animator.animate(animations[1], asteroid.getPosition(), false);
            finalScore += asteroid.getPoints();
        }

        score.setScore(finalScore);
    }
}
