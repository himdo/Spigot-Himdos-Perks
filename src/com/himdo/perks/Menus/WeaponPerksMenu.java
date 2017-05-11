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

public class WeaponPerksMenu implements Listener{
	private Inventory inv;
	//Player player;
	Plugin plugin;
	
	public WeaponPerksMenu(Plugin plugin) {
		this.plugin=plugin;
		inv = Bukkit.getServer().createInventory(null, 9*6,MainPlugin.config.getString("Menu.WeaponPerkMenu.Name"));
		Bukkit.getServer().getPluginManager().registerEvents( this, plugin);
	}
	
	public void show(Player p){
		//this.player = p;
		p.openInventory(inv);
		
	}
	
	

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
			inv.setItem(9*5+i, MainDataBaseHashMap.items.get("Border Purple"));
		}
		inv.clear(9*5+1);
		inv.setItem(9*5+1, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.LeftArrow.name")));
		
		inv.setItem(9*1,   MainDataBaseHashMap.items.get("Border Purple"));
		inv.setItem(MainPlugin.config.getInt("Perks.ExpertArchery.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.ExpertArchery.name")));
		inv.setItem(MainPlugin.config.getInt("Perks.ExpertAxe.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.ExpertAxe.name")));
		inv.setItem(MainPlugin.config.getInt("Perks.ExpertSword.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.ExpertSword.name")));
		inv.setItem(MainPlugin.config.getInt("Perks.ExpertUnarmed.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.ExpertUnarmed.name")));
		//inv.setItem(9*1+5, initHashMap.items.get());
		//inv.setItem(9*1+6, initHashMap.items.get());
		//inv.setItem(9*1+7, initHashMap.items.get());
		inv.setItem(9*1+8, MainDataBaseHashMap.items.get("Border Purple"));
		
		inv.setItem(9*2,   MainDataBaseHashMap.items.get("Border Purple"));
		inv.setItem(MainPlugin.config.getInt("Perks.ResistantArchery.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.ResistantArchery.name")));
		inv.setItem(MainPlugin.config.getInt("Perks.ResistantAxe.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.ResistantAxe.name")));
		inv.setItem(MainPlugin.config.getInt("Perks.ResistantSword.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.ResistantSword.name")));
		inv.setItem(MainPlugin.config.getInt("Perks.ResistantUnarmed.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.ResistantUnarmed.name")));
		//inv.setItem(9*2+5, initHashMap.items.get());
		//inv.setItem(9*2+6, initHashMap.items.get());
		//inv.setItem(9*2+7, initHashMap.items.get());
		inv.setItem(9*2+8, MainDataBaseHashMap.items.get("Border Purple"));
		
		inv.setItem(9*3,   MainDataBaseHashMap.items.get("Border Purple"));
		inv.setItem(MainPlugin.config.getInt("Perks.IneptArchery.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.IneptArchery.name")));
		inv.setItem(MainPlugin.config.getInt("Perks.IneptAxe.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.IneptAxe.name")));
		inv.setItem(MainPlugin.config.getInt("Perks.IneptSword.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.IneptSword.name")));
		inv.setItem(MainPlugin.config.getInt("Perks.IneptUnarmed.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.IneptUnarmed.name")));
		//inv.setItem(9*3+5, initHashMap.items.get());
		//inv.setItem(9*3+6, initHashMap.items.get());
		//inv.setItem(9*3+7, initHashMap.items.get());
		inv.setItem(9*3+8, MainDataBaseHashMap.items.get("Border Purple"));
		
		inv.setItem(9*4,   MainDataBaseHashMap.items.get("Border Purple"));
		inv.setItem(MainPlugin.config.getInt("Perks.VulnerableArchery.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.VulnerableArchery.name")));
		inv.setItem(MainPlugin.config.getInt("Perks.VulnerableAxe.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.VulnerableAxe.name")));
		inv.setItem(MainPlugin.config.getInt("Perks.VulnerableSword.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.VulnerableSword.name")));
		inv.setItem(MainPlugin.config.getInt("Perks.VulnerableUnarmed.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.VulnerableUnarmed.name")));
		//inv.setItem(9*4+5, initHashMap.items.get());
		//inv.setItem(9*4+6, initHashMap.items.get());
		//inv.setItem(9*4+7, initHashMap.items.get());
		inv.setItem(9*4+8, MainDataBaseHashMap.items.get("Border Purple"));
	}
}
