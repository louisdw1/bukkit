package com.gmail.louisdw1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ListenerBasic implements Listener{
	public static Map<java.lang.String, Integer> game;
	//   player1.sendMessage(ChatColor.AQUA +"Your current tier is: "+tier.get(player));
//	SetInv.main(player1,tier.get(player),points.get(player1.getName()));

	@EventHandler
public void onjoin(PlayerJoinEvent event)
{
		event.setJoinMessage(""); 
		
		game = upgrading.getGame();
		Player player = event.getPlayer();
	if(game.get(player.getName()) == null || game.get(player.getName()) == 0)
	{
        player.teleport(new Location(Bukkit.getWorld("world"), 219, 66, 257));

		 if(game.containsKey(player.getName())==false)
		    {
		    	Bukkit.broadcastMessage(ChatColor.YELLOW +"Welcome "+player.getName()+" to the server! Who has joined for the first Time! " );
		    upgrading.putGame(player, 0);
		    Inventory inv = player.getInventory();
		    ItemStack upgrading = new ItemStack(Material.RECORD_11);
			  ItemMeta meta = upgrading.getItemMeta();
			  meta.setDisplayName(ChatColor.BOLD+""+ChatColor.GOLD+"Right Click Me!");
			  upgrading.setItemMeta(meta);
			  inv.addItem(new ItemStack(upgrading));
	
		    }
	}
}
	@EventHandler(priority=EventPriority.HIGH)
	public void onPlayerUse(PlayerInteractEvent event){
		game = upgrading.getGame();
		
	    Player player = event.getPlayer();
    	//Bukkit.broadcastMessage(ChatColor.YELLOW +"Welcome "+player.getName()+"TESTEST "+game.get(player.getName()) );

		if(game.get(player.getName()) == 0)
		{
	    	//Bukkit.broadcastMessage(ChatColor.YELLOW +"Welcome "+player.getName()+"TESTEST "+game.get(player.getName())+"   "+player.getItemInHand() );

	    if((player.getItemInHand()).getType().equals(Material.RECORD_11)){
	    	//Bukkit.broadcastMessage(ChatColor.YELLOW +"Welcome "+player.getName()+"TESTEST "+game.get(player.getName()) );

	    	  Inventory inventory = Bukkit.createInventory(player, 27, "Choose game: ");
	    	  ItemStack upgrading = new ItemStack(Material.DIAMOND_SWORD);
			  ItemMeta meta = upgrading.getItemMeta();
			  meta.setDisplayName("Upgrading");
			  List<String> loreList = new ArrayList<String>();

			  loreList.add(ChatColor.RED+"FastPaced battles");
			  loreList.add(ChatColor.RED+"encouraging progression");
			  loreList.add(ChatColor.RED+"through tiers.");

			  meta.setLore(loreList);
			  upgrading.setItemMeta(meta);
			  inventory.addItem(new ItemStack(upgrading));	      
			  player.openInventory(inventory);
	    }
	    
		}
		}


	@EventHandler
    public void inventoryclick(InventoryClickEvent e){
        if (e.getInventory().getName().equalsIgnoreCase("Choose game: ")){

            if (e.getRawSlot() < 54 && e.getRawSlot() > -1){ // the top inv rawslots are numbered 0 to 53 starting top left, -999 is returned if u click outside the inv view screen
                ItemStack itemclicked = e.getCurrentItem();
                ItemStack cursor = e.getCursor();
                e.setCancelled(true);
                if (cursor.getType() == Material.AIR){ //if player has no item on the cursor
                 ItemMeta meta = itemclicked.getItemMeta();
                 String display = meta.getDisplayName();
                 if(display=="Upgrading")
                 {
                	 Player player = (Player) e.getWhoClicked();
                	upgrading.putGame(player, 1);
                    player.getServer().getWorld("world")
                    .setSpawnLocation(272, 120, 38);
            		player.setHealth(0);
                 }
                }
            }
        }
    }
}
