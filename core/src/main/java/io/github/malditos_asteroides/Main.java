package io.github.malditos_asteroides;

import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import io.github.malditos_asteroides.entities.Player;
import io.github.malditos_asteroides.entities.Score;
import io.github.malditos_asteroides.systens.*;
import io.github.malditos_asteroides.utils.animation.Animator;

public class Main extends Game {
    public SpriteBatch spriteBatch;
    public PooledEngine pooledEngine;

    private CollisionSystem collisionSystem;
    private Engine engine;

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();
        pooledEngine = new PooledEngine();

        Animator animator = new Animator(spriteBatch);
        Player player = new Player(Gdx.graphics.getWidth() / 2, 0, spriteBatch);
        AsteroidSystem asteroidManager = new AsteroidSystem(spriteBatch);
        BulletSystem bulletSystem = new BulletSystem(player, spriteBatch);
        collisionSystem = new CollisionSystem(
            player,
            asteroidManager,
            bulletSystem
        );
        Score score = new Score(spriteBatch);

        engine = new Engine(
            player,
            bulletSystem,
            asteroidManager,
            score,
            animator);

        engine.start();

        setScreen(new FirstScreen(this));
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

        super.render();
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
        engine.input(delta);
    }

    private void draw() {
        ScreenUtils.clear(0f, 0f, 0f, 1f);
        spriteBatch.begin();

        engine.draw();

        spriteBatch.end();
    }

    private void logic(float delta) {
        engine.logic(delta);
        collisionSystem.logic();
    }
}
