package dev.tom.moveyapi.regions;

import dev.tom.moveyapi.utils.MathHelper;
import dev.tom.moveyapi.utils.RegionPoints;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.*;

public class SquareRegion extends AbstractRegion {

    public SquareRegion(List<Block> blocks) {
        super(blocks);
    }

    @Override
    public List<Block> getFillingBlocks() {
        List<Block> blocks = new ArrayList<>();
        for (int x = getXMin().getX(); x <= getXMax().getX(); x++) {
            for (int z = getZMin().getZ(); z <= getZMax().getZ(); z++) {
                blocks.add(getWorld().getBlockAt(x, getYMin().getY(), z));
            }
        }
        return blocks;
    }


    /**
     * Finds the largest square frame possible from the block list provided
     * @return
     */
    @Override
    public List<Block> getFrameBlocks(){
        List<Block> blocks = new ArrayList<>();
        for (int x = getXMin().getX(); x <= getXMax().getX(); x++) {
            blocks.add(getWorld().getBlockAt(x, getYMin().getY(), getZMax().getZ()));
            blocks.add(getWorld().getBlockAt(x, getYMin().getY(), getZMin().getZ()));
        }
        for (int z = getZMin().getZ(); z <= getZMax().getZ(); z++) {
            blocks.add(getWorld().getBlockAt(getXMax().getX(), getYMin().getY(), z));
            blocks.add(getWorld().getBlockAt(getXMin().getX(), getYMin().getY(), z));
        }
        return blocks;
    }

    @Override
    public Collection<Block> getCornerBlocks() {
        return null;
    }
}
