package com.gmail.louisdw1;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Xp {
public void setXp(int b,int l, Player player)
{
	player.setLevel(l);
	player.setExp(b);	
}
public static void dmgtoxp(double damage, Player player)
{
	int xp = 0;
	Bukkit.broadcastMessage(ChatColor.YELLOW +"Damage " +damage);

	while(damage>=1.0)
	{
		xp++;
		damage--;
		Bukkit.broadcastMessage(ChatColor.YELLOW +"Damage " +damage+" Xp "+xp);

	}
}

}
