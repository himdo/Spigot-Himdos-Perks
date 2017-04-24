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

public class WeaponPerksMenu implements Listener{
	private Inventory inv;
	Player player;
	Plugin plugin;
	
	public WeaponPerksMenu(Plugin plugin) {
		this.plugin=plugin;
		inv = Bukkit.getServer().createInventory(null, 9*6,"Weapon Perk Selection Menu");
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
			inv.setItem(9*5+i, initHashMap.items.get("Border Purple"));
		}
		inv.clear(9*5+1);
		inv.setItem(9*5+1, initHashMap.items.get("Back"));
		
		inv.setItem(9*1,   initHashMap.items.get("Border Purple"));
		inv.setItem(9*1+1, initHashMap.items.get("Expert Archery"));
		inv.setItem(9*1+2, initHashMap.items.get("Expert Axe"));
		inv.setItem(9*1+3, initHashMap.items.get("Expert Sword"));
		inv.setItem(9*1+4, initHashMap.items.get("Expert Unarmed"));
		//inv.setItem(9*1+5, initHashMap.items.get(""));
		//inv.setItem(9*1+6, initHashMap.items.get(""));
		//inv.setItem(9*1+7, initHashMap.items.get(""));
		inv.setItem(9*1+8, initHashMap.items.get("Border Purple"));
		
		inv.setItem(9*2,   initHashMap.items.get("Border Purple"));
		inv.setItem(9*2+1, initHashMap.items.get("Resistant Archery"));
		inv.setItem(9*2+2, initHashMap.items.get("Resistant Axe"));
		inv.setItem(9*2+3, initHashMap.items.get("Resistant Sword"));
		inv.setItem(9*2+4, initHashMap.items.get("Resistant Unarmed"));
		//inv.setItem(9*2+5, initHashMap.items.get(""));
		//inv.setItem(9*2+6, initHashMap.items.get(""));
		//inv.setItem(9*2+7, initHashMap.items.get(""));
		inv.setItem(9*2+8, initHashMap.items.get("Border Purple"));
		
		inv.setItem(9*3,   initHashMap.items.get("Border Purple"));
		inv.setItem(9*3+1, initHashMap.items.get("Inept Archery"));
		inv.setItem(9*3+2, initHashMap.items.get("Inept Axe"));
		inv.setItem(9*3+3, initHashMap.items.get("Inept Sword"));
		inv.setItem(9*3+4, initHashMap.items.get("Inept Unarmed"));
		//inv.setItem(9*3+5, initHashMap.items.get(""));
		//inv.setItem(9*3+6, initHashMap.items.get(""));
		//inv.setItem(9*3+7, initHashMap.items.get(""));
		inv.setItem(9*3+8, initHashMap.items.get("Border Purple"));
		
		inv.setItem(9*4,   initHashMap.items.get("Border Purple"));
		inv.setItem(9*4+1, initHashMap.items.get("Vulnerable Archery"));
		inv.setItem(9*4+2, initHashMap.items.get("Vulnerable Axe"));
		inv.setItem(9*4+3, initHashMap.items.get("Vulnerable Sword"));
		inv.setItem(9*4+4, initHashMap.items.get("Vulnerable Unarmed"));
		//inv.setItem(9*4+5, initHashMap.items.get(""));
		//inv.setItem(9*4+6, initHashMap.items.get(""));
		//inv.setItem(9*4+7, initHashMap.items.get(""));
		inv.setItem(9*4+8, initHashMap.items.get("Border Purple"));
	}
}
