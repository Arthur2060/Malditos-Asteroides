package io.github.malditos_asteroides.utils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Assets {

    public static Sprite player;

    public static Sprite asteroid1;
    public static Sprite asteroid2;
    public static Sprite asteroid3;

    public static Sprite background;

    public static Sprite bullet;

    public static void load() {
        player = new Sprite(new Texture("PNG/playerShip1_blue.png"));

        asteroid1 = new Sprite(new Texture("PNG/Meteors/meteorBrown_big1.png"));
        asteroid2 = new Sprite(new Texture("PNG/Meteors/meteorBrown_big2.png"));
        asteroid3 = new Sprite(new Texture("PNG/Meteors/meteorBrown_big3.png"));

        background = new Sprite(new Texture("Backgrounds/black.png"));

        bullet = new Sprite(new Texture("PNG/Lasers/laserBlue01.png"));
    }
}
