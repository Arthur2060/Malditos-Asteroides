package io.github.malditos_asteroides;

import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.malditos_asteroides.systens.KillAsteroidSystem;
import io.github.malditos_asteroides.systens.MovementSystem;
import io.github.malditos_asteroides.systens.RenderSystem;
import io.github.malditos_asteroides.systens.SpawnAsteroidSystem;

public class FirstScreen extends ScreenAdapter  {
    private SpriteBatch spriteBatch;
    private PooledEngine pooledEngine;

    public FirstScreen(Main parent) {
        this.spriteBatch = parent.spriteBatch;
        this.pooledEngine = new PooledEngine();

        pooledEngine.addSystem(new RenderSystem(spriteBatch));
        pooledEngine.addSystem(new SpawnAsteroidSystem(1f));
        pooledEngine.addSystem(new MovementSystem());
        pooledEngine.addSystem(new KillAsteroidSystem());
    }

    @Override
    public void render(float delta) {
        pooledEngine.update(delta);
    }
}
