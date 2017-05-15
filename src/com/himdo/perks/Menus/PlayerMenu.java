package com.himdo.perks.Menus;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;

import com.himdo.perks.Constants;
import com.himdo.perks.MainPlugin;
import com.himdo.perks.Misc.CalculatePoints;
import com.himdo.perks.Misc.MenuChecker;
import com.himdo.perks.SaveAndLoading.FileLocation;
import com.himdo.perks.hashMaps.MainDataBaseHashMap;

public class PlayerMenu implements Listener{
	//this menu pops up when they click on their head
	private Inventory inv;
	
	static public HashMap<String,Inventory> playerInventory = new HashMap<String,Inventory>();
	
	
	public PlayerMenu(Plugin plugin) {
		
		inv = Bukkit.getServer().createInventory(null, 9*3,"[Perks]Player Menu");
		
		Bukkit.getServer().getPluginManager().registerEvents( this, plugin);
	}
	
	
	public void show(Player player){
		
		
		if(!playerInventory.containsKey(player.getName())){
			Inventory playered = Bukkit.getServer().createInventory(null, 9*3,MainPlugin.config.getString("Menu.PlayerMenu.Name"));
			playered.setContents(inv.getContents());
			playerInventory.put(player.getName(), playered);
		}
		
		YamlConfiguration playerConfig = YamlConfiguration.loadConfiguration(new File(MainPlugin.plugin.getDataFolder()+"/playerData/"+player.getUniqueId()+".yml"));
		Inventory playered = playerInventory.get(player.getName());
		
		@SuppressWarnings("rawtypes")
		ArrayList perks = (ArrayList) playerConfig.get("ChosenPerks");
		for(int i = 0; i<9;i++){
			playered.clear(9+i);
		}
		for(int i=0;i<perks.size();i++){
			playered.setItem(9+i,MainDataBaseHashMap.items.get(perks.get(i)));
		}
		
		playerInventory.put(player.getName(), playered);
		
		player.openInventory(playerInventory.get(player.getName()));
		
	}
	
	@EventHandler
	public void onInventoryClicker(InventoryClickEvent e){
		Player player = (Player) e.getWhoClicked();
		
		if(player.getOpenInventory().getTitle().equals(inv.getName())){
			
			
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
			if(e.getCurrentItem().equals(MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.LeftArrow.name")))){
				MainPlugin.mainMenu.show(player);
				if(MainPlugin.config.getBoolean("PlaySounds")){
					player.playSound(player.getLocation(), Sound.ITEM_HOE_TILL, 1, 1);
				}
				return;
			}
			
			if(e.getClick().isRightClick()){
				
				@SuppressWarnings("rawtypes")
				ArrayList perks = (ArrayList) MainPlugin.playerPerks.get(player);
				
				if(perks==null||perks.isEmpty())
					return;
				
				
				
				if(perks.contains(e.getCurrentItem().getItemMeta().getDisplayName())){
					//makes sure the player cant just remove debuffs and got over the MainPlugin.config.getInt("MaximumPerkPoints") points
					if((CalculatePoints.getCurrentPoints(player)-CalculatePoints.getPointsForItem(e.getCurrentItem()))<=MainPlugin.config.getInt("MaximumPerkPoints")){
						//this prevents a player that is flying in my plugin from being able to still fly when removing that perk
						if(e.getCurrentItem().getItemMeta().getDisplayName().equals(MainPlugin.config.getString("Perks.FlyWater.name"))
								||e.getCurrentItem().getItemMeta().getDisplayName().equals(MainPlugin.config.getString("Perks.FlyLava.name"))
								||e.getCurrentItem().getItemMeta().getDisplayName().equals(MainPlugin.config.getString("Perks.FlyWeb.name"))){
							((Player)e.getWhoClicked()).setAllowFlight(false);
							((Player)e.getWhoClicked()).setFlying(false);
							Constants.canFly.put(((Player)e.getWhoClicked()).getName(), false);
						}
						
						perks.remove(e.getCurrentItem().getItemMeta().getDisplayName());
						Inventory temp = playerInventory.get(player.getName());
						temp.clear(e.getSlot());
						playerInventory.put(player.getName(), temp);
						
					}else{
						//got to many points
						player.sendMessage("Can't Remove, Would allow to many points");
					}
				}
				
				if(MainPlugin.config.getBoolean("PlaySounds")){
					player.playSound(player.getLocation(), Sound.ENTITY_BAT_TAKEOFF, 1, 1);
				}
				
				if(MainPlugin.config.getBoolean("FireworkOnEquip")){
					//Spawn the Firework, get the FireworkMeta.
		            Firework fw = (Firework) player.getWorld().spawnEntity(player.getLocation(), EntityType.FIREWORK);
		            FireworkMeta fwm = fw.getFireworkMeta();
		           
		            //Our random generator
		            Random r = new Random();   
		 
		            //Get the type
		            int rt = r.nextInt(4) + 1;
		            Type type = Type.BALL;       
		            if (rt == 1) type = Type.BALL;
		            if (rt == 2) type = Type.BALL_LARGE;
		            if (rt == 3) type = Type.BURST;
		            if (rt == 4) type = Type.CREEPER;
		            if (rt == 5) type = Type.STAR;
		               
		            //Create our effect with this
		            FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(Color.RED).withFade(Color.ORANGE).with(type).trail(r.nextBoolean()).build();
		           
		            //Then apply the effect to the meta
		            fwm.addEffect(effect);
		           
		            //Generate some random power and set it
		            int rp = r.nextInt(2) + 1;
		            fwm.setPower(rp);
		           
		            //Then apply this to our rocket
		            fw.setFireworkMeta(fwm);  
				}
				
				
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
		inv.setItem(18+1, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.LeftArrow.name")));
		
	}
}
