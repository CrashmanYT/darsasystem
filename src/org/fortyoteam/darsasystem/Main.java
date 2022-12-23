package org.fortyoteam.darsasystem;

import org.bukkit.plugin.java.JavaPlugin;
import org.fortyoteam.darsasystem.completer.*;
import org.fortyoteam.darsasystem.events.*;
import org.fortyoteam.darsasystem.files.ItemConfig;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {

        // Load Config
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        ItemConfig.setup();
        ItemConfig.get().options().copyDefaults(true);
        ItemConfig.save();

        // Config Commands
        getCommand("dsr").setExecutor(new Reload());


        getCommand("buff").setExecutor(new Buff());
        getCommand("buff").setTabCompleter(new BuffCompleter());

        getCommand("blacksmith").setExecutor(new Blacksmith());

        getCommand("darsaitem").setExecutor(new DarsaItem());
        getCommand("darsaitem").setTabCompleter(new DarsaItemsCompleter());

        getCommand("darsahelp").setExecutor(new Help(this));

        getCommand("shop").setExecutor(new Shop());



        getServer().getPluginManager().registerEvents(new PlayerInteract(), this);
        getServer().getPluginManager().registerEvents(new PlayerPickupItem(), this);
        getServer().getPluginManager().registerEvents(new PlayerDropItem(), this);
        getServer().getPluginManager().registerEvents(new InventoryClick(), this);
        getServer().getPluginManager().registerEvents(new InventoryMove(), this);
        getServer().getPluginManager().registerEvents(new InventoryOpen(), this);
        getServer().getPluginManager().registerEvents(new InventoryDrag(), this);
        getServer().getPluginManager().registerEvents(new SmithingTable(), this);
        getServer().getPluginManager().registerEvents(new CraftItem(), this);
        getServer().getPluginManager().registerEvents(new PrepareAnvil(), this);
        getServer().getPluginManager().registerEvents(new PrepareItemCraft(), this);
        getServer().getPluginManager().registerEvents(new PrepareSmithing(), this);


    }


}
