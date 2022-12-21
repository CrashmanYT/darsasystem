package org.fortyoteam.darsasystem;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Shop implements CommandExecutor {
    public static Inventory shopGui;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            shopGui = Bukkit.createInventory(null, 54 ,ChatColor.DARK_GREEN + "" + ChatColor.ITALIC + ChatColor.BOLD + "Darsa" + ChatColor.GOLD + ChatColor.ITALIC + ChatColor.BOLD +" Shop");

            try {
                shopGui.setItem(10, AddItem(Material.END_STONE, 64, 1));
                shopGui.setItem(11, AddItem(Material.NETHERRACK, 64, 1));
                shopGui.setItem(12, AddItem(Material.SPONGE, 3, 7));
                shopGui.setItem(13, AddItem(Material.CHISELED_QUARTZ_BLOCK, 32, 6));
                shopGui.setItem(14, AddItem(Material.QUARTZ_BLOCK, 32, 5));
                shopGui.setItem(15, AddItem(Material.QUARTZ_PILLAR, 16, 4));
                shopGui.setItem(16, AddItem(Material.GLOWSTONE, 8, 1));

            } catch (Exception ignored) {

            }

            ((Player) sender).openInventory(shopGui);

        }
        return false;
    }

    private ItemStack AddItem(Material i, int count ,int price) {
        ItemStack item = new ItemStack(i);
        item.setAmount(count);

        ItemMeta meta = item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Price : " + ChatColor.GOLD + price + " Gold");
        meta.setLore(lore);

        item.setItemMeta(meta);


        return item;
    }
}

