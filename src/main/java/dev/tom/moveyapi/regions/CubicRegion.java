package dev.tom.moveyapi.regions;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CubicRegion extends AbstractRegion {

    private final SquareRegion squareRegion;

    public CubicRegion(List<Block> blocks) {
        super(blocks);
        // 2D Square regions are helpful as cubic regions are simply a stack of square regions
        // This square regions will represent the base of the cubic region
        this.squareRegion = new SquareRegion(blocks);
    }

    @Override
    public List<Block> getFillingBlocks() {
        List<Block> blocks = new ArrayList<>();
        int step = 0;
        // Loop all the way up from base to top of cuboid
        for (int y = getYMin().getY(); y <= getYMax().getY(); y++) {
            // Loop through all the blocks in the base
            for (Block frameBlock : getSquareRegion().getFillingBlocks()) {
                // From the base block add the y offset to it (to "stack upwards")
                blocks.add(frameBlock.getLocation().add(0, step, 0).getBlock());
            }
            step++;
        }
        return blocks;
    }


    /**
     * Finds the largest cubic frame possible from the block list provided
     * @return
     */
    @Override
    public List<Block> getFrameBlocks() {
        List<Block> blocks = new ArrayList<>();

        int step = 0;
        // Loop all the way up from base to top of cuboid
        for (int y = getYMin().getY(); y <= getYMax().getY(); y++) {
            // Loop through all the blocks in the base
            for (Block frameBlock : getSquareRegion().getFrameBlocks()) {
                // From the base block add the y offset to it (to "stack upwards")
                blocks.add(frameBlock.getLocation().add(0, step, 0).getBlock());
            }
            step++;
        }
        return blocks;
    }

    public SquareRegion getSquareRegion() {
        return squareRegion;
    }

}
