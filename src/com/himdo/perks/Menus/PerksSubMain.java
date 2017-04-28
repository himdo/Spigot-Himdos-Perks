package com.himdo.perks.Menus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;

import com.himdo.perks.MainPlugin;
import com.himdo.perks.MenuChecker;
import com.himdo.perks.init.initHashMap;

public class PerksSubMain  implements Listener{
	private Inventory inv;
	//Player player;
	Plugin plugin;
	
	public PerksSubMain(Plugin plugin) {
		this.plugin=plugin;
		inv = Bukkit.getServer().createInventory(null, 9*3,"[Perks]Perk Selection Menu");
		Bukkit.getServer().getPluginManager().registerEvents( this, plugin);
	}
	
	public void show(Player p){
		//this.player = p;
		
		p.openInventory(inv);
		
	}
	
	public void init(){
		for(int i = 0; i<9; i++){
			inv.setItem(i, initHashMap.items.get("Border Purple"));
			inv.setItem(18+i, initHashMap.items.get("Border Purple"));
		}
		inv.clear(18+1);
		inv.setItem(18+1, initHashMap.items.get("Back"));

		inv.setItem(9,   initHashMap.items.get("Buffs"));
		inv.setItem(9+1, initHashMap.items.get("Weapon Perks"));
		inv.setItem(9+2, initHashMap.items.get("Strike/Revenge Perks"));
		inv.setItem(9+3, initHashMap.items.get("Feed/Starve/Heal/Harm Perks"));
		inv.setItem(9+4, initHashMap.items.get("Food Perks"));
		inv.setItem(9+5, initHashMap.items.get("Immune Perks"));
		inv.setItem(9+6, initHashMap.items.get("Flying Perks"));
		inv.setItem(9+7, initHashMap.items.get("Truce Perks"));
		inv.setItem(9+8, initHashMap.items.get("Misc Perks"));
		
		
	}
	

	@EventHandler
	public void onInventoryClicker(InventoryClickEvent e){
		if(!e.getInventory().getName().equals(inv.getName())) {
			return;
		}
		if(e.getCurrentItem()==null)
			return;
		if(e.getCurrentItem().equals(Material.AIR)){
			return;
		}
		if(e.getCurrentItem().equals(null)){
			return;
		}
		if(e.getCurrentItem().getItemMeta()==null){
			return;
		}
		
		Player player = (Player) e.getWhoClicked();
		
		
		if(e.getCurrentItem().equals(initHashMap.items.get("Back"))){
			MainPlugin.mainMenu.show(player);
			return;
		}
		if(e.getCurrentItem().equals(initHashMap.items.get("Buffs"))){
			MainPlugin.buffPerkMenu.show(player);
		}else if(e.getCurrentItem().equals(initHashMap.items.get("Weapon Perks"))){
			MainPlugin.weaponPerksMenu.show(player);
		}else if(e.getCurrentItem().equals(initHashMap.items.get("Strike/Revenge Perks"))){
			MainPlugin.strikePerksMenu.show(player);
		}else if(e.getCurrentItem().equals(initHashMap.items.get("Feed/Starve/Heal/Harm Perks"))){
			MainPlugin.healHarmMenu.show(player);
		}else if(e.getCurrentItem().equals(initHashMap.items.get("Food Perks"))){
			MainPlugin.foodPerkMenu.show(player);
		}else if(e.getCurrentItem().equals(initHashMap.items.get("Immune Perks"))){
			MainPlugin.immunePerkMenu.show(player);
		}else if(e.getCurrentItem().equals(initHashMap.items.get("Flying Perks"))){
			MainPlugin.flyingPerkMenu.show(player);
		}else if(e.getCurrentItem().equals(initHashMap.items.get("Truce Perks"))){
			MainPlugin.trucePerksMenu.show(player);
		}else if(e.getCurrentItem().equals(initHashMap.items.get("Misc Perks"))){
			MainPlugin.miscPerksMenu.show(player);
		}
		
	}
	

	@EventHandler
	public void InventoryClickEvent(InventoryClickEvent e){
		Player pa = (Player) e.getWhoClicked();
		if(pa.getOpenInventory().getTitle().equals(inv.getName())){
			e.setCancelled(true);
		}
	}
}
