package dev.tom.moveyapi;

import dev.tom.moveyapi.commands.AddBlock;
import dev.tom.moveyapi.commands.TestCommand;
import dev.tom.moveyapi.features.Moveable;
import org.bukkit.plugin.java.JavaPlugin;

public final class MoveyAPI extends JavaPlugin {

    public static MoveyAPI instance;

    @Override
    public void onEnable() {
        instance = this;

        this.getCommand("addblock").setExecutor(new AddBlock());
        this.getCommand("test").setExecutor(new TestCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static MoveyAPI getInstance() {
        return instance;
    }
}
