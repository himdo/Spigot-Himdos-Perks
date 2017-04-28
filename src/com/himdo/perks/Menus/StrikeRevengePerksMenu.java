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

	public void init() {
		//sets up the border
		for(int i = 0; i<9; i++){
			inv.setItem(i, initHashMap.items.get("Border Purple"));
			inv.setItem(9*5+i, initHashMap.items.get("Border Purple"));
		}
		inv.clear(9*5+1);
		inv.setItem(9*5+1, initHashMap.items.get("Back"));

		/*inv.setItem(9,   initHashMap.items.get(""));
		inv.setItem(9+1, initHashMap.items.get(""));
		inv.setItem(9+2, initHashMap.items.get(""));
		inv.setItem(9+3, initHashMap.items.get(""));
		inv.setItem(9+4, initHashMap.items.get(""));
		inv.setItem(9+5, initHashMap.items.get(""));
		inv.setItem(9+6, initHashMap.items.get(""));
		inv.setItem(9+7, initHashMap.items.get(""));
		inv.setItem(9+8, initHashMap.items.get(""));*/
		
		inv.setItem(9,   initHashMap.items.get("Border Purple"));
		inv.setItem(9+1, initHashMap.items.get("Strike Feed"));
		inv.setItem(9+2, initHashMap.items.get("Strike Fire"));
		inv.setItem(9+3, initHashMap.items.get("Strike Hunger"));
		inv.setItem(9+4, initHashMap.items.get("Strike Nausea"));
		inv.setItem(9+5, initHashMap.items.get("Strike Steal"));
		inv.setItem(9+6, initHashMap.items.get("Strike Armorpen"));
		inv.setItem(9+7, initHashMap.items.get("Strike Harm"));
		inv.setItem(9+8, initHashMap.items.get("Border Purple"));
		
		inv.setItem(9*2,   initHashMap.items.get("Border Purple"));
		inv.setItem(9*2+1, initHashMap.items.get("Strike Heal"));
		inv.setItem(9*2+2, initHashMap.items.get("Strike Slow"));
		inv.setItem(9*2+3, initHashMap.items.get("Strike Poison"));
		inv.setItem(9*2+4, initHashMap.items.get("Strike Starve"));
		inv.setItem(9*2+5, initHashMap.items.get("Strike Wither"));
		inv.setItem(9*2+6, initHashMap.items.get("Strike Blindness"));
		inv.setItem(9*2+7, initHashMap.items.get("Strike Stun"));
		inv.setItem(9*2+8, initHashMap.items.get("Strike Weakness"));
		
		inv.setItem(9*3,   initHashMap.items.get("Border Purple"));
		inv.setItem(9*3+1, initHashMap.items.get("Revenge Feed"));
		inv.setItem(9*3+2, initHashMap.items.get("Revenge Fire"));
		inv.setItem(9*3+3, initHashMap.items.get("Revenge Hunger"));
		inv.setItem(9*3+4, initHashMap.items.get("Revenge Nausea"));
		inv.setItem(9*3+5, initHashMap.items.get("Revenge Steal"));
		inv.setItem(9*3+6, initHashMap.items.get("Revenge Armorpen"));
		inv.setItem(9*3+7, initHashMap.items.get("Revenge Harm"));
		inv.setItem(9*3+8, initHashMap.items.get("Border Purple"));
		
		inv.setItem(9*4,   initHashMap.items.get("Border Purple"));
		inv.setItem(9*4+1, initHashMap.items.get("Revenge Heal"));
		inv.setItem(9*4+2, initHashMap.items.get("Revenge Slow"));
		inv.setItem(9*4+3, initHashMap.items.get("Revenge Poison"));
		inv.setItem(9*4+4, initHashMap.items.get("Revenge Starve"));
		inv.setItem(9*4+5, initHashMap.items.get("Revenge Wither"));
		inv.setItem(9*4+6, initHashMap.items.get("Revenge Blindness"));
		inv.setItem(9*4+7, initHashMap.items.get("Revenge Stun"));
		inv.setItem(9*4+8, initHashMap.items.get("Revenge Weakness"));
	}
}
