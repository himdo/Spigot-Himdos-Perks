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

public class WeaponPerksMenu implements Listener{
	private Inventory inv;
	//Player player;
	Plugin plugin;
	
	public WeaponPerksMenu(Plugin plugin) {
		this.plugin=plugin;
		inv = Bukkit.getServer().createInventory(null, 9*6,"[Perks] Weapon Perk Selection Menu");
		Bukkit.getServer().getPluginManager().registerEvents( this, plugin);
	}
	
	public void show(Player p){
		//this.player = p;
		p.openInventory(inv);
		
	}
	
	

	@SuppressWarnings("unchecked")
	@EventHandler
	public void onInventoryClicker(InventoryClickEvent e){
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
		Player player = (Player) e.getWhoClicked();
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
			inv.setItem(9*5+i, MainDataBaseHashMap.items.get("Border Purple"));
		}
		inv.clear(9*5+1);
		inv.setItem(9*5+1, MainDataBaseHashMap.items.get("Back"));
		
		inv.setItem(9*1,   MainDataBaseHashMap.items.get("Border Purple"));
		inv.setItem(9*1+1, MainDataBaseHashMap.items.get("Expert Archery"));
		inv.setItem(9*1+2, MainDataBaseHashMap.items.get("Expert Axe"));
		inv.setItem(9*1+3, MainDataBaseHashMap.items.get("Expert Sword"));
		inv.setItem(9*1+4, MainDataBaseHashMap.items.get("Expert Unarmed"));
		//inv.setItem(9*1+5, initHashMap.items.get(""));
		//inv.setItem(9*1+6, initHashMap.items.get(""));
		//inv.setItem(9*1+7, initHashMap.items.get(""));
		inv.setItem(9*1+8, MainDataBaseHashMap.items.get("Border Purple"));
		
		inv.setItem(9*2,   MainDataBaseHashMap.items.get("Border Purple"));
		inv.setItem(9*2+1, MainDataBaseHashMap.items.get("Resistant Archery"));
		inv.setItem(9*2+2, MainDataBaseHashMap.items.get("Resistant Axe"));
		inv.setItem(9*2+3, MainDataBaseHashMap.items.get("Resistant Sword"));
		inv.setItem(9*2+4, MainDataBaseHashMap.items.get("Resistant Unarmed"));
		//inv.setItem(9*2+5, initHashMap.items.get(""));
		//inv.setItem(9*2+6, initHashMap.items.get(""));
		//inv.setItem(9*2+7, initHashMap.items.get(""));
		inv.setItem(9*2+8, MainDataBaseHashMap.items.get("Border Purple"));
		
		inv.setItem(9*3,   MainDataBaseHashMap.items.get("Border Purple"));
		inv.setItem(9*3+1, MainDataBaseHashMap.items.get("Inept Archery"));
		inv.setItem(9*3+2, MainDataBaseHashMap.items.get("Inept Axe"));
		inv.setItem(9*3+3, MainDataBaseHashMap.items.get("Inept Sword"));
		inv.setItem(9*3+4, MainDataBaseHashMap.items.get("Inept Unarmed"));
		//inv.setItem(9*3+5, initHashMap.items.get(""));
		//inv.setItem(9*3+6, initHashMap.items.get(""));
		//inv.setItem(9*3+7, initHashMap.items.get(""));
		inv.setItem(9*3+8, MainDataBaseHashMap.items.get("Border Purple"));
		
		inv.setItem(9*4,   MainDataBaseHashMap.items.get("Border Purple"));
		inv.setItem(9*4+1, MainDataBaseHashMap.items.get("Vulnerable Archery"));
		inv.setItem(9*4+2, MainDataBaseHashMap.items.get("Vulnerable Axe"));
		inv.setItem(9*4+3, MainDataBaseHashMap.items.get("Vulnerable Sword"));
		inv.setItem(9*4+4, MainDataBaseHashMap.items.get("Vulnerable Unarmed"));
		//inv.setItem(9*4+5, initHashMap.items.get(""));
		//inv.setItem(9*4+6, initHashMap.items.get(""));
		//inv.setItem(9*4+7, initHashMap.items.get(""));
		inv.setItem(9*4+8, MainDataBaseHashMap.items.get("Border Purple"));
	}
}
