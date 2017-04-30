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
import com.himdo.perks.Misc.CalculatePoints;
import com.himdo.perks.Misc.MenuChecker;
import com.himdo.perks.SaveAndLoading.FileLocation;
import com.himdo.perks.hashMaps.MainDataBaseHashMap;

public class FlyingPerksMenu implements Listener{
	private Inventory inv;
	//Player player;
	Plugin plugin;
	
	public FlyingPerksMenu(Plugin plugin) {
		this.plugin=plugin;
		inv = Bukkit.getServer().createInventory(null, 9*3,"[Perks]Flying Perk Selection Menu");
		Bukkit.getServer().getPluginManager().registerEvents( this, plugin);
	}
	public void init(){
		//sets up the border
		for(int i = 0; i<9; i++){
			inv.setItem(i, MainDataBaseHashMap.items.get("Border Purple"));
			inv.setItem(18+i, MainDataBaseHashMap.items.get("Border Purple"));
		}
		inv.clear(18+1);
		inv.setItem(18+1, MainDataBaseHashMap.items.get("Back"));

		inv.setItem(9,   MainDataBaseHashMap.items.get("Border Purple"));
		//inv.setItem(9+1, initHashMap.items.get("Weapon Perks"));
		//inv.setItem(9+2, initHashMap.items.get("Strike/Revenge Perks"));
		inv.setItem(9+3, MainDataBaseHashMap.items.get("Fly Water"));
		inv.setItem(9+4, MainDataBaseHashMap.items.get("Fly Lava"));
		inv.setItem(9+5, MainDataBaseHashMap.items.get("Fly Web"));
		//inv.setItem(9+6, initHashMap.items.get("Flying Perks"));
		//inv.setItem(9+7, initHashMap.items.get("Truce Perks"));
		inv.setItem(9+8, MainDataBaseHashMap.items.get("Border Purple"));
			
	}
	
	
	public void show(Player p){
		//this.player = p;
		
		p.openInventory(inv);
		
	}
	
	

	@SuppressWarnings("unchecked")
	@EventHandler
	public void onInventoryClicker(InventoryClickEvent e){
		Player player = (Player) e.getWhoClicked();
		/*if(!e.getInventory().getName().equals(inv.getName())) {
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
		
		
		if(e.getCurrentItem().equals(initHashMap.items.get("Back"))){
			MainPlugin.perksSubMain.show(player);
			return;
		}
		if(e.getCurrentItem().equals(initHashMap.items.get("Border Purple")))
			return;
		
		if(MainPlugin.playerPerks.get(player).contains(e.getCurrentItem().getItemMeta().getDisplayName())){
			return;
		}*/
		if(!MenuChecker.menuChecker(e,inv))
			return;
		if(e.getCurrentItem().equals(MainDataBaseHashMap.items.get("Back"))){
			MainPlugin.perksSubMain.show(player);
			return;
		}
		if((CalculatePoints.getCurrentPoints(player)+CalculatePoints.getPointsForItem(e.getCurrentItem()) )>150){
			player.sendMessage("Costs to many Points");
			return;
		}
		if(MainPlugin.playerPerks.get(player).size()>8){
			player.sendMessage("Too Many Perks Choosen");
			return;
		}
		
		MainPlugin.playerPerks.get(player).add(e.getCurrentItem().getItemMeta().getDisplayName());
		FileLocation.save(player);
	}
	

	@EventHandler
	public void InventoryClickEvent(InventoryClickEvent e){
		Player pa = (Player) e.getWhoClicked();
		if(pa.getOpenInventory().getTitle().equals(inv.getName())){
			e.setCancelled(true);
		}
	}
}
