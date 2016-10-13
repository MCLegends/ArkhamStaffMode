package net.bawkn.arkhamstaffmode.commands;

import net.bawkn.arkhamstaffmode.ArkhamStaffMode;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.print.attribute.HashPrintJobAttributeSet;
import java.util.HashMap;

public class StaffModeCommand implements CommandExecutor {

    private ArkhamStaffMode instance;
    private static HashMap<Player, ItemStack[]> inventory = new HashMap<Player, ItemStack[]>();
    private static HashMap<Player, ItemStack[]> armor = new HashMap<Player, ItemStack[]>();

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("staffmode")) {
            if(!(sender instanceof Player)) {
                instance.getLogger().info("Console cannot enter staff mode.");
                return true;
            }
            Player player = (Player)sender;
            if(!player.hasPermission("arkhamstaffmode.use")) {
                player.sendMessage(ChatColor.RED + "You are not allowed to use this command.");
                return true;
            }
            if(!instance.enabled.containsKey(player.getUniqueId())) {
                instance.enabled.put(player.getUniqueId(), player.getName());
                inventory.put(player, player.getInventory().getContents());
                armor.put(player, player.getInventory().getArmorContents());

            }
        }
        return false;
    }
}
