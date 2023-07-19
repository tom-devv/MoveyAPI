package dev.tom.moveyapi.movements.impl;

import dev.tom.moveyapi.movements.AbstractBlockMovement;
import dev.tom.moveyapi.movements.enums.MovementDirection;
import org.bukkit.block.Block;

import java.util.List;

public class BlockRise extends AbstractBlockMovement {


    public BlockRise(MovementDirection direction, List<Block> blocks) {
        super(direction, blocks);
    }


    @Override
    public boolean oscillate() {
        return false;
    }
}
