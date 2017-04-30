package com.himdo.perks.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.potion.PotionEffectType;

import com.himdo.perks.MainPlugin;

public class onEntityDamageEvent  implements Listener{
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e){
		Player player = null;
		if(e.getEntity() instanceof Player){
			player = (Player) e.getEntity();
		}else{
			return;
		}
		if(MainPlugin.playerPerks.get(player).contains("Immune Fire")){
			if(e.getCause().equals(DamageCause.FIRE)||e.getCause().equals(DamageCause.FIRE_TICK)
			   ||e.getCause().equals(DamageCause.HOT_FLOOR)||e.getCause().equals(DamageCause.LAVA)){
				player.setFireTicks(0);
				e.setCancelled(true);
			}
		}
		if(MainPlugin.playerPerks.get(player).contains("Immune Harm")){
			if(e.getCause().equals(DamageCause.THORNS)){
				e.setCancelled(true);
			}
		}
		if(MainPlugin.playerPerks.get(player).contains("Immune Fall")){
			if(e.getCause().equals(DamageCause.FALL)){
				e.setCancelled(true);
			}
		}
		if(MainPlugin.playerPerks.get(player).contains("Immune Fall")){
			if(e.getCause().equals(DamageCause.WITHER)){
				player.removePotionEffect(PotionEffectType.WITHER);
				e.setCancelled(true);
			}
		}
		if(MainPlugin.playerPerks.get(player).contains("Immune Fall")){
			if(e.getCause().equals(DamageCause.POISON)){
				player.removePotionEffect(PotionEffectType.POISON);
				e.setCancelled(true);
			}
		}
		
	}
}
