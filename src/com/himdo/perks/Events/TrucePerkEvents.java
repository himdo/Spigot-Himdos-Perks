package com.himdo.perks.Events;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
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

			if(e.getEntity() instanceof LivingEntity){
				LivingEntity entity = (LivingEntity)e.getEntity();
				if(e.getEntity().hasMetadata(player.getName())){
					
					e.setCancelled(true);
					
				}
			}
			
			
			if(MainPlugin.playerPerks.get(player).contains(MainPlugin.config.getString("Perks.TruceSlime.name"))){
				if(e.getEntity().getType()==EntityType.SLIME||e.getEntity().getType()==EntityType.MAGMA_CUBE)
					e.setCancelled(true);
			}
			if(MainPlugin.playerPerks.get(player).contains(MainPlugin.config.getString("Perks.TruceBlaze.name"))){
				if(e.getEntity().getType()==EntityType.BLAZE)
					e.setCancelled(true);
			}
			if(MainPlugin.playerPerks.get(player).contains(MainPlugin.config.getString("Perks.TruceSilverFish.name"))){
				if(e.getEntity().getType()==EntityType.SILVERFISH)
					e.setCancelled(true);
			}
			if(MainPlugin.playerPerks.get(player).contains(MainPlugin.config.getString("Perks.TruceSpider.name"))){
				if(e.getEntity().getType()==EntityType.SPIDER||e.getEntity().getType()==EntityType.CAVE_SPIDER)
					e.setCancelled(true);
			}
			if(MainPlugin.playerPerks.get(player).contains(MainPlugin.config.getString("Perks.TruceUndead.name"))){
				if(e.getEntity().getType()==EntityType.ZOMBIE||e.getEntity().getType()==EntityType.SKELETON||e.getEntity().getType()==EntityType.WITHER_SKELETON)
					e.setCancelled(true);
			}
			if(MainPlugin.playerPerks.get(player).contains(MainPlugin.config.getString("Perks.TruceCreeper.name"))){
				if(e.getEntity().getType()==EntityType.CREEPER)
					e.setCancelled(true);
			}
			if(MainPlugin.playerPerks.get(player).contains(MainPlugin.config.getString("Perks.TruceGhast.name"))){
				if(e.getEntity().getType()==EntityType.GHAST)
					e.setCancelled(true);
			}
			if(MainPlugin.playerPerks.get(player).contains(MainPlugin.config.getString("Perks.TruceWitch.name"))){
				if(e.getEntity().getType()==EntityType.WITCH)
					e.setCancelled(true);
			}
			
		}
	}
	
}
