package com.himdo.perks.Misc;

import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import com.himdo.perks.MainPlugin;
import com.himdo.perks.hashMaps.MainDataBaseHashMap;

public class MenuChecker {
	public static boolean menuChecker(InventoryClickEvent event,Inventory inv){
		if(event.getWhoClicked().getOpenInventory().getTitle()==null)
			return false;
		//The one bellow is untested but should allow for inventory's with the same name to work
		/*if(!event.getClickedInventory().getContents().equals(inv.getContents())){
			return false;
		}*/
		
		if(!event.getInventory().getName().equals(inv.getName())) {
			return false;
		}
		if(event.getCurrentItem()==null)
			return false;
		if(event.getCurrentItem().equals(Material.AIR)){
			return false;
		}
		if(event.getCurrentItem().equals(null)){
			return false;
		}
		if(event.getCurrentItem().getItemMeta()==null){
			return false;
		}
		if(event.getCurrentItem().equals(MainPlugin.config.getString("Perks.LeftArrow.name"))){
			return true;
		}
		if(event.getCurrentItem().equals(MainDataBaseHashMap.items.get("Border Purple")))
			return false;
		
		if(MainPlugin.playerPerks.get(event.getWhoClicked()).contains(event.getCurrentItem().getItemMeta().getDisplayName())){
			return false;
		}
		return true;
	}
}
