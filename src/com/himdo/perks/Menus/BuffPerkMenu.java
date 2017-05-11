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

public class BuffPerkMenu implements Listener{

	private Inventory inv;
	//Player player;
	Plugin plugin;
	
	public BuffPerkMenu(Plugin plugin) {
		this.plugin=plugin;
		inv = Bukkit.getServer().createInventory(null, 9*4,MainPlugin.config.getString("Menu.BuffPerkMenu.Name"));
		Bukkit.getServer().getPluginManager().registerEvents( this, plugin);
	}
	
	public void show(Player p){
		//this.player = p;
		p.openInventory(inv);
		
	}
	
	public void init(){
		for(int i = 0; i<9; i++){
			inv.setItem(i, MainDataBaseHashMap.items.get("Border Purple"));
			inv.setItem((9*3)+i, MainDataBaseHashMap.items.get("Border Purple"));
		}
		inv.clear((9*3)+1);
		inv.setItem((9*3)+1, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.LeftArrow.name")));
		//MainPlugin.config.getInt("Perks.Buffs.inventorySlot")
		inv.setItem(MainPlugin.config.getInt("Perks.Haste.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.Haste.name")));
		inv.setItem(MainPlugin.config.getInt("Perks.Jump.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.Jump.name")));
		inv.setItem(MainPlugin.config.getInt("Perks.Speed.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.Speed.name")));
		inv.setItem(MainPlugin.config.getInt("Perks.HealthBoost.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.HealthBoost.name")));
		inv.setItem(MainPlugin.config.getInt("Perks.NightVision.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.NightVision.name")));
		inv.setItem(MainPlugin.config.getInt("Perks.WaterBreathing.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.WaterBreathing.name")));
		//inv.setItem(9+6, initHashMap.items.get(""));
		//inv.setItem(9+7, initHashMap.items.get(""));
		//inv.setItem(9+8, initHashMap.items.get(""));
		
		inv.setItem(MainPlugin.config.getInt("Perks.Haste2.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.Haste2.name")));
		inv.setItem(MainPlugin.config.getInt("Perks.Jump2.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.Jump2.name")));
		inv.setItem(MainPlugin.config.getInt("Perks.Speed2.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.Speed2.name")));
		inv.setItem(MainPlugin.config.getInt("Perks.HealthBoost2.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.HealthBoost2.name")));
		//inv.setItem(9*2+4, initHashMap.items.get(""));
		//inv.setItem(9*2+5, initHashMap.items.get(""));
		inv.setItem(MainPlugin.config.getInt("Perks.MiningFatigue.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.MiningFatigue.name")));
		inv.setItem(MainPlugin.config.getInt("Perks.Slow.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.Slow.name")));
		inv.setItem(MainPlugin.config.getInt("Perks.Blind.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.Blind.name")));
		
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
		
		if(e.getCurrentItem().equals(initHashMap.items.get(MainPlugin.config.getString("Perks.LeftArrow.name")))){
			MainPlugin.perksSubMain.show(player);
			return;
		}	
		
		if(e.getCurrentItem().equals(initHashMap.items.get("Border Purple"))){
			
			return;
			
		}
			
		if(MainPlugin.playerPerks.get(player).contains(e.getCurrentItem().getItemMeta().getDisplayName())){
			return;
		}*/
		if(!MenuChecker.menuChecker(e,inv))
			return;
		if(e.getCurrentItem().equals(MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.LeftArrow.name")))){
			MainPlugin.perksSubMain.show(player);
			return;
		}
		//player.sendMessage(CalculatePoints.getPointsForItem(e.getCurrentItem())+"");
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
}
