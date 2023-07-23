package dev.tom.moveyapi.regions;

import com.sk89q.worldedit.blocks.Blocks;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.*;
import java.util.stream.Collectors;

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

    /**
     *
     * @return Top and bottom corner blocks of a cubic region
     */
    @Override
    public List<Block> getCornerBlocks() {
        // 3D frame blocks
        List<Block> blocks = getFrameBlocks();
        // Get the highest point of the frame
        int height = blocks.stream().max(Comparator.comparingInt(b -> b.getLocation().getBlockY())).get().getY();

        // Fetch the two lowest corner blocks (im not sure why this gets the lowest blocks and not the block of any y, but it does)
        Block b1 = blocks.stream().max(Comparator.comparingInt(b -> b.getLocation().getBlockX())).get();
        Block b2 = blocks.stream().min(Comparator.comparingInt(b -> b.getLocation().getBlockZ())).get();

        // Add the height offset to one of the blocks, which one is arbitrary as long as one is at max height and one is not
        b1 = b1.getLocation().add(0, height - b1.getY(), 0).getBlock();


        return new ArrayList<>(Arrays.asList(b1, b2));
    }

    public SquareRegion getSquareRegion() {
        return squareRegion;
    }

}
