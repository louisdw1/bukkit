package com.gmail.louisdw1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

import com.sun.org.apache.xpath.internal.operations.String;

public final class upgrading extends JavaPlugin implements Listener,Serializable{
	/*Note:
	 * lowest tier = 0
	 * 
	 * #######################
	 * #####Variables########
	 * #######################
	 */
	/*How many tiers (max) does a player go if he/she is killed
	 *  HIGH RISK OF CHANGE
	*/
	int humil = 5;
	
	/*#######################
	 * ########Code##########
	 * #######################
	 */
	
	
	/*Usage:
	 * tierScore(Player killer, Player victim)
	 *Updates a players score.
	 */
	public void tierScore(Player killer1, Player victim1)
	{
		java.lang.String killer = killer1.getName();		//TEST
		java.lang.String victim = victim1.getName();		//TEST


		int vicOld = tier.get(victim);
		int killOld = tier.get(killer);

		tier.put(killer, killOld+1);
		if(vicOld<humil)
		{
			tier.put(victim, 0);
		}else {
			tier.put(victim, vicOld-5);
		}
        victim1.sendMessage(ChatColor.RED +"You have died! Your new tier is: "+tier.get(victim));
        killer1.sendMessage(ChatColor.YELLOW +"You have killed a player! Your new tier is: "+tier.get(killer));

		SetInv.main(killer1,tier.get(killer));
		SetInv.main(victim1,tier.get(victim));

	}
	public Map<java.lang.String, Integer> tier = new HashMap<java.lang.String, Integer>(); 

	@Override
	    public void onEnable(){
		Bukkit.broadcastMessage(ChatColor.YELLOW + ("Progression loaded!"));
		try{
			tier = SLAPI.load("tier.bin");
	            }catch(Exception e){
	                //handle the exception
	                e.printStackTrace();
	            }
		  getLogger().info("onEnable has been invoked!"); 
	        getServer().getPluginManager().registerEvents(this, this);
			  getLogger().info("Listener enabled!"); 
			  
			  
		  // playerList.put(player, playerData(player));
			  
	  }
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
	if (e.getEntityType() == EntityType.PLAYER) {
		
	Player player = e.getEntity();
	player.setExp(0);
	//e.getEntity().openInventory();
	Player killer1 = player.getKiller();
	java.lang.String killer = killer1.getName();		//TEST

	if(tier.containsKey(killer)==true)
	{

	tierScore(killer1, player);

	}

	}
	}
	@EventHandler
public void onRespawn(PlayerRespawnEvent event)
	{

		Player player1 = event.getPlayer(); 

		java.lang.String player = player1.getName();	
		SetInv.main(player1,tier.get(player));

	}
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent evt) {
		evt.setJoinMessage(""); 
	    Player player1 = evt.getPlayer(); 

		java.lang.String player = player1.getName();		

		  getLogger().info("Login!"+tier.get(player)); 

	    if(tier.containsKey(player)==false)
	    {
	    	Bukkit.broadcastMessage(ChatColor.YELLOW +"Welcome "+player+" to the server! Who has joined for the first Time! " );

			tier.put(player, 0);


	    }
        player1.sendMessage(ChatColor.AQUA +"Your current tier is: "+tier.get(player));
		SetInv.main(player1,tier.get(player));

	}
	@EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        player.setLevel(0);
		java.lang.String player1 = player.getName();		

        GameMode gamemode = player.getGameMode();
        if(!(gamemode==GameMode.CREATIVE))
        {

        event.getItemDrop().remove();
        event.setCancelled(true);
       
        }
        }
	@EventHandler
	public void EntityDamageByEntityEvent(org.bukkit.event.entity.EntityDamageByEntityEvent event) {
	
		 Player Damager = (Player) event.getDamager();
		 Player player = (Player) event.getDamager();
		    if(event.getEntity() instanceof Player && Damager instanceof Player)
		    {
			
		double damage = event.getDamage();
		Xp.dmgtoxp(damage,player);
}
	}
	/*@EventHandler
	public void onPlayerLeave(PlayerQuitEvent event) {
		
}
*/
	
	
	    @Override
	    public void onDisable() {
			getLogger().info("onDisable has been invoked!");
			 try{
					SLAPI.save(tier,"tier.bin");
			            }catch(Exception e){
			                 e.printStackTrace();
			            }
	    }
	    
	 
	    
	    
	    
	    
}
