package com.himdo.perks.Menus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;

import com.himdo.perks.CalculatePoints;
import com.himdo.perks.MainPlugin;
import com.himdo.perks.MenuChecker;
import com.himdo.perks.hashMaps.MainDataBaseHashMap;

public class TraitsMenuMain implements Listener{
	private Inventory inv;
	private ItemStack playerSkull;
	//Player player;
	Plugin plugin;	
	static public HashMap<String,Inventory> playerInventory = new HashMap<String,Inventory>();
	//static ArrayList<Inventory> inventorys;
	
	public TraitsMenuMain(Plugin plugin) {
		inv = Bukkit.getServer().createInventory(null, 9*3,"[Perks] Menu");
		playerSkull = new ItemStack(Material.SKULL_ITEM,1,(byte)3);
		
		this.plugin = plugin;
				
		Bukkit.getServer().getPluginManager().registerEvents( this, plugin);
	}
	
	
	public void show(Player p){
		//this.player = p;
		if(!playerInventory.containsKey(p.getName())){
			SkullMeta skullmeta = (SkullMeta) playerSkull.getItemMeta();
			
			skullmeta.setOwner(p.getName());
			playerSkull.setItemMeta(skullmeta);
			ItemMeta itemMeta = playerSkull.getItemMeta();
			itemMeta.setDisplayName(p.getName()+"'s Choosen Perks");
			itemMeta.setLore(Arrays.asList(MainPlugin.playerPerks.get(p).size()+"/9 Perks Choosen",CalculatePoints.getCurrentPoints(p)+"/150 Points"));
			playerSkull.setItemMeta(itemMeta);
			inv.setItem(16, playerSkull);
			Inventory playered = Bukkit.getServer().createInventory(null, 9*3,"[Perks] "+p.getName()+" Menu");
			playered.setContents(inv.getContents());// = inv;
			playerInventory.put(p.getName(), playered);
		}
		Inventory playerInv = playerInventory.get(p.getName());
		SkullMeta skullmeta = (SkullMeta) playerSkull.getItemMeta();
		
		skullmeta.setOwner(p.getName());
		playerSkull.setItemMeta(skullmeta);
		ItemMeta itemMeta = playerSkull.getItemMeta();
		itemMeta.setDisplayName(p.getName()+"'s Choosen Perks");
		itemMeta.setLore(Arrays.asList(MainPlugin.playerPerks.get(p).size()+"/9 Perks Choosen",CalculatePoints.getCurrentPoints(p)+"/150 Points"));
		playerSkull.setItemMeta(itemMeta);
		playerInv.setItem(16, playerSkull);
		//playered.setContents(inv.getContents());// = inv;
		playerInventory.put(p.getName(), playerInv);
		
		
		p.openInventory(playerInventory.get(p.getName()));
		//p.updateInventory();
		
	}
	
	public void init(){
		inv.setItem(4+9, MainDataBaseHashMap.items.get("Help"));
		inv.setItem(1+9,MainDataBaseHashMap.items.get("Perks"));
		
		//Glass panes
		for(int i = 0; i<9; i++){
			inv.setItem(i, MainDataBaseHashMap.items.get("Border Purple"));
			inv.setItem(18+i, MainDataBaseHashMap.items.get("Border Purple"));
		}
		inv.setItem(9, MainDataBaseHashMap.items.get("Border Purple"));
		inv.setItem(17, MainDataBaseHashMap.items.get("Border Purple"));
		
		
	}
	
	@EventHandler
	public void onInventoryClicker(InventoryClickEvent e){
		//e.getWhoClicked().sendMessage(e.getCurrentItem()+"");
		//if the menu is not the correct menu like if a normal chest is opened
		if(e.getWhoClicked().getOpenInventory().getTitle()==null)
			return;
		if(playerInventory.get(e.getWhoClicked().getName())==null)
			return;
		if(!e.getInventory().getName().equals(playerInventory.get(e.getWhoClicked().getName()).getName())) {
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
		
		//if(!MenuChecker.menuChecker(e))
		//	return;
		
		Player pa = (Player) e.getWhoClicked();
		//if the inventory open is called "menu"
		if(pa.getOpenInventory().getTitle().equals(playerInventory.get(e.getWhoClicked().getName()).getName())){
			
		
			ItemStack selectedItem = e.getCurrentItem();
			
			if(selectedItem==null)
				return;
			//Perks Menu
			if(selectedItem.equals(MainDataBaseHashMap.items.get("Perks"))){
				MainPlugin.perksSubMain.show(pa);
			}
			//Player Menu
			if(selectedItem.equals(playerInventory.get(e.getWhoClicked().getName()).getItem(9+7))){
				MainPlugin.playerMenu.show(pa);
			}
			
		}
	}
	
	@EventHandler
	public void InventoryClickEvent(InventoryClickEvent e){
		Player pa = (Player) e.getWhoClicked();
		if(pa.getOpenInventory().getTitle()==null)
			return;
		if(playerInventory.get(e.getWhoClicked().getName())==null)
			return;
		if(pa.getOpenInventory().getTitle().equals(playerInventory.get(e.getWhoClicked().getName()).getName())){
			e.setCancelled(true);
		}
	}
	
	
}
