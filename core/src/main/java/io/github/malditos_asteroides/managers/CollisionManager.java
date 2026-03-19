package io.github.malditos_asteroides.managers;

import io.github.malditos_asteroides.entities.Asteroid;
import io.github.malditos_asteroides.entities.Bullet;
import io.github.malditos_asteroides.entities.Player;

import java.util.ArrayList;
import java.util.List;

public class CollisionManager {
    private Player player;
    private List<Asteroid> asteroids;
    private List<Bullet> bullets;

    public CollisionManager(Player player, List<Asteroid> asteroids, List<Bullet> bullets) {
        this.asteroids = asteroids;
        this.player = player;
        this.bullets = bullets;
    }

    public void logic() {
        asteroidPlayerCollision();
        asteroidBulletCollision();
    }

    public void asteroidBulletCollision() {
        List<Integer> targetId = new ArrayList<>();

        for (Asteroid asteroid : asteroids) {
            for (Bullet bullet : bullets) {
                if (collisionCheck(
                    asteroid.getPosition(), asteroid.getDimension(),
                    bullet.getPosition(), bullet.getDimension()
                )) {
                    asteroid.damage();
                    targetId.add(bullets.indexOf(bullet));
                }
            }
        }

        for (int id : targetId) {
            bullets.remove(id);
        }
    }

    public void asteroidPlayerCollision() {
        for (Asteroid asteroid : asteroids) {
            if (collisionCheck(
                player.getPosition(), player.getDimension(),
                asteroid.getPosition(), asteroid.getDimension()
            )) {
                player.dano();
            }
        }
    }

    public boolean collisionCheck(
        int[] firstPosition, int firstDimension,
        int[] secondPosition, int secondDimension
    ) {
        if (
            (firstPosition[0] - firstDimension) < secondPosition[0] &&
            (firstPosition[0] + firstDimension) > secondPosition[0] &&
            (firstPosition[1] - firstDimension) < secondPosition[1] &&
            (firstPosition[1] + firstDimension) > secondPosition[1] &&
            (secondPosition[0] - secondDimension) < firstPosition[0] &&
            (secondPosition[0] + secondDimension) > firstPosition[0] &&
            (secondPosition[1] - secondDimension) < firstPosition[1] &&
            (secondPosition[1] + secondDimension) > firstPosition[1]
        ) {
            return true;
        } else {
            return false;
        }
    }
}
