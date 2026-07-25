package io.github.malditos_asteroides;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import io.github.malditos_asteroides.factories.EntityFactory;
import io.github.malditos_asteroides.factories.PlayerFactory;
import io.github.malditos_asteroides.systens.*;

public class FirstScreen extends ScreenAdapter  {
    private SpriteBatch spriteBatch;
    private PooledEngine pooledEngine;
    private Entity player;

    private EntityFactory playerFactory = new PlayerFactory();

    public FirstScreen(Main parent) {
        this.spriteBatch = parent.spriteBatch;
        this.pooledEngine = new PooledEngine();
        this.player = playerFactory.create(pooledEngine, new Vector3(1, 1, 0));

        pooledEngine.addSystem(new RenderSystem(spriteBatch));
        pooledEngine.addSystem(new SpawnAsteroidSystem(1f));
        pooledEngine.addSystem(new MovementSystem());
        pooledEngine.addSystem(new KillAsteroidSystem());
        pooledEngine.addSystem(new PlayerControlSytem(player));
    }

    @Override
    public void render(float delta) {
        pooledEngine.update(delta);
    }
}
