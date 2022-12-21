package org.fortyoteam.darsasystem;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.SmithingRecipe;
import org.fortyoteam.darsasystem.events.SmithingTable;

public class Blacksmith implements CommandExecutor {
    public static Inventory blacksmithGui;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player)sender;


        Inventory blacksmithGui = Bukkit.createInventory(null, InventoryType.SMITHING);
        player.openInventory(blacksmithGui);


        return false;
    }

    public static void initRecipe(Main main) {
        SmithingRecipe netheriteSword = new SmithingRecipe(new NamespacedKey(main, "netheriteSword"),
                new ItemStack(Material.AIR),
                new RecipeChoice.MaterialChoice(Material.DIAMOND_SWORD),
                new RecipeChoice.MaterialChoice(Material.AMETHYST_SHARD)
        );

        Bukkit.addRecipe(netheriteSword);
    }
}
