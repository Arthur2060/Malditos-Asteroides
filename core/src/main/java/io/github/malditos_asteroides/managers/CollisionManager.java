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

    public void logic(float delta) {
        asteroidPlayerCollision(delta);
        asteroidBulletCollision();
    }

    public void asteroidBulletCollision() {
        List<Integer> targetId = new ArrayList<>();

        for (Asteroid asteroid : asteroids) {
            for (Bullet bullet : bullets) {
                if (collisionCheck(
                    asteroid.getPosition(), asteroid.getDimension(),
                    bullet.getPosition()
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

    public void asteroidPlayerCollision(float delta) {
        for (Asteroid asteroid : asteroids) {
            if (collisionCheck(
                player.getPosition(), player.getDimension(),
                asteroid.getPosition()
            )) {
                player.damage(delta);
            }
        }
    }

    public boolean collisionCheck(
        int[] firstPosition, int firstDimension,
        int[] secondPosition
    ) {

        int distance = (int) Math.sqrt(
            Math.pow(Math.abs(firstPosition[0] - secondPosition[0]), 2) +
                Math.pow(Math.abs(firstPosition[1] - secondPosition[1]), 2)
        );

        return (distance < firstDimension);
    }
}
