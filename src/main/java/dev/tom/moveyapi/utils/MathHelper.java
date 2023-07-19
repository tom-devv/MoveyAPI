package dev.tom.moveyapi.utils;

import org.bukkit.block.Block;

import java.util.Comparator;
import java.util.List;

public class MathHelper {

    public static int[] widthLength(List<Block> blocks){
        int width = ( blocks.stream()
                .mapToInt(b -> b.getLocation().getBlockX()).min().getAsInt() )
                -
                (blocks.stream()
                        .mapToInt(b -> b.getLocation().getBlockX()).max().getAsInt());

        int length = ( blocks.stream()
                .mapToInt(b -> b.getLocation().getBlockZ()).min().getAsInt() )
                -
                (blocks.stream()
                        .mapToInt(b -> b.getLocation().getBlockZ()).max().getAsInt());


        return new int[]{width, length};
    }

    public static RegionPoints getMaxPoints(List<Block> blocks){
        Block xMin, xMax, yMin, yMax, zMin, zMax;
        xMin = blocks.stream().min(Comparator.comparingInt(b -> b.getLocation().getBlockX())).get();
        xMax = blocks.stream().max(Comparator.comparingInt(b -> b.getLocation().getBlockX())).get();
        yMin = blocks.stream().min(Comparator.comparingInt(b -> b.getLocation().getBlockY())).get();
        yMax = blocks.stream().max(Comparator.comparingInt(b -> b.getLocation().getBlockY())).get();
        zMin = blocks.stream().min(Comparator.comparingInt(b -> b.getLocation().getBlockZ())).get();
        zMax = blocks.stream().max(Comparator.comparingInt(b -> b.getLocation().getBlockZ())).get();

//        System.out.println(xMax  + " " +  xMin  + " " +   zMax + " " + zMin);
        return new RegionPoints(xMax, xMin, yMax, yMin, zMax, zMin);
    }

    public static int getLowestBlock(List<Block> blocks){
        return blocks.stream().min(Comparator.comparingInt(b -> b.getLocation().getBlockY())).get().getY();
    }
}
