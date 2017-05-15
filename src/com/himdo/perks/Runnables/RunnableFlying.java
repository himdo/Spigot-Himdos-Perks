package com.himdo.perks.Runnables;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.himdo.perks.Constants;
import com.himdo.perks.MainPlugin;

public class RunnableFlying extends BukkitRunnable{
	

	public void run(){
		for(Player p : Bukkit.getOnlinePlayers()){
			if(p.getGameMode()==GameMode.CREATIVE||p.getGameMode()==GameMode.SPECTATOR)
				continue;
			
				//check to see if the player has any flying perks chosen
				if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.FlyLava.name"))||
						MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.FlyWeb.name"))||
						MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.FlyWater.name"))){
					
					Material m = p.getLocation().getBlock().getType();
					//check to see it the player is in the required source with the correct perk
					if((MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.FlyLava.name"))&&(m==Material.LAVA||m==Material.STATIONARY_LAVA)) ||
							(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.FlyWater.name"))&&(m==Material.WATER||m==Material.STATIONARY_WATER)) || 
							(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.FlyWeb.name"))&&(m==Material.WEB)) ){
						
						p.setAllowFlight(true);
						p.setFlying(true);
						Constants.canFly.put(p.getName(), true);
						
					}else{
						if(Constants.canFly.get(p.getName())){
							p.getPlayer().setAllowFlight(false);
							p.getPlayer().setFlying(false);	
							Constants.canFly.put(p.getName(), false);
						}
						
					}
				}
			}
			
			
			
		
	}
}
