package io.github.malditos_asteroides.factories;

import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.math.Vector3;

import javax.swing.text.html.parser.Entity;

public interface EntityFactory {
    public Entity create(PooledEngine engine, Vector3 position);
}
