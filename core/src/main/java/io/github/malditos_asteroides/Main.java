package io.github.malditos_asteroides;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import io.github.malditos_asteroides.entities.Player;
import io.github.malditos_asteroides.managers.AsteroidManager;
import io.github.malditos_asteroides.managers.CollisionManager;

public class Main extends ApplicationAdapter {
    private SpriteBatch spriteBatch;
    private Player player;
    private AsteroidManager asteroidManager;
    private CollisionManager collisionManager;

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();

        player = new Player(Gdx.graphics.getWidth() / 2, 0, spriteBatch);
        asteroidManager = new AsteroidManager(spriteBatch);
        collisionManager = new CollisionManager(player, asteroidManager.getAsteroids());
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

        player.input(delta);
    }

    private void draw() {
        ScreenUtils.clear(0f, 0f, 0f, 1f);
        spriteBatch.begin();

        player.draw();
        asteroidManager.draw();

        spriteBatch.end();
    }

    private void logic(float delta) {
        player.logic();
        asteroidManager.logic(delta);
        collisionManager.logic();
    }
}
