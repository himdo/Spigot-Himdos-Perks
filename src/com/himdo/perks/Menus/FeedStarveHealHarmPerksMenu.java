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

public class FeedStarveHealHarmPerksMenu implements Listener{
	private Inventory inv;
	//Player player;
	Plugin plugin;
	
	public FeedStarveHealHarmPerksMenu(Plugin plugin) {
		this.plugin=plugin;
		inv = Bukkit.getServer().createInventory(null, 9*6,"[Perks]Feed Perk Selection Menu");
		Bukkit.getServer().getPluginManager().registerEvents( this, plugin);
	}
	
	public void init(){
		for(int i = 0; i<9; i++){
			inv.setItem(i, MainDataBaseHashMap.items.get("Border Purple"));
			inv.setItem(9*5+i, MainDataBaseHashMap.items.get("Border Purple"));
		}
		inv.clear(9*5+1);
		inv.setItem(9*5+1, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.LeftArrow.name")));

		inv.setItem(9, MainDataBaseHashMap.items.get("Border Purple"));
		inv.setItem(9+1,   MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.FeedLava.name")));
		inv.setItem(9+2, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.FeedSunlight.name")));
		inv.setItem(9+3, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.FeedVegetation.name")));
		inv.setItem(9+4, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.FeedWater.name")));
		inv.setItem(9+5, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.FeedLight.name")));
		inv.setItem(9+6, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.FeedDarkness.name")));
		//inv.setItem(9+6, MainDataBaseHashMap.items.get("Feed Meditation"));
		inv.setItem(9+7, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.FeedAlways.name")));
		inv.setItem(9+8, MainDataBaseHashMap.items.get("Border Purple"));

		inv.setItem(9*2, MainDataBaseHashMap.items.get("Border Purple"));
		inv.setItem(9*2+1,   MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.StarveLava.name")));
		inv.setItem(9*2+2, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.StarveSunlight.name")));
		inv.setItem(9*2+3, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.StarveVegetation.name")));
		inv.setItem(9*2+4, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.StarveWater.name")));
		inv.setItem(9*2+5, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.StarveLight.name")));
		inv.setItem(9*2+6, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.StarveDarkness.name")));
		//inv.setItem(9*2+6, MainDataBaseHashMap.items.get("Starve Meditation"));
		inv.setItem(9*2+7, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.StarveAlways.name")));
		inv.setItem(9*2+8, MainDataBaseHashMap.items.get("Border Purple"));

		inv.setItem(9*3, MainDataBaseHashMap.items.get("Border Purple"));
		inv.setItem(9*3+1,   MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.HealLava.name")));
		inv.setItem(9*3+2, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.HealSunlight.name")));
		inv.setItem(9*3+3, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.HealVegetation.name")));
		inv.setItem(9*3+4, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.HealWater.name")));
		inv.setItem(9*3+5, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.HealLight.name")));
		inv.setItem(9*3+6, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.HealDarkness.name")));
		//inv.setItem(9*3+6, MainDataBaseHashMap.items.get("Heal Meditation"));
		inv.setItem(9*3+7, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.HealAlways.name")));
		inv.setItem(9*3+8, MainDataBaseHashMap.items.get("Border Purple"));

		inv.setItem(9*4, MainDataBaseHashMap.items.get("Border Purple"));
		inv.setItem(9*4+1,   MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.HarmLava.name")));
		inv.setItem(9*4+2, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.HarmSunlight.name")));
		inv.setItem(9*4+3, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.HarmVegetation.name")));
		inv.setItem(9*4+4, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.HarmWater.name")));
		inv.setItem(9*4+5, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.HarmLight.name")));
		inv.setItem(9*4+6, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.HarmDarkness.name")));
		//inv.setItem(9*4+6, MainDataBaseHashMap.items.get("Harm Meditation"));
		inv.setItem(9*4+7, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.HarmAlways.name")));
		inv.setItem(9*4+8, MainDataBaseHashMap.items.get("Border Purple"));
		
		
	}
	
	public void show(Player p){
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
}
