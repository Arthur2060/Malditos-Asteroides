package io.github.malditos_asteroides.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Rectangle;

public class CollisionComponent implements Component {
    public Entity collidedWith = null;
    public Rectangle hitbox = new Rectangle();
}
