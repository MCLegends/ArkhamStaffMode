package net.bawkn.arkhamstaffmode;

import net.bawkn.arkhamstaffmode.listeners.CreativeDisable;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public class ArkhamStaffMode extends JavaPlugin {

    public static HashMap<UUID, String> enabled = new HashMap<UUID, String>();

    @Override
    public void onEnable() {
        super.getServer().getPluginManager().registerEvents(new CreativeDisable(), this);
    }
}
