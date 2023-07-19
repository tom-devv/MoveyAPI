package dev.tom.moveyapi.utils;

import org.bukkit.block.Block;

public class RegionPoints {


    private final Block xMax, xMin, yMax, yMin, zMax, zMin;

    public RegionPoints(Block xMax, Block xMin, Block yMax, Block yMin, Block zMax, Block zMin) {
        this.xMax = xMax;
        this.xMin = xMin;
        this.zMax = zMax;
        this.zMin = zMin;
        this.yMax = yMax;
        this.yMin = yMin;
    }

    public Block getxMax() {
        return xMax;
    }

    public Block getxMin() {
        return xMin;
    }

    public Block getzMax() {
        return zMax;
    }

    public Block getzMin() {
        return zMin;
    }

    public Block getyMax() {
        return yMax;
    }

    public Block getyMin() {
        return yMin;
    }
}
