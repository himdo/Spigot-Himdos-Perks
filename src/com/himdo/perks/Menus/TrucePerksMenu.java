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

public class TrucePerksMenu implements Listener{
	private Inventory inv;
	Player player;
	Plugin plugin;
	
	public TrucePerksMenu(Plugin plugin) {
		this.plugin=plugin;
		inv = Bukkit.getServer().createInventory(null, 9*3,"Truce Perk Selection Menu");
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
		// TODO Auto-generated method stub
		//sets up the border
		for(int i = 0; i<9; i++){
			inv.setItem(i, initHashMap.items.get("Border Purple"));
			inv.setItem(18+i, initHashMap.items.get("Border Purple"));
		}
		inv.clear(18+1);
		inv.setItem(18+1, initHashMap.items.get("Back"));

		inv.setItem(9,   initHashMap.items.get("Border Purple"));
		inv.setItem(9+1, initHashMap.items.get("Truce Slime"));
		inv.setItem(9+2, initHashMap.items.get("Truce Blaze"));
		inv.setItem(9+3, initHashMap.items.get("Truce SilverFish"));
		inv.setItem(9+4, initHashMap.items.get("Truce Spider"));
		inv.setItem(9+5, initHashMap.items.get("Truce Undead"));
		inv.setItem(9+6, initHashMap.items.get("Truce Creeper"));
		inv.setItem(9+7, initHashMap.items.get("Truce Ghast"));
		inv.setItem(9+8, initHashMap.items.get("Truce Witch"));
	}
}
