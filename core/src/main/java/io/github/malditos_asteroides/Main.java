package io.github.malditos_asteroides;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import io.github.malditos_asteroides.entities.Player;
import io.github.malditos_asteroides.entities.Score;
import io.github.malditos_asteroides.managers.AsteroidManager;
import io.github.malditos_asteroides.managers.BulletManager;
import io.github.malditos_asteroides.managers.CollisionManager;
import io.github.malditos_asteroides.managers.Maestro;

public class Main extends ApplicationAdapter {
    private SpriteBatch spriteBatch;

    private CollisionManager collisionManager;
    private Maestro maestro;

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();

        Player player = new Player(Gdx.graphics.getWidth() / 2, 0, spriteBatch);
        AsteroidManager asteroidManager = new AsteroidManager(spriteBatch);
        BulletManager bulletManager = new BulletManager(player, spriteBatch);
        collisionManager = new CollisionManager(
            player,
            asteroidManager,
            bulletManager
        );
        Score score = new Score(spriteBatch);

        maestro = new Maestro(player, bulletManager, asteroidManager, score);

        maestro.start();
    }

    @Override
    public void resize (int width, int height) {
    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();

        input(delta);
        draw();
        logic(delta);
    }

    @Override
    public void pause () {
    }

    @Override
    public void resume () {
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
    }

    private void input(float delta) {
        maestro.input(delta);
    }

    private void draw() {
        ScreenUtils.clear(0f, 0f, 0f, 1f);
        spriteBatch.begin();

        maestro.draw();

        spriteBatch.end();
    }

    private void logic(float delta) {
        maestro.logic(delta);
        collisionManager.logic(delta);
    }
}
