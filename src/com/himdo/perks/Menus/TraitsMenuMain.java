package com.himdo.perks.Menus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;

import com.himdo.perks.MainPlugin;
import com.himdo.perks.init.initHashMap;

public class TraitsMenuMain implements Listener{
	private Inventory inv;
	private ItemStack playerSkull;
	Player player;
	Plugin plugin;	
	
	
	public TraitsMenuMain(Plugin plugin) {
		inv = Bukkit.getServer().createInventory(null, 9*3,"Menu");
		playerSkull = new ItemStack(Material.SKULL_ITEM,1,(byte)3);
		
		this.plugin = plugin;
				
		Bukkit.getServer().getPluginManager().registerEvents( this, plugin);
	}
	
	
	public void show(Player p){
		this.player = p;
		SkullMeta skullmeta = (SkullMeta) playerSkull.getItemMeta();
		
		skullmeta.setOwner(player.getName());
		playerSkull.setItemMeta(skullmeta);
		inv.setItem(16, playerSkull);
		
		
		p.openInventory(inv);
		p.updateInventory();
		
	}
	
	public void init(){
		inv.setItem(4+9, initHashMap.items.get("Help"));
		inv.setItem(1+9,initHashMap.items.get("Perks"));
		
		//Glass panes
		for(int i = 0; i<9; i++){
			inv.setItem(i, initHashMap.items.get("Border Purple"));
			inv.setItem(18+i, initHashMap.items.get("Border Purple"));
		}
		inv.setItem(9, initHashMap.items.get("Border Purple"));
		inv.setItem(17, initHashMap.items.get("Border Purple"));
		
		
	}
	
	Boolean debug=false;
	@EventHandler
	public void onInventoryClicker(InventoryClickEvent e){
		
		//if the menu is not the correct menu like if a normal chest is opened
		if(!e.getInventory().getName().equals(inv.getName())) {
			return;
		}
		/*File playerfile = new File(plugin.getDataFolder()+"/playerData/"+e.getWhoClicked().getUniqueId()+".yml");
		FileConfiguration playerData= new YamlConfiguration();
		
		try {
			playerData.load(playerfile);
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		} catch (InvalidConfigurationException e2) {
			e2.printStackTrace();
		}
		//playerData.set("ChoosenPerks", new ArrayList<>());
		*/
		
		Player pa = (Player) e.getWhoClicked();
		//if the inventory open is called "menu"
		if(pa.getOpenInventory().getTitle().equals(inv.getName())){
			
			if(debug)
				pa.sendMessage("clicked");
			
			if(debug){
				pa.sendMessage(e.getCurrentItem()+"");
			}
			ItemStack selectedItem = e.getCurrentItem();
			
			/*if(selectedItem.equals(initHashMap.items.get("Night Vision"))){
				if(debug)
					pa.sendMessage("you clicked it");
				
				ArrayList perks = (ArrayList) playerData.get("ChoosenPerks");
				if(!perks.contains("Night Vision")){
					perks.add("Night Vision");
					playerData.set("ChoosenPerks", perks);
				}
				pa.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,Integer.MAX_VALUE,0));
				
			}else*/
			//Perks Menu
			if(selectedItem.equals(initHashMap.items.get("Perks"))){
				//PerksSubMain perksMenu = new PerksSubMain(plugin);
				//perksMenu.show(player);
				//initShops.perksSubMain.show(player);
				MainPlugin.perksSubMain.show(player);
			}
			//Player Menu
			if(selectedItem.equals(playerSkull)){
				//playermenu = new PlayerMenu(this.plugin, this.player);
				//playermenu.show();
				MainPlugin.playerMenu.show(player);
			}
			
		}
		/*
		try {
			playerData.save(playerfile);
		} catch (IOException e1) {
			e1.printStackTrace();
		}*/
	}
	
	@EventHandler
	public void InventoryClickEvent(InventoryClickEvent e){
		Player pa = (Player) e.getWhoClicked();
		if(debug)
			pa.sendMessage(pa.getOpenInventory().getTitle()+"");
		if(pa.getOpenInventory().getTitle().equals(inv.getName())){
			if(debug)
				pa.sendMessage("Canceled");
			e.setCancelled(true);
		}
	}
	
	
}
