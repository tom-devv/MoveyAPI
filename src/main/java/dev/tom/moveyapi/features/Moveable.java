package dev.tom.moveyapi.features;

import org.bukkit.World;

public interface Moveable {

    int getPeriod();
    boolean oscillate();
    void move();

}
