package com.himdo.perks.Menus;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;

import com.himdo.perks.MainPlugin;
import com.himdo.perks.init.initHashMap;

import SaveAndLoading.FileLocation;

public class PlayerMenu implements Listener{
	//this menu pops up when they click on their head
	private Inventory inv;
	Player player;
	Plugin plugin;
	
	public PlayerMenu(Plugin plugin) {
		
		this.plugin = plugin;
		inv = Bukkit.getServer().createInventory(null, 9*3,"Player Menu");
		
		Bukkit.getServer().getPluginManager().registerEvents( this, plugin);
	}
	
	
	public void show(Player player){
		
		this.player=player;
		
		YamlConfiguration playerConfig = YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder()+"/playerData/"+player.getUniqueId()+".yml"));
		
		@SuppressWarnings("rawtypes")
		ArrayList perks = (ArrayList) playerConfig.get("ChoosenPerks");
		for(int i=0;i<perks.size();i++){
			inv.setItem(9+i,initHashMap.items.get(perks.get(i)));
		}
		player.openInventory(inv);
		
	}
	
	@SuppressWarnings("unchecked")
	@EventHandler
	public void InventoryClickEvent(InventoryClickEvent e){
		Player pa = (Player) e.getWhoClicked();
		if(pa.getOpenInventory().getTitle().equals(inv.getName())){
			if(e.getClick().isRightClick()){
				FileConfiguration playerData = FileLocation.playerData(pa, plugin);

				ArrayList<String> perks = (ArrayList<String>) playerData.get("ChoosenPerks");
				perks.remove(e.getCurrentItem().getItemMeta().getDisplayName());
				playerData.set("ChoosenPerks", perks);
				try {
					playerData.save(FileLocation.playerFile(pa, plugin));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}else{
				if(e.getCurrentItem().equals(initHashMap.items.get("Back"))){
					MainPlugin.mainMenu.show(player);
				}
			}
			e.setCancelled(true);
		}
	}


	public void init() {
		for(int i = 0; i<9; i++){
			inv.setItem(i, initHashMap.items.get("Border Purple"));
			inv.setItem(18+i, initHashMap.items.get("Border Purple"));
		}
		inv.clear(18+1);
		inv.setItem(18+1, initHashMap.items.get("Back"));
		
	}
}
