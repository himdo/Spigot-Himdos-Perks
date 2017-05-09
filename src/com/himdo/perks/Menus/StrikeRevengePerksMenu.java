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

public class StrikeRevengePerksMenu implements Listener{
	private Inventory inv;
	//Player player;
	Plugin plugin;
	
	public StrikeRevengePerksMenu(Plugin plugin) {
		this.plugin=plugin;
		inv = Bukkit.getServer().createInventory(null, 9*6,"[Perks]Strike/Revenge Selection Menu");
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
			inv.setItem(9*5+i, MainDataBaseHashMap.items.get("Border Purple"));
		}
		inv.clear(9*5+1);
		inv.setItem(9*5+1, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.LeftArrow.name")));

		/*inv.setItem(9,   initHashMap.items.get());
		inv.setItem(9+1, initHashMap.items.get());
		inv.setItem(9+2, initHashMap.items.get());
		inv.setItem(9+3, initHashMap.items.get());
		inv.setItem(9+4, initHashMap.items.get());
		inv.setItem(9+5, initHashMap.items.get());
		inv.setItem(9+6, initHashMap.items.get());
		inv.setItem(9+7, initHashMap.items.get());
		inv.setItem(9+8, initHashMap.items.get());*/
		
		inv.setItem(9,   MainDataBaseHashMap.items.get("Border Purple"));
		inv.setItem(9+1, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.StrikeFeed.name")));
		inv.setItem(9+2, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.StrikeFire.name")));
		inv.setItem(9+3, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.StrikeHunger.name")));
		inv.setItem(9+4, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.StrikeNausea.name")));
		inv.setItem(9+5, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.StrikeWeakness.name")));
		//inv.setItem(9+5, MainDataBaseHashMap.items.get("Strike Steal"));
		inv.setItem(9+6, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.StrikeArmorpen.name")));
		inv.setItem(9+7, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.StrikeHarm.name")));
		inv.setItem(9+8, MainDataBaseHashMap.items.get("Border Purple"));
		
		inv.setItem(9*2,   MainDataBaseHashMap.items.get("Border Purple"));
		inv.setItem(9*2+1, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.StrikeHeal.name")));
		inv.setItem(9*2+2, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.StrikeSlow.name")));
		inv.setItem(9*2+3, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.StrikePoison.name")));
		inv.setItem(9*2+4, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.StrikeStarve.name")));
		inv.setItem(9*2+5, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.StrikeWither.name")));
		inv.setItem(9*2+6, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.StrikeBlindness.name")));
		inv.setItem(9*2+7, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.StrikeStun.name")));
		inv.setItem(9*2+8, MainDataBaseHashMap.items.get("Border Purple"));
		
		inv.setItem(9*3,   MainDataBaseHashMap.items.get("Border Purple"));
		inv.setItem(9*3+1, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.RevengeFeed.name")));
		inv.setItem(9*3+2, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.RevengeFire.name")));
		inv.setItem(9*3+3, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.RevengeHunger.name")));
		inv.setItem(9*3+4, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.RevengeNausea.name")));
		inv.setItem(9*3+5, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.RevengeWeakness.name")));
		//inv.setItem(9*3+5, MainDataBaseHashMap.items.get("Revenge Steal"));
		inv.setItem(9*3+6, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.RevengeArmorpen.name")));
		inv.setItem(9*3+7, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.RevengeHarm.name")));
		inv.setItem(9*3+8, MainDataBaseHashMap.items.get("Border Purple"));
		
		inv.setItem(9*4,   MainDataBaseHashMap.items.get("Border Purple"));
		inv.setItem(9*4+1, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.RevengeHeal.name")));
		inv.setItem(9*4+2, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.RevengeSlow.name")));
		inv.setItem(9*4+3, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.RevengePoison.name")));
		inv.setItem(9*4+4, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.RevengeStarve.name")));
		inv.setItem(9*4+5, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.RevengeWither.name")));
		inv.setItem(9*4+6, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.RevengeBlindness.name")));
		inv.setItem(9*4+7, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.RevengeStun.name")));
		inv.setItem(9*4+8, MainDataBaseHashMap.items.get("Border Purple"));
	}
}
