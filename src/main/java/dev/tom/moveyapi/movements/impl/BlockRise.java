package dev.tom.moveyapi.movements.impl;

import dev.tom.moveyapi.movements.AbstractBlockMovement;
import dev.tom.moveyapi.movements.enums.MovementDirection;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

import java.util.List;

public class BlockRise extends AbstractBlockMovement {


    public BlockRise(MovementDirection direction, List<Block> blocks) {
        super(direction, blocks);
        move();
    }

    @Override
    public void move() {
        World world = getCubicRegion().getWorld();
        for (Block block : getBlocks()) {
            block.getWorld().getBlockAt(block.getX(), block.getY() + 5, block.getZ()).setType(block.getType());
            block.setType(Material.AIR);
        }
    }

    @Override
    public boolean oscillate() {
        return false;
    }
}
