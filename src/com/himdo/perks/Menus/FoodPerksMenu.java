package com.himdo.perks.Menus;

import org.bukkit.Bukkit;
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

public class FoodPerksMenu implements Listener{
	private Inventory inv;
	//Player player;
	Plugin plugin;
	
	public FoodPerksMenu(Plugin plugin) {
		this.plugin=plugin;
		inv = Bukkit.getServer().createInventory(null, 9*3,"[Perks]Food Perk Selection Menu");
		Bukkit.getServer().getPluginManager().registerEvents( this, plugin);
	}
	
	public void show(Player p){
		//this.player = p;
		p.openInventory(inv);
		
	}
	
	

	@SuppressWarnings("unchecked")
	@EventHandler
	public void onInventoryClicker(InventoryClickEvent e){
		Player player = (Player) e.getWhoClicked();
		
		if(!MenuChecker.menuChecker(e,inv))
			return;
		if(e.getCurrentItem().equals(MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.LeftArrow.name")))){
			MainPlugin.perksSubMain.show(player);
			return;
		}
		if((CalculatePoints.getCurrentPoints(player)+CalculatePoints.getPointsForItem(e.getCurrentItem()) )>MainPlugin.config.getInt("MaximumPerkPoints")){
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

	public void init() {
		//sets up the border
		for(int i = 0; i<9; i++){
			inv.setItem(i, MainDataBaseHashMap.items.get("Border Purple"));
			inv.setItem(18+i, MainDataBaseHashMap.items.get("Border Purple"));
		}
		inv.clear(18+1);
		inv.setItem(18+1, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.LeftArrow.name")));

		inv.setItem(9,   MainDataBaseHashMap.items.get("Border Purple"));
		//inv.setItem(9+1, initHashMap.items.get("Weapon Perks"));
		inv.setItem(9+2, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.WaterDrinker.name")));
		inv.setItem(9+3, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.StoneEater.name")));
		inv.setItem(9+4, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.Carnivore.name")));
		inv.setItem(9+5, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.Herbivore.name")));
		inv.setItem(9+6, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.Nonivore.name")));
		//inv.setItem(9+7, initHashMap.items.get("Truce Perks"));
		inv.setItem(9+8, MainDataBaseHashMap.items.get("Border Purple"));	
	}
}
