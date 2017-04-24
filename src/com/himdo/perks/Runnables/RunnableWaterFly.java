package com.himdo.perks.Runnables;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.himdo.perks.MainPlugin;

public class RunnableWaterFly extends BukkitRunnable{
	Plugin plugin;
	
	public RunnableWaterFly(MainPlugin mainPlugin) {
		plugin = mainPlugin;
	}

	public void run(){
		for(Player p : Bukkit.getOnlinePlayers()){
				
			Material m = p.getLocation().getBlock().getType();
			if(m==Material.WATER||m==Material.STATIONARY_WATER){
				p.setAllowFlight(true);
				p.setFlying(true);
			}else{
				p.getPlayer().setAllowFlight(false);
				p.getPlayer().setFlying(false);
				this.cancel();
				
			}
			
		}
	}
}
