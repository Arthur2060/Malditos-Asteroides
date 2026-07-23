package io.github.malditos_asteroides.components;

import com.badlogic.ashley.core.Component;
import io.github.malditos_asteroides.utils.AsteroidType;

public class AsteroidComponent implements Component {
    public AsteroidType type = AsteroidType.ONE;
}
