package io.github.malditos_asteroides.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.Input;

public class PlayerComponent implements Component {
    public float speed = 100f;

    public int left = Input.Keys.LEFT;
    public int right = Input.Keys.RIGHT;
    public int up = Input.Keys.UP;
    public int down = Input.Keys.DOWN;
    public int fire = Input.Keys.J;
}
