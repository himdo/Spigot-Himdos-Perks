package com.himdo.perks.Events;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;

import com.himdo.perks.MainPlugin;

public class TrucePerkEvents implements Listener{
	@EventHandler
	public void onEntityTarget(EntityTargetEvent e){
		/*if(e.getEntity().getType()== EntityType.SPIDER)
			if(!e.isCancelled())
				e.setCancelled(true);
		*/
		if(e.getTarget() instanceof Player){
			Player player = (Player) e.getTarget();
			if(MainPlugin.playerPerks.get(player).contains("Truce Slime")){
				if(e.getEntity().getType()==EntityType.SLIME||e.getEntity().getType()==EntityType.MAGMA_CUBE)
					e.setCancelled(true);
			}
			if(MainPlugin.playerPerks.get(player).contains("Truce Blaze")){
				if(e.getEntity().getType()==EntityType.BLAZE)
					e.setCancelled(true);
			}
			if(MainPlugin.playerPerks.get(player).contains("Truce SilverFish")){
				if(e.getEntity().getType()==EntityType.SILVERFISH)
					e.setCancelled(true);
			}
			if(MainPlugin.playerPerks.get(player).contains("Truce Spider")){
				if(e.getEntity().getType()==EntityType.SPIDER||e.getEntity().getType()==EntityType.CAVE_SPIDER)
					e.setCancelled(true);
			}
			if(MainPlugin.playerPerks.get(player).contains("Truce Undead")){
				if(e.getEntity().getType()==EntityType.ZOMBIE||e.getEntity().getType()==EntityType.SKELETON||e.getEntity().getType()==EntityType.WITHER_SKELETON)
					e.setCancelled(true);
			}
			if(MainPlugin.playerPerks.get(player).contains("Truce Creeper")){
				if(e.getEntity().getType()==EntityType.CREEPER)
					e.setCancelled(true);
			}
			if(MainPlugin.playerPerks.get(player).contains("Truce Ghast")){
				if(e.getEntity().getType()==EntityType.GHAST)
					e.setCancelled(true);
			}
			if(MainPlugin.playerPerks.get(player).contains("Truce Witch")){
				if(e.getEntity().getType()==EntityType.WITCH)
					e.setCancelled(true);
			}
			
		}
	}
	
}
