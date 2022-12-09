package org.fortyoteam.darsasystem.config;

import net.md_5.bungee.api.ChatColor;
import org.fortyoteam.darsasystem.CustomItem;
import org.fortyoteam.darsasystem.DarsaItemCommand;
import org.fortyoteam.darsasystem.enums.DarsaItem;
import org.fortyoteam.darsasystem.enums.ErrorMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// All Public Variables & Constant Stores here
public class DarsaConfig {
    public static String SYSTEM_NAME = ChatColor.GRAY + "" + ChatColor.GREEN + ChatColor.BOLD + "Darsa" + ChatColor.GOLD + ChatColor.BOLD + "System" + ChatColor.WHITE + ChatColor.BOLD + " >> ";
    public static final Map<ErrorMessage, String> ERROR_MESSAGE;
    static {
        ERROR_MESSAGE = new HashMap<>();
        ERROR_MESSAGE.put(ErrorMessage.EMPTY_ARGUMENTS, DarsaConfig.SYSTEM_NAME + org.bukkit.ChatColor.RED + "Ditemukan Argumen yang tidak terisi");
    }
    public static Map<DarsaItem, CustomItem> DARSA_ITEM = new HashMap<DarsaItem, CustomItem>();

}
