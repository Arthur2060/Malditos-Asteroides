package io.github.malditos_asteroides.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import io.github.malditos_asteroides.entities.Player;

public class Maestro {
    private final Player player;
    private final BulletManager bulletManager;
    private final AsteroidManager asteroidManager;
    private float timeElapsed;

    public Maestro(Player player, BulletManager bulletManager, AsteroidManager asteroidManager) {
        this.asteroidManager = asteroidManager;
        this.bulletManager = bulletManager;
        this.player = player;
    }

    public void logic(float delta) {
        if (!checkPlayer()) {
            gameOver(delta, player.getPosition());
        } else {
            player.setSprite(new Texture("assets/jogador-spr.png"));
        }
    }

    public void start() {
        player.setPosition(new int[] {Gdx.graphics.getWidth() / 2, 0});
        player.setHp(3);
        player.setActive(true);

        asteroidManager.setDelay(2);
        asteroidManager.setActive(true);

        bulletManager.setActive(true);
    }

    public boolean checkPlayer() {
        return player.getHp() > 0;
    }

    public void gameOver(float delta, int[] lastPlayerPosition) {
        timeElapsed += delta;

        asteroidManager.getAsteroids().clear();
        bulletManager.getBullets().clear();

        player.setSprite(new Texture("assets/explosion_spr.png"));
        player.setActive(false);

        System.out.println(timeElapsed);

        if (timeElapsed > 1) {
            timeElapsed = 0;
            start();
        }
    }
}
