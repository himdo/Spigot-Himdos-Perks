package com.himdo.perks.Menus;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;

import com.himdo.perks.MainPlugin;
import com.himdo.perks.Misc.CalculatePoints;
import com.himdo.perks.Misc.MenuChecker;
import com.himdo.perks.SaveAndLoading.FileLocation;
import com.himdo.perks.hashMaps.MainDataBaseHashMap;

public class PlayerMenu implements Listener{
	//this menu pops up when they click on their head
	private Inventory inv;
	//Player player;
	static public HashMap<String,Inventory> playerInventory = new HashMap<String,Inventory>();
	
	
	public PlayerMenu(Plugin plugin) {
		
		inv = Bukkit.getServer().createInventory(null, 9*3,"[Perks]Player Menu");
		
		Bukkit.getServer().getPluginManager().registerEvents( this, plugin);
	}
	
	
	public void show(Player player){
		
		//this.player=player;
		if(!playerInventory.containsKey(player.getName())){
			Inventory playered = Bukkit.getServer().createInventory(null, 9*3,"[Perks]Player Menu");
			playered.setContents(inv.getContents());
			playerInventory.put(player.getName(), playered);
		}
		
		YamlConfiguration playerConfig = YamlConfiguration.loadConfiguration(new File(MainPlugin.plugin.getDataFolder()+"/playerData/"+player.getUniqueId()+".yml"));
		Inventory playered = playerInventory.get(player.getName());
		
		@SuppressWarnings("rawtypes")
		ArrayList perks = (ArrayList) playerConfig.get("ChoosenPerks");
		for(int i = 0; i<9;i++){
			playered.clear(9+i);
		}
		for(int i=0;i<perks.size();i++){
			playered.setItem(9+i,MainDataBaseHashMap.items.get(perks.get(i)));
		}
		
		//playered.setContents(playered.getContents());// = inv;
		playerInventory.put(player.getName(), playered);
		
		player.openInventory(playerInventory.get(player.getName()));
		
	}
	@EventHandler
	public void onInventoryClicker(InventoryClickEvent e){
		//Player pa = (Player) e.getWhoClicked();
		Player player = (Player) e.getWhoClicked();
		
		if(player.getOpenInventory().getTitle().equals(inv.getName())){//playerInventory.get(player.getName()).getName())){
			
			
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
			if(e.getCurrentItem().equals(MainDataBaseHashMap.items.get("Back"))){
				MainPlugin.mainMenu.show(player);
				return;
			}
			
			if(e.getClick().isRightClick()){
				
				//pa.sendMessage("in right click");
				@SuppressWarnings("rawtypes")
				ArrayList perks = (ArrayList) MainPlugin.playerPerks.get(player);
				//pa.sendMessage(perks+"");
				
				if(perks==null||perks.isEmpty())
					return;
				
				if(perks.contains(e.getCurrentItem().getItemMeta().getDisplayName())){
					//makes sure the player cant just remove debuffs and got over the 150 points
					if((CalculatePoints.getCurrentPoints(player)-CalculatePoints.getPointsForItem(e.getCurrentItem()))<150){

						perks.remove(e.getCurrentItem().getItemMeta().getDisplayName());
						//inv.clear(e.getSlot());
						Inventory temp = playerInventory.get(player.getName());
						temp.clear(e.getSlot());
						playerInventory.put(player.getName(), temp);
					}else{
						//got to many points
						player.sendMessage("Can't Remove, Would allow to many points");
					}
				}
				
				//pa.sendMessage(perks+"");
				FileLocation.save(player);
				for (PotionEffect effect : player.getActivePotionEffects()){
					player.removePotionEffect(effect.getType());
				}
				
			}
		}
	}
	
	
	@EventHandler
	public void InventoryClickEvent(InventoryClickEvent e){
		
		
		
		Player player = (Player) e.getWhoClicked();
		if(player.getOpenInventory()==null)
			return;
		if(e.getWhoClicked().getOpenInventory().getTitle().equals(inv.getName())){
			e.setCancelled(true);
		} 
	}


	public void init() {
		for(int i = 0; i<9; i++){
			inv.setItem(i, MainDataBaseHashMap.items.get("Border Purple"));
			inv.setItem(18+i, MainDataBaseHashMap.items.get("Border Purple"));
		}
		inv.clear(18+1);
		inv.setItem(18+1, MainDataBaseHashMap.items.get("Back"));
		
	}
}
