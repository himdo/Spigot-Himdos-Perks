package com.himdo.perks.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class SummonedEntityDeath implements Listener{
	@EventHandler
	public void onSummonedEntityDeath(EntityDeathEvent e){
		if(e.getEntity().hasMetadata("owned")){
			e.setDroppedExp(0);
			e.getDrops().clear();
			
		}
	}

}
