package org.fortyoteam.darsasystem;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.fortyoteam.darsasystem.config.DarsaConfig;
import org.fortyoteam.darsasystem.enums.ErrorMessage;

import java.util.Arrays;
import java.util.List;

public class CustomItems implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(DarsaConfig.ERROR_MESSAGE.get(ErrorMessage.EMPTY_ARGUMENTS));
            return true;
        }
        if (args[0].equals("frostsword")) {
            int amount = 1;
            if (args.length > 1)
                amount = Integer.parseInt(args[1]);
            Player player = (Player) sender;
            ItemStack frostSword = new ItemStack(Material.DIAMOND_SWORD, amount);


            // Set Frost Sword Meta
            ItemMeta fsMeta = frostSword.getItemMeta();
            fsMeta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "Frost Sword");
            fsMeta.setLore(Arrays.asList("The mystical sword once wielded by the " + ChatColor.BLUE + ChatColor.BOLD + "Ice Lord", "\n" ,"frost_sword"));
            frostSword.setItemMeta(fsMeta);

            player.getInventory().addItem(frostSword);
            sender.sendMessage("Gave Frost Sword to player");

            return true;
        }
        if (args[0].equals("phoenixaxe")) {
            int amount = 1;
            if (args.length > 1)
                amount = Integer.parseInt(args[1]);
            Player player = (Player) sender;
        }
        return false;
    }
}
