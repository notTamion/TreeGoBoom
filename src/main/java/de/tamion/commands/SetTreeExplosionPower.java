package de.tamion.commands;

import de.tamion.TreeGoBoom;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

public class SetTreeExplosionPower implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if(!sender.hasPermission("treegoboom.setpower")) {
            sender.sendMessage("You may not boom");
            return false;
        }
        FileConfiguration config = TreeGoBoom.getPlugin().getConfig();
        if(args.length != 1) {
            sender.sendMessage("No Boom for your invalid Stuff");
            return false;
        }
        try {
            config.set("boompower", Integer.parseInt(args[0]));
            TreeGoBoom.getPlugin().saveConfig();
            sender.sendMessage("Set Explosion Power to " + args[0]);
        } catch (NumberFormatException e) {
            System.out.println("No good power");
        }
        return false;
    }
}
