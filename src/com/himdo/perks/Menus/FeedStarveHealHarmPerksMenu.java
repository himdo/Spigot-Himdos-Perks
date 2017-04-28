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
import com.himdo.perks.init.initHashMap;

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
			inv.setItem(i, initHashMap.items.get("Border Purple"));
			inv.setItem(9*5+i, initHashMap.items.get("Border Purple"));
		}
		inv.clear(9*5+1);
		inv.setItem(9*5+1, initHashMap.items.get("Back"));

		inv.setItem(9,   initHashMap.items.get("Feed Lava"));
		inv.setItem(9+1, initHashMap.items.get("Feed Sunlight"));
		inv.setItem(9+2, initHashMap.items.get("Feed Vegetation"));
		inv.setItem(9+3, initHashMap.items.get("Feed Water"));
		inv.setItem(9+4, initHashMap.items.get("Feed Light"));
		inv.setItem(9+5, initHashMap.items.get("Feed Darkness"));
		inv.setItem(9+6, initHashMap.items.get("Feed Meditation"));
		inv.setItem(9+7, initHashMap.items.get("Feed Always"));
		inv.setItem(9+8, initHashMap.items.get("Border Purple"));

		inv.setItem(9*2,   initHashMap.items.get("Starve Lava"));
		inv.setItem(9*2+1, initHashMap.items.get("Starve Sunlight"));
		inv.setItem(9*2+2, initHashMap.items.get("Starve Vegetation"));
		inv.setItem(9*2+3, initHashMap.items.get("Starve Water"));
		inv.setItem(9*2+4, initHashMap.items.get("Starve Light"));
		inv.setItem(9*2+5, initHashMap.items.get("Starve Darkness"));
		inv.setItem(9*2+6, initHashMap.items.get("Starve Meditation"));
		inv.setItem(9*2+7, initHashMap.items.get("Starve Always"));
		inv.setItem(9*2+8, initHashMap.items.get("Border Purple"));
		
		inv.setItem(9*3,   initHashMap.items.get("Heal Lava"));
		inv.setItem(9*3+1, initHashMap.items.get("Heal Sunlight"));
		inv.setItem(9*3+2, initHashMap.items.get("Heal Vegetation"));
		inv.setItem(9*3+3, initHashMap.items.get("Heal Water"));
		inv.setItem(9*3+4, initHashMap.items.get("Heal Light"));
		inv.setItem(9*3+5, initHashMap.items.get("Heal Darkness"));
		inv.setItem(9*3+6, initHashMap.items.get("Heal Meditation"));
		inv.setItem(9*3+7, initHashMap.items.get("Heal Always"));
		inv.setItem(9*3+8, initHashMap.items.get("Border Purple"));

		inv.setItem(9*4,   initHashMap.items.get("Harm Lava"));
		inv.setItem(9*4+1, initHashMap.items.get("Harm Sunlight"));
		inv.setItem(9*4+2, initHashMap.items.get("Harm Vegetation"));
		inv.setItem(9*4+3, initHashMap.items.get("Harm Water"));
		inv.setItem(9*4+4, initHashMap.items.get("Harm Light"));
		inv.setItem(9*4+5, initHashMap.items.get("Harm Darkness"));
		inv.setItem(9*4+6, initHashMap.items.get("Harm Meditation"));
		inv.setItem(9*4+7, initHashMap.items.get("Harm Always"));
		inv.setItem(9*4+8, initHashMap.items.get("Border Purple"));
		
		
	}
	
	public void show(Player p){
		//player = p;
		
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
		if(e.getCurrentItem().equals(initHashMap.items.get("Back"))){
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
