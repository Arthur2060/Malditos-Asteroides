package io.github.malditos_asteroides.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.Input;

public class PlayerComponent implements Component {
    public float speed = 200f;

    public int left = Input.Keys.A;
    public int right = Input.Keys.D;
    public int up = Input.Keys.W;
    public int down = Input.Keys.S;
    public int fire = Input.Keys.SPACE;
}
