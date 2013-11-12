package com.gmail.louisdw1;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.world.WorldEvent;

public class Listener2 implements Listener{
	@EventHandler
public void move(PlayerMoveEvent event)
{
	Player player = event.getPlayer();
	World currentWorld = player.getWorld();
	Location loc = player.getLocation();
    Location nloc = new Location(currentWorld, loc.getX(), loc.getY()-1, loc.getZ());

	if((nloc.getBlock()).getType().equals(Material.MELON_BLOCK))
	{
		upgrading.candamageTrue(player);
	}
}
}
