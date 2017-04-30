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

public class RunnableBuffManager extends BukkitRunnable{
	
	
	
	public void run(){
		for(Player p : Bukkit.getOnlinePlayers()){
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
			
			if(MainPlugin.playerPerks.get(p).contains("Haste 2")){
				p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 400, 1),true);
			}
			if(MainPlugin.playerPerks.get(p).contains("Jump Boost 2")){
				p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 400, 1),true);
			}
			if(MainPlugin.playerPerks.get(p).contains("Speed Boost 2")){
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 400, 1),true);
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
