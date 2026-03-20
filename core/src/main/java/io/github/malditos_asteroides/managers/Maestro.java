package io.github.malditos_asteroides.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import io.github.malditos_asteroides.entities.Asteroid;
import io.github.malditos_asteroides.entities.Player;
import io.github.malditos_asteroides.entities.Score;

public class Maestro {
    private final Player player;
    private final BulletManager bulletManager;
    private final AsteroidManager asteroidManager;
    private final Score score;
    private float timeElapsed;

    public Maestro(Player player,
                   BulletManager bulletManager,
                   AsteroidManager asteroidManager,
                   Score score
    ) {
        this.asteroidManager = asteroidManager;
        this.bulletManager = bulletManager;
        this.player = player;
        this.score = score;
    }

    public void logic(float delta) {
        if (!checkPlayer()) {
            gameOver(delta, player.getPosition());
        } else {
            player.setSprite(new Texture("assets/sprites/staticSprites/jogador-spr.png"));
            checkAsteroidDestroyed();
        }
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
        return player.getHp() > 0;
    }

    public void gameOver(float delta, int[] lastPlayerPosition) {
        timeElapsed += delta;

        asteroidManager.getAsteroids().clear();
        bulletManager.getBullets().clear();

        player.setSprite(new Texture("assets/sprites/staticSprites/explosion_spr.png"));
        player.setActive(false);

        System.out.println(timeElapsed);

        if (timeElapsed > 1) {
            timeElapsed = 0;
            start();
        }
    }

    public void checkAsteroidDestroyed() {
        score.setScore(asteroidManager.getAsteroidsDestroyed().size());
    }
}
