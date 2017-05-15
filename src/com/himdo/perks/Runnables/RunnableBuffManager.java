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

public class RunnableBuffManager extends BukkitRunnable{
	
	
	
	public void run(){
		for(Player p : Bukkit.getOnlinePlayers()){
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.NightVision.name"))){
				p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 400, 0),true);
			}
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.WaterBreathing.name"))){
				p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 400, 0),true);
			}
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.Haste.name"))){
				p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 400, 0),true);
			}
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.Jump.name"))){
				p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 400, 0),true);
			}
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.Speed.name"))){
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 400, 0),true);
			}
			
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.Haste2.name"))){
				p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 400, 1),true);
			}
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.Jump2.name"))){
				p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 400, 1),true);
			}
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.Speed2.name"))){
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 400, 1),true);
			}
			
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.MiningFatigue.name"))){
				p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 400, 0),true);
			}
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.Slow.name"))){
				p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 400, 0),true);
			}
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.Blind.name"))){
				p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 400, 0),true);
			}
		}
	}
	
}
