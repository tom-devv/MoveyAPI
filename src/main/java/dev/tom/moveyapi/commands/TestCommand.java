package dev.tom.moveyapi.commands;

import dev.tom.moveyapi.movements.impl.BlockRise;
import dev.tom.moveyapi.movements.enums.MovementDirection;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        Player player = (Player) commandSender;

        BlockRise blockRise = new BlockRise(MovementDirection.UP,  AddBlock.blocks);

//        for (Block frameBlock : blockRise.getRegion().getFillingBlocks()) {
//            player.sendBlockChange(frameBlock.getLocation(), Material.GLASS, (byte) 0);
//        }

        return true;
    }
}
