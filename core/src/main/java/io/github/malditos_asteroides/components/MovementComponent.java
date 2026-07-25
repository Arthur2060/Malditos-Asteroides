package io.github.malditos_asteroides.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;

public class MovementComponent implements Component {
    public Vector2 velocity = new Vector2(Vector2.Zero);
}
