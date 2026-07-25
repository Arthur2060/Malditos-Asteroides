package io.github.malditos_asteroides.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public class CollisionComponent implements Component {
    public Array<Entity> collidedWith = new Array<Entity>();
    public Rectangle hitbox = new Rectangle();
}
