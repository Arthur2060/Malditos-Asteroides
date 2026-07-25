package io.github.malditos_asteroides.components;

import com.badlogic.ashley.core.Component;
import io.github.malditos_asteroides.utils.BulletType;

public class BulletComponent implements Component {
    public BulletType type = BulletType.SINGLE;
}
