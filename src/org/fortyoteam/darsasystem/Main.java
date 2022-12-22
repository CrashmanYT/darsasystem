package org.fortyoteam.darsasystem;

import org.bukkit.plugin.java.JavaPlugin;
import org.fortyoteam.darsasystem.completer.*;
import org.fortyoteam.darsasystem.events.*;

import java.util.ArrayList;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("buff").setExecutor(new Buff());
        getCommand("buff").setTabCompleter(new BuffCompleter());

        getCommand("shop").setExecutor(new Shop());

        getCommand("blacksmith").setExecutor(new Blacksmith());


        getServer().getPluginManager().registerEvents(new PlayerInteract(), this);
        getServer().getPluginManager().registerEvents(new PlayerPickupItem(), this);
        getServer().getPluginManager().registerEvents(new PlayerDropItem(), this);
        getServer().getPluginManager().registerEvents(new InventoryClick(), this);
        getServer().getPluginManager().registerEvents(new InventoryMove(), this);
        getServer().getPluginManager().registerEvents(new InventoryInteract(), this);
        getServer().getPluginManager().registerEvents(new SmithingTable(), this);
        getServer().getPluginManager().registerEvents(new CraftItem(), this);
        getServer().getPluginManager().registerEvents(new PrepareAnvil(), this);
        getServer().getPluginManager().registerEvents(new PrepareItemCraft(), this);
        getServer().getPluginManager().registerEvents(new PrepareSmithing(), this);
    }


}
