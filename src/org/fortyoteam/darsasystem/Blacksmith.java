package org.fortyoteam.darsasystem;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.SmithingRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.fortyoteam.darsasystem.events.CraftItem;
import org.fortyoteam.darsasystem.events.PlayerPickupItem;
import org.fortyoteam.darsasystem.events.SmithingTable;

import java.util.*;

public class Blacksmith implements CommandExecutor {
    public static Inventory blacksmithGui;
    public static HashMap<Integer, String> tier;
    static {
        tier = new HashMap<>();
        tier.put(0, "C");
        tier.put(1, "B");
        tier.put(2, "A");
        tier.put(3, "S");
        tier.put(4, "S+");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player)sender;


        Inventory blacksmithGui = Bukkit.createInventory(null, InventoryType.SMITHING);
        player.openInventory(blacksmithGui);


        return false;
    }

//    public static void initRecipe(Main main) {
//        SmithingRecipe netheriteSword = new SmithingRecipe(new NamespacedKey(main, "netheriteSword"),
//                new ItemStack(Material.NETHERITE_SWORD),
//                new RecipeChoice.MaterialChoice(Material.DIAMOND_SWORD),
//                new RecipeChoice.MaterialChoice(Material.AMETHYST_SHARD)
//        );
//
//        Bukkit.addRecipe(netheriteSword);
//    }
//
    public static void setItemTier(PlayerPickupItemEvent e) {
         ItemStack item = e.getItem().getItemStack();
         String itemId =  item.getType().name();
         ItemMeta meta = item.getItemMeta();
         List<String> lore = new ArrayList<>();

        String[] tierCItems = {"IRON", "WOODEN", "STONE"};
        String[] tierBItems = {"GOLDEN"};
        String[] tierAItems = {"DIAMOND"};
        String[] tierSItems = {"NETHERITE"};
        String[] tierSPlusItems = {};

        for (String tieritem : tierCItems) {
            if (itemId.contains(tieritem)) {
                if (item.getEnchantments().size() > 0) {
                    lore.add(ChatColor.BOLD + tier.get(1));
                } else {
                    lore.add(ChatColor.BOLD + tier.get(0));
                    
                }
            }
        }

//         for (String tierItem : tierCItems) {
//             if (itemId.contains(tierItem) && item.getEnchantments().size() < 1) {
//                 lore.add(ChatColor.BOLD + "Tier C");
//
//             }
//         }
//         for (String tierItem : tierBItems) {
//             if (itemId.contains("IRON") && item.getEnchantments().size() > 0) {
//                 lore.add(ChatColor.BLUE + "" +ChatColor.BOLD + "Tier B");
//             }
//         }
//        for (String tierItem : tierAItems) {
//            if (itemId.contains(tierItem) && item.getEnchantments().size() < 1) {
//                lore.add(ChatColor.GOLD + "" +ChatColor.BOLD + "Tier A");
//            }
//        }
//        for (String tierItem : tierSItems) {
//            if (itemId.contains(tierItem) && item.getEnchantments().size() < 1) {
//                lore.add(ChatColor.LIGHT_PURPLE + "" +ChatColor.BOLD + "Tier S");
//            }
//        }
//        for (String tierItem : tierSPlusItems) {
//            if (itemId.contains(tierItem) && item.getEnchantments().size() < 1) {
//                lore.add(ChatColor.RED + "" +ChatColor.BOLD + "Tier S+");
//            }
//        }
         meta.setLore(lore);
         item.setItemMeta(meta);
    }

}
