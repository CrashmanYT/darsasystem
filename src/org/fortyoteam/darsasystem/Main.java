package org.fortyoteam.darsasystem;

import org.bukkit.plugin.java.JavaPlugin;
import org.fortyoteam.darsasystem.completer.*;
import org.fortyoteam.darsasystem.events.InventoryClick;
import org.fortyoteam.darsasystem.events.PlayerInteract;
import org.fortyoteam.darsasystem.events.SmithingTable;

import java.util.ArrayList;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("buff").setExecutor(new Buff());
        getCommand("buff").setTabCompleter(new BuffCompleter());

        getCommand("shop").setExecutor(new Shop());

        getCommand("blacksmith").setExecutor(new Blacksmith());

        Blacksmith.initRecipe(this);

        getServer().getPluginManager().registerEvents(new PlayerInteract(), this);
        getServer().getPluginManager().registerEvents(new InventoryClick(), this);
        getServer().getPluginManager().registerEvents(new SmithingTable(), this);

    }


}
