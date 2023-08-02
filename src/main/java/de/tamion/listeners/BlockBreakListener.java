package de.tamion.listeners;

import de.tamion.TreeGoBoom;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {
     @EventHandler
     public void onBlockBreak(BlockBreakEvent e) {
         if(e.getBlock().getType().toString().contains("LOG")) {
             e.getBlock().getWorld().createExplosion(e.getBlock().getLocation(), TreeGoBoom.getPlugin().getConfig().getInt("boompower"));
         }
     }
}
