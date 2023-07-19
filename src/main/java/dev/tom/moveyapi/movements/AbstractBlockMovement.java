package dev.tom.moveyapi.movements;

import dev.tom.moveyapi.features.Moveable;
import dev.tom.moveyapi.movements.enums.MovementDirection;
import dev.tom.moveyapi.regions.AbstractRegion;
import dev.tom.moveyapi.regions.CubicRegion;
import dev.tom.moveyapi.regions.SquareRegion;
import org.bukkit.block.Block;

import java.util.List;

public abstract class AbstractBlockMovement extends AbstractMovement {

    protected final List<Block> blocks;
    protected final AbstractRegion region;

    public AbstractBlockMovement(MovementDirection direction, List<Block> blocks){
        super(direction);
        this.blocks = blocks;
        this.region = new CubicRegion(blocks);
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public AbstractRegion getRegion() {
        return region;
    }

}
