package com.himdo.perks.Runnables;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import com.himdo.perks.MainPlugin;

public class RunnableTasker extends BukkitRunnable{
	Plugin plugin;
	public RunnableTasker(MainPlugin p) {
		plugin=p;
	}
	
	
	BukkitTask waterFly;
	public void run(){
		for(Player p : Bukkit.getOnlinePlayers()){
			Material m = p.getLocation().getBlock().getType();
			//Bukkit.getLogger().info(waterFly+"");
			//if(waterFly==null){
				/*if(m==Material.WATER||m==Material.STATIONARY_WATER){
					waterFly = new RunnableWaterFly((MainPlugin)plugin).runTaskTimer(plugin, 10, 10);
					
				}*/
			//}
			
			
		}
	}
	
	
	
}
