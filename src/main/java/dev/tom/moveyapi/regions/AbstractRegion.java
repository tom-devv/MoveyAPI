package dev.tom.moveyapi.regions;

import dev.tom.moveyapi.movements.enums.MovementDirection;
import dev.tom.moveyapi.utils.MathHelper;
import dev.tom.moveyapi.utils.RegionPoints;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.util.Vector;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public abstract class AbstractRegion {

    protected List<Block> blocks;
    protected final RegionPoints points;
    protected World world;
    protected boolean includeAir;


    public AbstractRegion(List<Block> blocks) {
        this.blocks = blocks;
        this.points = MathHelper.getMaxPoints(blocks);

        // Check that all blocks are in the same world
        if(blocks.stream().filter(Objects::nonNull).map(b -> b.getWorld()).distinct().count() == 1){
            this.world = blocks.get(0).getWorld();
        } else {
            this.world = null;
            throw new IllegalArgumentException("All blocks must be in the same world");
        }
    }

    public abstract Collection<Block> getFillingBlocks();

    public abstract Collection<Block> getFrameBlocks();

    public abstract Collection<Block> getCornerBlocks();

    protected void includeAir(boolean include){
        this.includeAir = include;
    }

    public void shift(MovementDirection direction, int amount){
        List<Block> temp = this.blocks;
        Vector movmentVector = MathHelper.getMovementVector(direction).multiply(amount);
        temp.forEach(block -> block.getLocation().add(movmentVector));
        blocks.forEach(block -> block.setType(Material.AIR));
        temp.forEach(block -> block.setType(block.getType()));
        this.blocks = temp;
    }

    public Block getXMax() {
        return points.getxMax();
    }

    public Block getXMin() {
        return points.getxMin();
    }

    public Block getYMax() {
        return points.getyMax();
    }

    public Block getYMin() {
        return points.getyMin();
    }

    public Block getZMax() {
        return points.getzMax();
    }

    public Block getZMin() {
        return points.getzMin();
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public RegionPoints getPoints() {
        return points;
    }

    public World getWorld() {
        return world;
    }
}
