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
import com.himdo.perks.Misc.MenuChecker;
import com.himdo.perks.hashMaps.MainDataBaseHashMap;

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
			inv.setItem(i, MainDataBaseHashMap.items.get("Border Purple"));
			inv.setItem(18+i, MainDataBaseHashMap.items.get("Border Purple"));
		}
		inv.clear(18+1);
		inv.setItem(18+1, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.LeftArrow.name")));

		inv.setItem(9,   MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.Buffs.name")));
		inv.setItem(9+1, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.WeaponStats.name")));
		inv.setItem(9+2, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.StrikeRevenge.name")));
		inv.setItem(9+3, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.FeedStarveHealHarm.name")));
		inv.setItem(9+4, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.Food.name")));
		inv.setItem(9+5, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.Immune.name")));
		inv.setItem(9+6, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.Fly.name")));
		inv.setItem(9+7, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.Truce.name")));
		inv.setItem(9+8, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.Misc.name")));
		
		
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
		
		
		if(e.getCurrentItem().equals(MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.LeftArrow.name")))){
			MainPlugin.mainMenu.show(player);
			return;
		}
		if(e.getCurrentItem().equals(MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.Buffs.name")))){
			MainPlugin.buffPerkMenu.show(player);
		}else if(e.getCurrentItem().equals(MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.WeaponStats.name")))){
			MainPlugin.weaponPerksMenu.show(player);
		}else if(e.getCurrentItem().equals(MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.StrikeRevenge.name")))){
			MainPlugin.strikePerksMenu.show(player);
		}else if(e.getCurrentItem().equals(MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.FeedStarveHealHarm.name")))){
			MainPlugin.healHarmMenu.show(player);
		}else if(e.getCurrentItem().equals(MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.Food.name")))){
			MainPlugin.foodPerkMenu.show(player);
		}else if(e.getCurrentItem().equals(MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.Immune.name")))){
			MainPlugin.immunePerkMenu.show(player);
		}else if(e.getCurrentItem().equals(MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.Fly.name")))){
			MainPlugin.flyingPerkMenu.show(player);
		}else if(e.getCurrentItem().equals(MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.Truce.name")))){
			MainPlugin.trucePerksMenu.show(player);
		}else if(e.getCurrentItem().equals(MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.Misc.name")))){
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
