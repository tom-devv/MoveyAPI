package dev.tom.moveyapi.commands;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class AddBlock implements CommandExecutor {

    public static List<Block> blocks = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        Player player = (Player) commandSender;
        int px = player.getLocation().getBlockX();
        int py = player.getLocation().getBlockY();
        int pz = player.getLocation().getBlockZ();

        int radius = 50;
        World world = player.getWorld();

        for (int x = px - radius; x < radius + px; x++) {
            for (int y = py - radius; y < radius + py; y++) {
                for (int z = pz - radius; z < radius + pz; z++) {
                    Block b= world.getBlockAt(x,y,z);
                    if(b.getType().equals(Material.WHITE_WOOL)){
                        blocks.add(b);
                    }
                }
            }
        }

        return true;
    }
}


