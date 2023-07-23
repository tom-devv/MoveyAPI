package dev.tom.moveyapi.utils;

import dev.tom.moveyapi.movements.enums.MovementDirection;
import org.bukkit.block.Block;
import org.bukkit.util.Vector;

import java.util.Comparator;
import java.util.List;

public class MathHelper {


    public static RegionPoints getMaxPoints(List<Block> blocks){
        Block xMin, xMax, yMin, yMax, zMin, zMax;
        xMin = blocks.stream().min(Comparator.comparingInt(b -> b.getLocation().getBlockX())).get();
        xMax = blocks.stream().max(Comparator.comparingInt(b -> b.getLocation().getBlockX())).get();
        yMin = blocks.stream().min(Comparator.comparingInt(b -> b.getLocation().getBlockY())).get();
        yMax = blocks.stream().max(Comparator.comparingInt(b -> b.getLocation().getBlockY())).get();
        zMin = blocks.stream().min(Comparator.comparingInt(b -> b.getLocation().getBlockZ())).get();
        zMax = blocks.stream().max(Comparator.comparingInt(b -> b.getLocation().getBlockZ())).get();

        return new RegionPoints(xMax, xMin, yMax, yMin, zMax, zMin);
    }

    public static Vector getMovementVector(MovementDirection face) {
        switch (face) {
            case NORTH: {
                return new Vector(0, 0, -1);
            }
            case SOUTH: {
                return new Vector(0, 0, 1);
            }
            case EAST: {
                return new Vector(1, 0, 0);
            }
            case WEST: {
                return new Vector(-1, 0, 0);
            }
            case UP: {
                return new Vector(0, 1, 0);
            }
            case DOWN: {
                return new Vector(0, -1, 0);
            }
        }
        return null;
    }

}
