package io.github.malditos_asteroides.systens;

import com.badlogic.ashley.systems.IntervalSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import io.github.malditos_asteroides.factories.AsteroidFactory;

public class SpawnAsteroidSystem extends IntervalSystem {

    private final AsteroidFactory asteroidFactory;

    public SpawnAsteroidSystem(float interval) {
        super(interval);

        this.asteroidFactory = new AsteroidFactory();
    }

    @Override
    public void updateInterval() {
        int randomFloorPoint = MathUtils.random(0, Gdx.graphics.getWidth() - 1);

        asteroidFactory.create(getEngine(), new Vector3(randomFloorPoint, Gdx.graphics.getHeight() + 1, 0));
    }
}
