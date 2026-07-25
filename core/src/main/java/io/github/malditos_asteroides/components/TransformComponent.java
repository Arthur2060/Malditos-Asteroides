package io.github.malditos_asteroides.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class TransformComponent implements Component {
    public Vector3 position = new Vector3(Vector3.Zero);
    public Vector2 scale = new Vector2(1, 1);
    public float rotation = 0f;
}
