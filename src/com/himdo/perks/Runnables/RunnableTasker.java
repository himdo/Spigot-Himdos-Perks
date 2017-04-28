package com.himdo.perks.Runnables;


import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import com.himdo.perks.Constants;
import com.himdo.perks.MainPlugin;
import com.himdo.perks.Runnables.Perks.Flying.RunnableFlying;

public class RunnableTasker extends BukkitRunnable{
	Plugin plugin;
	public RunnableTasker(MainPlugin p) {
		plugin=p;
	}
	
	
	//RunnableTasker fly = new RunnableTasker(MainPlugin.plugin);
	public void run(){
		for(Player p : Bukkit.getOnlinePlayers()){
			//Material m = p.getLocation().getBlock().getType();
			//this checks to see if player can fly but not from our plugin
			
			
			//if(MainPlugin.playerPerks.get(p).contains("Fly Lava")||MainPlugin.playerPerks.get(p).contains("Fly Water")||MainPlugin.playerPerks.get(p).contains("Fly Web")){
				//if(!(Constants.canFly==false && p.getAllowFlight())){
				//if(m==Material.WATER||m==Material.STATIONARY_WATER){
				//if(p.getGameMode()!=GameMode.SPECTATOR||p.getGameMode()!=GameMode.CREATIVE)
					//fly = new RunnableFlying((MainPlugin)plugin).runTaskTimer(plugin, 10, 10);
				
				//}
				//}
			//}
			if(MainPlugin.playerPerks.get(p).contains("Night Vision")){
				p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 400, 0),true);
			}
			if(MainPlugin.playerPerks.get(p).contains("Water Breathing")){
				p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 400, 0),true);
			}
			if(MainPlugin.playerPerks.get(p).contains("Night Vision")){
				p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 400, 0),true);
			}
			if(MainPlugin.playerPerks.get(p).contains("Haste")){
				p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 400, 0),true);
			}
			if(MainPlugin.playerPerks.get(p).contains("Jump Boost")){
				p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 400, 0),true);
			}
			if(MainPlugin.playerPerks.get(p).contains("Speed Boost")){
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 400, 0),true);
			}
			if(MainPlugin.playerPerks.get(p).contains("Health Boost")){
				p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 400, 0),true);
			}
			if(MainPlugin.playerPerks.get(p).contains("Haste 2")){
				p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 400, 1),true);
			}
			if(MainPlugin.playerPerks.get(p).contains("Jump Boost 2")){
				p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 400, 1),true);
			}
			if(MainPlugin.playerPerks.get(p).contains("Speed Boost 2")){
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 400, 1),true);
			}
			if(MainPlugin.playerPerks.get(p).contains("Health Boost 2")){
				p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 400, 1),true);
			}
			if(MainPlugin.playerPerks.get(p).contains("Mining Fatigue")){
				p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 400, 0),true);
			}
			if(MainPlugin.playerPerks.get(p).contains("Slowness")){
				p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 400, 0),true);
			}
			if(MainPlugin.playerPerks.get(p).contains("Blindness")){
				p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 400, 0),true);
			}
			
			
		
		}
	}
	
	
	
}
