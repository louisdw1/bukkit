package com.gmail.louisdw1;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class SetInv {

	public static void main(Player player,int tier)
	{

		  player.getInventory().addItem(new ItemStack(Material.WOOD_SWORD));

		PlayerInventory inv= player.getInventory();
		inv.clear();
		inv.setHelmet(new ItemStack(Material.AIR));
		inv.setChestplate(new ItemStack(Material.AIR));
		inv.setLeggings(new ItemStack(Material.AIR));
		inv.setBoots(new ItemStack(Material.AIR));
		switch (tier)
		{ 
		  case 0:
			  ItemStack WOOD_SWORD = new ItemStack(Material.WOOD_SWORD);
			  ItemMeta meta = WOOD_SWORD.getItemMeta();
			  meta.setDisplayName("Noble Sword");
			  meta.addEnchant(Enchantment.DURABILITY, 50, true);
			  WOOD_SWORD.setItemMeta(meta);
			  player.getInventory().addItem(new ItemStack(WOOD_SWORD));

		        break;
		   case 1:
			  player.getInventory().addItem(new ItemStack(Material.STONE_SWORD));
		        break;
		   case 2:
				  player.getInventory().addItem(new ItemStack(Material.GOLD_SWORD));
		   break;
		   case 3:
				  player.getInventory().addItem(new ItemStack(Material.IRON_SWORD));

			   break;
		   case 4:
				  player.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD));

			   break;
		   case 5:
				  player.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD));
				  inv.setHelmet(new ItemStack(Material.LEATHER_HELMET));
			   break;
		 default:
			  player.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD));

		        break; 
		}	}
}
