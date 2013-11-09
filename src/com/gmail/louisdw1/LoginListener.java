package com.gmail.louisdw1;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public final class LoginListener implements Listener {
    @EventHandler
    public void normalLogin(PlayerLoginEvent event) {
    	Player player = event.getPlayer(); 
        player.sendMessage("Welcome!");    
    }
    @EventHandler(priority = EventPriority.HIGH)
    public void highLogin(PlayerLoginEvent event) {
    	Player player = event.getPlayer(); 
        player.sendMessage("Welcome!");    
    }
}
