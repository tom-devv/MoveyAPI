package dev.tom.moveyapi.movements;

import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.regions.CuboidRegion;
import dev.tom.moveyapi.movements.enums.MovementDirection;
import dev.tom.moveyapi.regions.CubicRegion;
import org.bukkit.block.Block;

import java.util.List;

public abstract class AbstractBlockMovement extends AbstractMovement {

    protected final List<Block> blocks;
    private final CubicRegion cubicRegion;
    private final CuboidRegion worldEditRegion;

    public AbstractBlockMovement(MovementDirection direction, List<Block> blocks){
        super(direction);
        this.blocks = blocks;

        // Parse a list of blocks into a cuboid region
        this.cubicRegion = new CubicRegion(blocks);
        Block b1 = blocks.get(0);
        Block b2 = blocks.get(1);
        BlockVector3 v1 = BlockVector3.at(b1.getX(), b1.getY(), b1.getZ());
        BlockVector3 v2 = BlockVector3.at(b2.getX(), b2.getY(), b2.getZ());
        this.worldEditRegion = new CuboidRegion(v1, v2);
    }


    public List<Block> getBlocks() {
        return blocks;
    }

    public CuboidRegion getWorldEditRegion() {
        return worldEditRegion;
    }

    public CubicRegion getCubicRegion() {
        return cubicRegion;
    }
}
