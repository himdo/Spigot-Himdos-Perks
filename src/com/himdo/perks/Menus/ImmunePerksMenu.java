package com.himdo.perks.Menus;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;

import com.himdo.perks.MainPlugin;
import com.himdo.perks.init.initHashMap;

public class ImmunePerksMenu implements Listener{
	private Inventory inv;
	Player player;
	Plugin plugin;
	
	public ImmunePerksMenu(Plugin plugin) {
		this.plugin=plugin;
		inv = Bukkit.getServer().createInventory(null, 9*4,"Immunity Perk Selection Menu");
		Bukkit.getServer().getPluginManager().registerEvents( this, plugin);
	}
	
	public void show(Player p){
		this.player = p;
		
		player.openInventory(inv);
		
	}
	
	

	@EventHandler
	public void onInventoryClicker(InventoryClickEvent e){
		if(!e.getInventory().getName().equals(inv.getName())) {
			return;
		}
		
		
		if(e.getCurrentItem().equals(initHashMap.items.get("Back"))){
			MainPlugin.perksSubMain.show(player);
		}
		
	}
	

	@EventHandler
	public void InventoryClickEvent(InventoryClickEvent e){
		Player pa = (Player) e.getWhoClicked();
		if(pa.getOpenInventory().getTitle().equals(inv.getName())){
			e.setCancelled(true);
		}
	}

	public void init() {

		//sets up the border
		for(int i = 0; i<9; i++){
			inv.setItem(i, initHashMap.items.get("Border Purple"));
			inv.setItem(9*3+i, initHashMap.items.get("Border Purple"));
		}
		inv.clear(9*3+1);
		inv.setItem(9*3+1, initHashMap.items.get("Back"));

		inv.setItem(9,   initHashMap.items.get("Border Purple"));
		inv.setItem(9+1, initHashMap.items.get("Immune Armorpen"));
		inv.setItem(9+2, initHashMap.items.get("Immune Harm"));
		inv.setItem(9+3, initHashMap.items.get("Immune Hunger"));
		inv.setItem(9+4, initHashMap.items.get("Immune Nausea"));
		inv.setItem(9+5, initHashMap.items.get("Immune Starve"));
		inv.setItem(9+6, initHashMap.items.get("Immune Fall"));
		inv.setItem(9+7, initHashMap.items.get("Immune Steal"));
		inv.setItem(9+8, initHashMap.items.get("Border Purple"));
		
		inv.setItem(9*2,   initHashMap.items.get("Border Purple"));
		inv.setItem(9*2+1, initHashMap.items.get("Immune Weakness"));
		inv.setItem(9*2+2, initHashMap.items.get("Immune Wither"));
		inv.setItem(9*2+3, initHashMap.items.get("Immune Fire"));
		inv.setItem(9*2+4, initHashMap.items.get("Immune Poison"));
		inv.setItem(9*2+5, initHashMap.items.get("Immune Blindness"));
		inv.setItem(9*2+6, initHashMap.items.get("Immune Slow"));
		//inv.setItem(9*2+7, initHashMap.items.get(""));
		inv.setItem(9*2+8, initHashMap.items.get("Border Purple"));
		
				
	}
}
