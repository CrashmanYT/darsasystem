package org.fortyoteam.darsasystem;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.fortyoteam.darsasystem.enums.DItemMeta;

import java.util.List;
import java.util.Map;

public class CustomItem {
    ItemStack item;
    ItemMeta meta;
    CommandSender sender;
    String[] args;
    public CustomItem(ItemStack item, Map<DItemMeta, Object> meta, CommandSender sender, String[] args) {

        this.meta = item.getItemMeta();

        int amount = 1;
        if (args.length > 1) {
            amount = Integer.parseInt(args[1]);
        }
        item.setAmount(amount);
        this.meta.setDisplayName((String) meta.get(DItemMeta.DISPLAYNAME));
        this.meta.setLore((List<String>) meta.get(DItemMeta.LORE));
        item.setItemMeta(this.meta);

        this.item = item;
        this.sender = sender;
        this.args = args;
    }

    public void giveItem() {
        Player player = (Player) sender;
        player.getInventory().addItem(this.item);
        player.sendMessage("Gave " + this.item.getItemMeta().getDisplayName() + ChatColor.RESET +  " To " + ChatColor.GREEN + player.getName());
    }
}
