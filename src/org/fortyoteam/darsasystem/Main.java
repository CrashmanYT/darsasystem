package org.fortyoteam.darsasystem;

import org.bukkit.plugin.java.JavaPlugin;
import org.fortyoteam.darsasystem.completer.*;
import org.fortyoteam.darsasystem.events.InventoryClick;
import org.fortyoteam.darsasystem.events.PlayerInteract;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("buff").setExecutor(new Buff());
        getCommand("buff").setTabCompleter(new BuffCompleter());

        getCommand("shop").setExecutor(new Shop());


        getServer().getPluginManager().registerEvents(new PlayerInteract(), this);
        getServer().getPluginManager().registerEvents(new InventoryClick(), this);

    }


}
