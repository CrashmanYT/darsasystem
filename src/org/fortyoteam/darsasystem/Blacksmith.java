package org.fortyoteam.darsasystem;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class Blacksmith implements CommandExecutor {
    public static Inventory blacksmithGui;
    public static NavigableMap<String, String[]> tiers;
    static {
        tiers = new TreeMap<String, String[]>();
        tiers.put(ChatColor.RED + "" + ChatColor.BOLD + "Tier S+", new String[] {});
        tiers.put(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Tier S", new String[] {"NETHERITE"});
        tiers.put(ChatColor.YELLOW + "" + ChatColor.BOLD + "Tier A", new String[] {"DIAMOND", "CROSSBOW"});
        tiers.put(ChatColor.BLUE + "" + ChatColor.BOLD + "Tier B", new String[] {"GOLD", "BOW"});
        tiers.put("Tier C", new String[] {"WOOD", "STONE", "IRON"});
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
         e.getPlayer().sendMessage(itemId);

         for (String tier : tiers.keySet()) {
             for (String tierItem : tiers.get(tier)) {
                 if (itemId.contains(tierItem)) {
                     e.getPlayer().sendMessage("" + item.getEnchantments().size());
                     if (item.getEnchantments().size() > 0) {
//                         if (lore.isEmpty()) lore.add(tiers.higherKey(tier));
                         lore.set(0, tiers.higherKey(tier));
                     } else {
                         if (lore.isEmpty()) lore.add(tier);
                         lore.set(0, tier);
                     }

                     meta.setLore(lore);
                     item.setItemMeta(meta);
                     return;
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

    }

}
