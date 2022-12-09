package org.fortyoteam.darsasystem;

import org.bukkit.plugin.java.JavaPlugin;
import org.fortyoteam.darsasystem.completer.*;
import org.fortyoteam.darsasystem.events.PlayerInteract;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("buff").setExecutor(new Buff());
        getCommand("buff").setTabCompleter(new BuffCompleter());

        getCommand("darsaitem").setExecutor(new DarsaItem());
        getCommand("darsaitem").setTabCompleter(new CustomItemsCompleter());

        getServer().getPluginManager().registerEvents(new PlayerInteract(), this);
    }


}
