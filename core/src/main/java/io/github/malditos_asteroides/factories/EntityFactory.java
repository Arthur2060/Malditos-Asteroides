package io.github.malditos_asteroides.factories;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.ashley.core.Entity;

public interface EntityFactory {
    Entity create(Engine engine, Vector3 position);
}
