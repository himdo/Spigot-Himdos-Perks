package com.himdo.perks.Events;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;

import com.himdo.perks.MainPlugin;
import com.himdo.perks.hashMaps.FoodArrayList;

public class FoodPerksEvents implements Listener{
	@EventHandler
	public void onPlayerEat(PlayerItemConsumeEvent e){
		//water drinker perk
		if(MainPlugin.playerPerks.get(e.getPlayer()).contains(MainPlugin.config.getString("Perks.WaterDrinker.name"))){
			if(e.getItem().getType().equals(Material.POTION)){
				e.getPlayer().setFoodLevel(e.getPlayer().getFoodLevel()+3);
			}
		}
		//Carnivore perk
		if(MainPlugin.playerPerks.get(e.getPlayer()).contains(MainPlugin.config.getString("Perks.Carnivore.name"))){
			if(!FoodArrayList.Meat.contains(e.getItem().getType())&&!e.getItem().getType().equals(Material.POTION)){
				e.getPlayer().sendMessage("[Perks]: You Are an Carnivore, you Can't Eat this");
				e.setCancelled(true);
			}
		}
		//Herbivore perk
		if(MainPlugin.playerPerks.get(e.getPlayer()).contains(MainPlugin.config.getString("Perks.Herbivore.name"))){
			if(!FoodArrayList.Veggies.contains(e.getItem().getType())&&!e.getItem().getType().equals(Material.POTION)){
				e.getPlayer().sendMessage("[Perks]: You Are an Herbivore, you Can't Eat this");
				e.setCancelled(true);
			}
		}
		//
		if(MainPlugin.playerPerks.get(e.getPlayer()).contains(MainPlugin.config.getString("Perks.Nonivore.name"))){
			if(!e.getItem().getType().equals(Material.POTION)){
				e.getPlayer().sendMessage("[Perks]: You can't eat, you are an Nonivore");
				e.setCancelled(true);
			}
			
		}
	}
	
	
	@EventHandler
	public void onBreak(BlockBreakEvent e){
		// Stone eater perk
		if(MainPlugin.playerPerks.get(e.getPlayer()).contains(MainPlugin.config.getString("Perks.StoneEater.name"))){
			if(e.getBlock().getType().equals(Material.STONE)){
				if(e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.AIR)){
					//adds to full hunger bars
					e.getPlayer().setFoodLevel(e.getPlayer().getFoodLevel()+4);
					e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENTITY_GENERIC_EAT, 1, 0);
				}
			}
		}		
		
	}
}
