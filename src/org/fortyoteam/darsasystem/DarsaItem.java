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
import org.fortyoteam.darsasystem.enums.DItemMeta;
import org.fortyoteam.darsasystem.enums.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DarsaItem implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(DarsaConfig.ERROR_MESSAGE.get(ErrorMessage.EMPTY_ARGUMENTS));
            return true;
        }
        if (args[0].equals("frostsword")) {
            Map<DItemMeta, Object> meta = Map.ofEntries(
                    Map.entry(DItemMeta.DISPLAYNAME, ChatColor.BLUE + "" + ChatColor.BOLD + "Frost Sword"),
                    Map.entry(DItemMeta.LORE, Arrays.asList("The mystical sword once wielded by the " + ChatColor.BLUE + ChatColor.BOLD + "Ice Lord", "frost_sword"))
            );
            new CustomItem(new ItemStack(Material.DIAMOND_SWORD), meta, sender, args).giveItem();
            return true;
        }
        if (args[0].equals("phoenixaxe")) {
            Map<DItemMeta, Object> meta = Map.ofEntries(
                    Map.entry(DItemMeta.DISPLAYNAME, ChatColor.RED  + "" + ChatColor.BOLD + "Phoenix Axe"),
                    Map.entry(DItemMeta.LORE, Arrays.asList("The mystical sword once wielded by the " + ChatColor.RED + ChatColor.BOLD + "Fire Lord", "phoenix_axe"))
            );
            new CustomItem(new ItemStack(Material.NETHERITE_AXE), meta, sender, args).giveItem();
        }
        return false;
    }

}
