package com.nijikokun.bukkit.Permissions;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

/**
 * Permissions 2.x Copyright (C) 2011 Matt 'The Yeti' Burnett
 * <admin@theyeticave.net> Original Credit & Copyright (C) 2010 Nijikokun
 * <nijikokun@gmail.com>
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Permissions Public License as published by the Free
 * Software Foundation, either version 2 of the License, or (at your option) any
 * later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Permissions Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Permissions Public License along
 * with this program. If not, see <http://www.gnu.org/licenses/>.
 */

public class Listener implements org.bukkit.event.Listener {
    @SuppressWarnings("unused")
    private final Permissions plugin;

    public Listener(final Permissions plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onBlockPlace(BlockPlaceEvent event) {
        final Player player = event.getPlayer();
        final World world;

        world = player.getWorld();
        try {
            if (((Permissions) Permissions.instance).getHandler().safeGetUser(world.getName(),
                    player.getName()).canBuild())
                return;
        } catch (Exception e) {
            e.printStackTrace();
        }

        event.setBuild(false);
        return;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onBlockBreak(BlockBreakEvent event) {
        final Player player = event.getPlayer();
        final World world;

        world = player.getWorld();
        try {
            if (((Permissions) Permissions.instance).getHandler().safeGetUser(world.getName(),
                    player.getName()).canBuild())
                return;
        } catch (Exception e) {
            e.printStackTrace();
        }

        event.setCancelled(true);
        return;
    }
}
