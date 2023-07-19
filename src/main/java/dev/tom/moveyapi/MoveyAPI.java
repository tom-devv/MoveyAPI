package dev.tom.moveyapi;

import dev.tom.moveyapi.commands.AddBlock;
import dev.tom.moveyapi.commands.TestCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class MoveyAPI extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("addblock").setExecutor(new AddBlock());
        this.getCommand("test").setExecutor(new TestCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
