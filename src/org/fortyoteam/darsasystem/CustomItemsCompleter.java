package org.fortyoteam.darsasystem;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class CustomItemsCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 1) {
            List<String> itemNames = new ArrayList<>();
            itemNames.add("frostsword");
            return itemNames;
        }
        return null;
    }
}
