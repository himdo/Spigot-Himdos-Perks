package com.himdo.perks.Runnables;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import com.himdo.perks.MainPlugin;

public class RunnableImmunity extends BukkitRunnable{

	@Override
	public void run() {
		for(Player p : Bukkit.getOnlinePlayers()){
			if(!MainPlugin.playerPerks.get(p).contains("Immune Hunger")&&
					!MainPlugin.playerPerks.get(p).contains("Immune Nausea")&&
					!MainPlugin.playerPerks.get(p).contains("Immune Weakness")&&
					!MainPlugin.playerPerks.get(p).contains("Immune Blindness")&&
					!MainPlugin.playerPerks.get(p).contains("Immune Slow")&&
					!MainPlugin.playerPerks.get(p).contains("Immune Poison")&&
					!MainPlugin.playerPerks.get(p).contains("Immune Wither"))
						return;
			
			for (PotionEffect effect : p.getActivePotionEffects()){
				if(MainPlugin.playerPerks.get(p).contains("Immune Hunger")){
					if(effect.getType().equals((PotionEffectType.HUNGER))){
						p.removePotionEffect(PotionEffectType.HUNGER);
					}
				}
				
				if(MainPlugin.playerPerks.get(p).contains("Immune Nausea")){
					if(effect.getType().equals(PotionEffectType.CONFUSION)){
						p.removePotionEffect(PotionEffectType.CONFUSION);
					}	
				}
				if(MainPlugin.playerPerks.get(p).contains("Immune Poison")){
					if(effect.getType().equals(PotionEffectType.POISON)){
						p.removePotionEffect(PotionEffectType.POISON);
					}	
				}
				if(MainPlugin.playerPerks.get(p).contains("Immune Wither")){
					if(effect.getType().equals(PotionEffectType.WITHER)){
						p.removePotionEffect(PotionEffectType.WITHER);
					}	
				}
				if(MainPlugin.playerPerks.get(p).contains("Immune Weakness")){
					if(effect.getType().equals(PotionEffectType.WEAKNESS)){
						p.removePotionEffect(PotionEffectType.WEAKNESS);
					}
				}
				
				if(MainPlugin.playerPerks.get(p).contains("Immune Blindness")){
					if(effect.getType().equals(PotionEffectType.BLINDNESS)){
						p.removePotionEffect(PotionEffectType.BLINDNESS);
					}
				}
				
				if(MainPlugin.playerPerks.get(p).contains("Immune Slow")){
					if(effect.getType().equals(PotionEffectType.SLOW)){
						p.removePotionEffect(PotionEffectType.SLOW);
					}
				}
				
			}
			
		}
	}

}
