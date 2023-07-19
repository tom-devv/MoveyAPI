package dev.tom.moveyapi.movements;

import dev.tom.moveyapi.features.Moveable;
import dev.tom.moveyapi.movements.enums.MovementDirection;

public abstract class AbstractMovement implements Moveable {

    protected final MovementDirection direction;
    protected boolean oscillate;
    protected int period;

    public AbstractMovement(MovementDirection direction) {
        this.direction = direction;
        this.oscillate = true;
        this.period = 20;
    }

    public MovementDirection getDirection() {
        return direction;
    }

    public boolean isOscillate() {
        return oscillate;
    }

    public void setOscillate(boolean oscillate) {
        this.oscillate = oscillate;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }
}
