package com.himdo.perks.Menus.Help;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;

import com.himdo.perks.MainPlugin;
import com.himdo.perks.Misc.MenuChecker;
import com.himdo.perks.hashMaps.MainDataBaseHashMap;

public class PerksSubHelpMain  implements Listener{
	private Inventory inv;
	//Player player;
	Plugin plugin;
	
	public PerksSubHelpMain(Plugin plugin) {
		this.plugin=plugin;
		inv = Bukkit.getServer().createInventory(null, 9*3,"[Perks]Help Selection SubMenu");
		Bukkit.getServer().getPluginManager().registerEvents( this, plugin);
	}
	
	public void show(Player p){
		//this.player = p;
		
		p.openInventory(inv);
		
	}
	
	public void init(){
		for(int i = 0; i<9; i++){
			inv.setItem(i, MainDataBaseHashMap.items.get("Border Purple"));
			inv.setItem(18+i, MainDataBaseHashMap.items.get("Border Purple"));
		}
		inv.clear(18+1);
		inv.setItem(18+1, MainDataBaseHashMap.items.get("Back"));

		inv.setItem(9,   MainDataBaseHashMap.items.get("Border Purple"));
		inv.setItem(9+1, MainDataBaseHashMap.items.get("Help 1"));
		inv.setItem(9+2, MainDataBaseHashMap.items.get("Help 2"));
		//inv.setItem(9+3, MainDataBaseHashMap.items.get("Feed/Starve/Heal/Harm Perks"));
		//inv.setItem(9+4, MainDataBaseHashMap.items.get("Food Perks"));
		//inv.setItem(9+5, MainDataBaseHashMap.items.get("Immune Perks"));
		inv.setItem(9+6, MainDataBaseHashMap.items.get("Help 3"));
		inv.setItem(9+7, MainDataBaseHashMap.items.get("Help 4"));
		inv.setItem(9+8, MainDataBaseHashMap.items.get("Border Purple"));
		
		
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
		
		
		if(e.getCurrentItem().equals(MainDataBaseHashMap.items.get("Back"))){
			MainPlugin.mainMenu.show(player);
			return;
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