package io.github.malditos_asteroides.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class RenderComponent implements Component {
    public Sprite sprite = new Sprite(new Texture("libgdx.png"));
}
