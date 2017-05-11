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

public class TrucePerksMenu implements Listener{
	private Inventory inv;
	//Player player;
	Plugin plugin;
	
	public TrucePerksMenu(Plugin plugin) {
		this.plugin=plugin;
		inv = Bukkit.getServer().createInventory(null, 9*3,MainPlugin.config.getString("Menu.TrucePerkMenu.Name"));
		Bukkit.getServer().getPluginManager().registerEvents( this, plugin);
	}
	
	public void show(Player p){
		//this.player = p;
		p.openInventory(inv);
		
	}
	
	

	@SuppressWarnings("unchecked")
	@EventHandler
	public void onInventoryClicker(InventoryClickEvent e){
		if(!e.getInventory().getName().equals(inv.getName())) {
			return;
		}
		
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
		inv.setItem(MainPlugin.config.getInt("Perks.TruceSlime.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.TruceSlime.name")));
		inv.setItem(MainPlugin.config.getInt("Perks.TruceBlaze.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.TruceBlaze.name")));
		inv.setItem(MainPlugin.config.getInt("Perks.TruceSilverFish.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.TruceSilverFish.name")));
		inv.setItem(MainPlugin.config.getInt("Perks.TruceSpider.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.TruceSpider.name")));
		inv.setItem(MainPlugin.config.getInt("Perks.TruceUndead.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.TruceUndead.name")));
		inv.setItem(MainPlugin.config.getInt("Perks.TruceCreeper.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.TruceCreeper.name")));
		inv.setItem(MainPlugin.config.getInt("Perks.TruceGhast.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.TruceGhast.name")));
		inv.setItem(MainPlugin.config.getInt("Perks.TruceWitch.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.TruceWitch.name")));
	}
}
