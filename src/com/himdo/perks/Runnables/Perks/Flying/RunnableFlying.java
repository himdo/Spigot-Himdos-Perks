package com.himdo.perks.Runnables.Perks.Flying;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.himdo.perks.MainPlugin;

public class RunnableFlying extends BukkitRunnable{
	Plugin plugin;
	
	public RunnableFlying(MainPlugin mainPlugin) {
		plugin = mainPlugin;
	}

	public void run(){
		for(Player p : Bukkit.getOnlinePlayers()){
			if(p.getGameMode()==GameMode.CREATIVE||p.getGameMode()==GameMode.SPECTATOR)
				continue;
			if(MainPlugin.playerPerks.get(p).contains("Fly Lava")||MainPlugin.playerPerks.get(p).contains("Fly Web")||MainPlugin.playerPerks.get(p).contains("Fly Water")){
				Material m = p.getLocation().getBlock().getType();
				if((MainPlugin.playerPerks.get(p).contains("Fly Lava")&&(m==Material.LAVA||m==Material.STATIONARY_LAVA)) || (MainPlugin.playerPerks.get(p).contains("Fly Water")&&(m==Material.WATER||m==Material.STATIONARY_WATER)) || (MainPlugin.playerPerks.get(p).contains("Fly Web")&&(m==Material.WEB)) ){
					
					p.setAllowFlight(true);
					p.setFlying(true);
				}else{
					p.getPlayer().setAllowFlight(false);
					p.getPlayer().setFlying(false);
					//this.cancel();
					
				}
			}
			
			
		}
	}
}
