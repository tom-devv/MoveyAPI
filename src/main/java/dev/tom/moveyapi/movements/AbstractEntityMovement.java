package dev.tom.moveyapi.movements;

import dev.tom.moveyapi.movements.enums.MovementDirection;
import org.bukkit.entity.Entity;

public abstract class AbstractEntityMovement extends AbstractMovement{

    protected final Entity entity;

    public AbstractEntityMovement(MovementDirection direction, Entity entity){
        super(direction);
        this.entity = entity;
    }
}
