package org.fortyoteam.darsasystem.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.fortyoteam.darsasystem.Blacksmith;

public class PlayerPickupItem implements Listener {

    @EventHandler
    public void onPlayerPickupItemEvent(PlayerPickupItemEvent e) {
        Blacksmith.setItemTier(e);
    }
}
