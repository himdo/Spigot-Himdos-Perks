package com.himdo.perks.Menus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;

import com.himdo.perks.CalculatePoints;
import com.himdo.perks.MainPlugin;
import com.himdo.perks.MenuChecker;
import com.himdo.perks.SaveAndLoading.FileLocation;
import com.himdo.perks.hashMaps.MainDataBaseHashMap;

public class ImmunePerksMenu implements Listener{
	private Inventory inv;
	//Player player;
	Plugin plugin;
	
	public ImmunePerksMenu(Plugin plugin) {
		this.plugin=plugin;
		inv = Bukkit.getServer().createInventory(null, 9*4,"[Perks]Immunity Perk Selection Menu");
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

	public void init() {

		//sets up the border
		for(int i = 0; i<9; i++){
			inv.setItem(i, MainDataBaseHashMap.items.get("Border Purple"));
			inv.setItem(9*3+i, MainDataBaseHashMap.items.get("Border Purple"));
		}
		inv.clear(9*3+1);
		inv.setItem(9*3+1, MainDataBaseHashMap.items.get("Back"));

		inv.setItem(9,   MainDataBaseHashMap.items.get("Border Purple"));
		inv.setItem(9+1, MainDataBaseHashMap.items.get("Immune Armorpen"));
		inv.setItem(9+2, MainDataBaseHashMap.items.get("Immune Harm"));
		inv.setItem(9+3, MainDataBaseHashMap.items.get("Immune Hunger"));
		inv.setItem(9+4, MainDataBaseHashMap.items.get("Immune Nausea"));
		inv.setItem(9+5, MainDataBaseHashMap.items.get("Immune Starve"));
		inv.setItem(9+6, MainDataBaseHashMap.items.get("Immune Fall"));
		inv.setItem(9+7, MainDataBaseHashMap.items.get("Immune Steal"));
		inv.setItem(9+8, MainDataBaseHashMap.items.get("Border Purple"));
		
		inv.setItem(9*2,   MainDataBaseHashMap.items.get("Border Purple"));
		inv.setItem(9*2+1, MainDataBaseHashMap.items.get("Immune Weakness"));
		inv.setItem(9*2+2, MainDataBaseHashMap.items.get("Immune Wither"));
		inv.setItem(9*2+3, MainDataBaseHashMap.items.get("Immune Fire"));
		inv.setItem(9*2+4, MainDataBaseHashMap.items.get("Immune Poison"));
		inv.setItem(9*2+5, MainDataBaseHashMap.items.get("Immune Blindness"));
		inv.setItem(9*2+6, MainDataBaseHashMap.items.get("Immune Slow"));
		//inv.setItem(9*2+7, initHashMap.items.get(""));
		inv.setItem(9*2+8, MainDataBaseHashMap.items.get("Border Purple"));
		
				
	}
}
