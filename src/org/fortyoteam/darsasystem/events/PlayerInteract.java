package org.fortyoteam.darsasystem.events;


import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.fortyoteam.darsasystem.DarsaItem;
import org.fortyoteam.darsasystem.files.ItemConfig;

public class PlayerInteract implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {

        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            boolean isDarsaItem = false;
            for (String key : ItemConfig.get().getKeys(false)) {
                String item = ItemConfig.get().getString(key + ".DisplayName");
                isDarsaItem = e.getItem().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&',item));
                if (isDarsaItem) DarsaItem.setEvent(e, key);
            }
        }

    }


}
