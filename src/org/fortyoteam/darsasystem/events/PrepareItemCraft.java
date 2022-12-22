package org.fortyoteam.darsasystem.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.fortyoteam.darsasystem.Blacksmith;

public class PrepareItemCraft implements Listener {

    @EventHandler
    public void onPrepareItemCraft(PrepareItemCraftEvent e) {
        e.getInventory().setResult((ItemStack) Blacksmith.setItemTier((Player) e.getView().getPlayer(), e.getInventory().getResult(), false)[1]);
    }
}
