package io.github.malditos_asteroides.managers;

import io.github.malditos_asteroides.entities.Asteroid;
import io.github.malditos_asteroides.entities.Player;

import java.util.List;

public class CollisionManager {
    private Player player;
    private List<Asteroid> asteroids;

    public CollisionManager(Player player, List<Asteroid> asteroids) {
        this.asteroids = asteroids;
        this.player = player;
    }

    public void logic() {
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
