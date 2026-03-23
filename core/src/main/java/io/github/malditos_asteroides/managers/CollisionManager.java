package io.github.malditos_asteroides.managers;

import io.github.malditos_asteroides.entities.Asteroid;
import io.github.malditos_asteroides.entities.Bullet;
import io.github.malditos_asteroides.entities.Player;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class CollisionManager {
    private Player player;
    private AsteroidManager asteroidManager;
    private BulletManager bulletManager;

    public CollisionManager(Player player, AsteroidManager asteroidManager, BulletManager bulletManager) {
        this.asteroidManager = asteroidManager;
        this.player = player;
        this.bulletManager = bulletManager;
    }

    public void logic() {
        asteroidPlayerCollision();
        asteroidBulletCollision();
    }

    public void asteroidBulletCollision() {
        List<Bullet> targets = new ArrayList<>();

        for (Asteroid asteroid : asteroidManager.getAsteroids()) {
            for (Bullet bullet : bulletManager.getBullets()) {
                if (collisionCheck(
                    asteroid.getPosition(), asteroid.getDimension(),
                    bullet.getPosition(), bullet.getDimension()
                )) {
                    asteroid.damage();
                    targets.add(bullet);
                }
            }
        }

        for (Bullet target : targets) {
            bulletManager.DeleteBullet(target);
        }
    }

    public void asteroidPlayerCollision() {
        for (Asteroid asteroid : asteroidManager.getAsteroids()) {
            if (collisionCheck(
                player.getPosition(), player.getDimension(),
                asteroid.getPosition(), asteroid.getDimension()
            )) {
                player.damage();
                do {
                    asteroid.damage();
                } while (asteroid.getHp() > 0);
            }
        }
    }

    public boolean collisionCheck(
        int[] firstPosition, int firstDimension,
        int[] secondPosition, int secondDimension
    ) {

        int distance = (int) Math.sqrt(
            Math.pow(Math.abs(firstPosition[0] - secondPosition[0]), 2) +
                Math.pow(Math.abs(firstPosition[1] - secondPosition[1]), 2)
        ) - firstDimension / 2;

        return (distance < secondDimension / 2);
    }
}
