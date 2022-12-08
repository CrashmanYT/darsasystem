package org.fortyoteam.darsasystem.events;


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.fortyoteam.darsasystem.config.DarsaConfig;

public class PlayerInteract implements Listener {

    @EventHandler
    public void onPlayerUse(PlayerInteractEvent event) {
        Player p = event.getPlayer();

        if (p.getItemInHand().getItemMeta().getLore().get(2).equals("frost_sword")) {
            for (Player player : p.getServer().getOnlinePlayers()) {
                player.sendMessage(DarsaConfig.SYSTEM_NAME + ChatColor.GOLD + ChatColor.BOLD + p.getName() +  ChatColor.GREEN +" Mengaktifkan Kemampuan " + ChatColor.BLUE + ChatColor.BOLD + "Ice Capsule");
            }
        }
    }

}
