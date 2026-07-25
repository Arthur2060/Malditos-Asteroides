package io.github.malditos_asteroides;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import io.github.malditos_asteroides.factories.EntityFactory;
import io.github.malditos_asteroides.factories.PlayerFactory;

public class GameScreen extends ScreenAdapter  {
    private SpriteBatch spriteBatch;
    private PooledEngine pooledEngine;
    private Entity player;

    private EntityFactory playerFactory = new PlayerFactory();

    public GameScreen(Main parent) {
        this.spriteBatch = parent.spriteBatch;
        this.pooledEngine = new PooledEngine();
        this.player = playerFactory.create(pooledEngine, new Vector3(Gdx.graphics.getWidth() / 2, 1, 0));

        pooledEngine.addSystem(new RenderSystem(spriteBatch));
        pooledEngine.addSystem(new SpawnAsteroidSystem(1f));
        pooledEngine.addSystem(new MovementSystem());
        pooledEngine.addSystem(new AsteroidSystem());
        pooledEngine.addSystem(new PlayerControlSystem(player));
        pooledEngine.addSystem(new CollisionSystem());
        pooledEngine.addSystem(new BulletSystem());
    }

    @Override
    public void render(float delta) {
        pooledEngine.update(delta);
    }
}
