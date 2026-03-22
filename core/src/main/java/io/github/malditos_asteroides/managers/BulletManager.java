package io.github.malditos_asteroides.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.malditos_asteroides.entities.Bullet;
import io.github.malditos_asteroides.entities.Player;

import java.util.ArrayList;
import java.util.List;

public class BulletManager {
    private final Player player;
    private List<Bullet> bullets = new ArrayList<>();
    private final SpriteBatch spriteBatch;
    private float timeElapsed;
    private float delay = 5f;

    private boolean active = false;

    public BulletManager(Player player, SpriteBatch spriteBatch) {
        this.player = player;
        this.spriteBatch = spriteBatch;
    }

    public void draw() {
        for (Bullet bullet : bullets) {
            bullet.draw();
        }
    }

    public void input(float delta) {
        if (!player.getActive()) {
            return;
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            bullets.add(new Bullet(player.getPosition(), spriteBatch));
        }
    }

    public void checkBullets() {
        bullets.removeIf(bullet -> bullet.getPosition()[1] > Gdx.graphics.getHeight());
    }

    public void logic(float delta) {
        for (Bullet bullet : bullets) {
            bullet.logic(delta);
        }
    }

    public List<Bullet> getBullets() {
        return bullets;
    }

    public void DeleteBullet(Bullet target) {
        bullets.removeIf(bullet -> bullet == target);
    }

    public void setActive(boolean state) {
        active = state;
    }
}
