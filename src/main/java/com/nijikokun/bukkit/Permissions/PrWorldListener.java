package com.nijikokun.bukkit.Permissions;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.world.WorldLoadEvent;

public class PrWorldListener implements org.bukkit.event.Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void onWorldLoad(WorldLoadEvent event) {
        try {
            ((Permissions) Permissions.instance).getHandler().loadWorld(event.getWorld().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
