package com.himdo.perks.Runnables;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import com.himdo.perks.MainPlugin;

public class RunnableAbsoption extends BukkitRunnable{

	@Override
	public void run() {
		for(Player p : Bukkit.getOnlinePlayers()){
			
			if(MainPlugin.playerPerks.get(p).contains("Health Boost")){
				p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 20*60, 0),true);
			}
			
			if(MainPlugin.playerPerks.get(p).contains("Health Boost 2")){
				p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 20*60, 1),true);
			}
		}
	}

}
