package com.himdo.perks.Events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;

import com.himdo.perks.MainPlugin;
import com.himdo.perks.hashMaps.FoodArrayList;

public class FoodPerksEvents implements Listener{
	@EventHandler
	public void onPlayerEat(PlayerItemConsumeEvent e){
		if(MainPlugin.playerPerks.get(e.getPlayer()).contains("Water Drinker")){
			if(e.getItem().getType().equals(Material.POTION)){
				e.getPlayer().setFoodLevel(e.getPlayer().getFoodLevel()+3);
			}
		}
		if(MainPlugin.playerPerks.get(e.getPlayer()).contains("Carnivore")){
			if(!FoodArrayList.Meat.contains(e.getItem().getType())&&!e.getItem().getType().equals(Material.POTION)){
				e.getPlayer().sendMessage("[Perks]: You Are an Carnivore, you Can't Eat this");
				e.setCancelled(true);
			}
		}
		if(MainPlugin.playerPerks.get(e.getPlayer()).contains("Herbivore")){
			if(!FoodArrayList.Veggies.contains(e.getItem().getType())&&!e.getItem().getType().equals(Material.POTION)){
				e.getPlayer().sendMessage("[Perks]: You Are an Herbivore, you Can't Eat this");
				e.setCancelled(true);
			}
		}
		if(MainPlugin.playerPerks.get(e.getPlayer()).contains("Nonivore")){
			if(!e.getItem().getType().equals(Material.POTION)){
				e.getPlayer().sendMessage("[Perks]: You can't eat, you are an Nonivore");
				e.setCancelled(true);
			}
			
		}
	}
	
	
	@EventHandler
	public void onBreak(BlockBreakEvent e){
		if(MainPlugin.playerPerks.get(e.getPlayer()).contains("Stone Eater")){
			if(e.getBlock().getType().equals(Material.STONE)){
				if(e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.AIR)){
					//adds to full hunger bars
					e.getPlayer().setFoodLevel(e.getPlayer().getFoodLevel()+4);
				}
			}
		}		
		
	}
}
