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
			if(!MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.ImmuneHunger.name"))&&
					!MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.ImmuneNausea.name"))&&
					!MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.ImmuneWeakness.name"))&&
					!MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.ImmuneBlindness.name"))&&
					!MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.ImmuneSlow.name"))&&
					!MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.ImmunePoison.name"))&&
					!MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.ImmuneWither.name")))
						return;
			
			for (PotionEffect effect : p.getActivePotionEffects()){
				if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.ImmuneHunger.name"))){
					if(effect.getType().equals((PotionEffectType.HUNGER))){
						p.removePotionEffect(PotionEffectType.HUNGER);
					}
				}
				
				if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.ImmuneNausea.name"))){
					if(effect.getType().equals(PotionEffectType.CONFUSION)){
						p.removePotionEffect(PotionEffectType.CONFUSION);
					}	
				}
				if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.ImmunePoison.name"))){
					if(effect.getType().equals(PotionEffectType.POISON)){
						p.removePotionEffect(PotionEffectType.POISON);
					}	
				}
				if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.ImmuneWither.name"))){
					if(effect.getType().equals(PotionEffectType.WITHER)){
						p.removePotionEffect(PotionEffectType.WITHER);
					}	
				}
				if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.ImmuneWeakness.name"))){
					if(effect.getType().equals(PotionEffectType.WEAKNESS)){
						p.removePotionEffect(PotionEffectType.WEAKNESS);
					}
				}
				
				if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.ImmuneBlindness.name"))){
					if(effect.getType().equals(PotionEffectType.BLINDNESS)){
						p.removePotionEffect(PotionEffectType.BLINDNESS);
					}
				}
				
				if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.ImmuneSlow.name"))){
					if(effect.getType().equals(PotionEffectType.SLOW)){
						p.removePotionEffect(PotionEffectType.SLOW);
					}
				}
				
			}
			
		}
	}

}
