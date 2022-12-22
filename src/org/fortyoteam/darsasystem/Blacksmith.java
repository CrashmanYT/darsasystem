package org.fortyoteam.darsasystem;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
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
        tiers.put("(1) " + "Tier C", new String[] {"WOOD", "STONE", "IRON"});
        tiers.put( "(2) " + ChatColor.BLUE + "" + ChatColor.BOLD + "Tier B", new String[] {"GOLD", "BOW"});
        tiers.put( "(3) " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Tier A", new String[] {"DIAMOND", "CROSSBOW"});
        tiers.put( "(4) " + ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Tier S", new String[] {"NETHERITE"});
        tiers.put( "(5) " + ChatColor.RED + "" + ChatColor.BOLD + "Tier S+", new String[] {});
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

    /**
     *
     * Event that used this function :
     * - InventoryClick
     * - PrepareItemCraft
     * - PrepareAnvil
     * - PrepareSmithing
     * - PlayerPickupItem
     *
     */
    public static Object[] setItemTier(Player player, ItemStack e, boolean cancel) {
         ItemStack item = e;
         String itemId =  item.getType().name();
         ItemMeta meta = item.getItemMeta();
         List<String> lore = new ArrayList<>();
         StringBuilder test = new StringBuilder();
//
         for (String tier : tiers.keySet()) {
             for (String tierItem : tiers.get(tier)) {
                 if (!itemId.contains(tierItem)) continue;
                 if (item.getEnchantments().size() > 0) {
                     lore.add((!tier.contains("S+") ? tiers.higherKey(tier) : tier));
                 } else {
                     lore.add(tier);
                 }

                 meta.setLore(lore);
                 item.setItemMeta(meta);

                 // if setCancelled true, give item to player
                 if (cancel) return new Object[] {cancel, player.getInventory().addItem(item)};

                // return [Cancel condition, item]
                 return new Object[] {cancel, item};
             }
         }
         return new Object[] {cancel, item};

    }

}
