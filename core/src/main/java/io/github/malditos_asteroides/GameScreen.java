package io.github.malditos_asteroides;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import io.github.malditos_asteroides.systens.*;

public class GameScreen extends ScreenAdapter  {
    private final SpriteBatch spriteBatch;
    private final PooledEngine pooledEngine;
    private final Entity player;
    public static int score;

    public GameScreen(Main parent) {
        this.spriteBatch = parent.spriteBatch;
        this.pooledEngine = new PooledEngine();
        this.player = parent.playerFactory.create(pooledEngine, new Vector3((float) Gdx.graphics.getWidth() / 2, 1, 0));
        score = 0;

        pooledEngine.addSystem(new RenderSystem(spriteBatch));
        pooledEngine.addSystem(new ScoreSystem(spriteBatch));
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
