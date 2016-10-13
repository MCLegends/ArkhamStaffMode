package net.bawkn.arkhamstaffmode.listeners;

import net.bawkn.arkhamstaffmode.ArkhamStaffMode;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class CreativeDisable implements Listener {

    private static ArkhamStaffMode instance;

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        if(instance.enabled.containsKey(player)) {
            player.sendMessage(ChatColor.RED + "You cannot drop items while in staff mode.");
            event.setCancelled(true);
        }
    }
}
