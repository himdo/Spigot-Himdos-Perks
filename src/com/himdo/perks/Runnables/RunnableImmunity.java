package com.himdo.perks.Runnables;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import com.himdo.perks.MainPlugin;

public class RunnableImmunity extends BukkitRunnable{

	@Override
	public void run() {
		for(Player p : Bukkit.getOnlinePlayers()){
			if(MainPlugin.playerPerks.get(p).contains("Immune Hunger")){
				if(p.getActivePotionEffects().contains(PotionEffectType.HUNGER)){
					p.removePotionEffect(PotionEffectType.HUNGER);
				}
			}
		
			if(MainPlugin.playerPerks.get(p).contains("Immune Nausea")){
				if(p.getActivePotionEffects().contains(PotionEffectType.CONFUSION)){
					p.removePotionEffect(PotionEffectType.CONFUSION);
				}	
			}
			if(MainPlugin.playerPerks.get(p).contains("Immune Weakness")){
				if(p.getActivePotionEffects().contains(PotionEffectType.WEAKNESS)){
					p.removePotionEffect(PotionEffectType.WEAKNESS);
				}
			}		
					
					
			if(MainPlugin.playerPerks.get(p).contains("Immune Blindness")){
				if(p.getActivePotionEffects().contains(PotionEffectType.BLINDNESS)){
					p.removePotionEffect(PotionEffectType.BLINDNESS);
				}
			}
			if(MainPlugin.playerPerks.get(p).contains("Immune Slow")){
				if(p.getActivePotionEffects().contains(PotionEffectType.SLOW)){
					p.removePotionEffect(PotionEffectType.SLOW);
				}
			}
		}
	}

}
