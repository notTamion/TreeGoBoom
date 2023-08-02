package de.tamion;

import de.tamion.commands.SetTreeExplosionPower;
import de.tamion.listeners.BlockBreakListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class TreeGoBoom extends JavaPlugin {

    private static TreeGoBoom plugin;

    @Override
    public void onEnable() {
        plugin = this;
        PluginManager pluginManager = Bukkit.getPluginManager();
        saveDefaultConfig();
        pluginManager.registerEvents(new BlockBreakListener(), this);

        getCommand("settreeexplosionpower").setExecutor(new SetTreeExplosionPower());
    }

    public static TreeGoBoom getPlugin() {
        return plugin;
    }
}
