package com.himdo.perks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;

import com.himdo.perks.Menus.BuffPerkMenu;
import com.himdo.perks.Menus.FeedStarveHealHarmPerksMenu;
import com.himdo.perks.Menus.FlyingPerksMenu;
import com.himdo.perks.Menus.FoodPerksMenu;
import com.himdo.perks.Menus.ImmunePerksMenu;
import com.himdo.perks.Menus.MiscPerksMenu;
import com.himdo.perks.Menus.PerksSubMain;
import com.himdo.perks.Menus.PlayerMenu;
import com.himdo.perks.Menus.StrikeRevengePerksMenu;
import com.himdo.perks.Menus.TraitsMenuMain;
import com.himdo.perks.Menus.TrucePerksMenu;
import com.himdo.perks.Menus.WeaponPerksMenu;
import com.himdo.perks.Runnables.RunnableTasker;
import com.himdo.perks.Runnables.Perks.Flying.RunnableFlying;
import com.himdo.perks.hashMaps.FoodArrayList;
import com.himdo.perks.hashMaps.MainDataBaseHashMap;

public class MainPlugin extends JavaPlugin implements Listener{
	
	public static TraitsMenuMain mainMenu;
	public static PerksSubMain perksSubMain;
	public static BuffPerkMenu buffPerkMenu;
	public static FeedStarveHealHarmPerksMenu healHarmMenu;
	public static FlyingPerksMenu flyingPerkMenu;
	public static FoodPerksMenu foodPerkMenu;
	public static ImmunePerksMenu immunePerkMenu;
	public static MiscPerksMenu miscPerksMenu;
	public static PlayerMenu playerMenu;
	public static TrucePerksMenu trucePerksMenu;
	public static WeaponPerksMenu weaponPerksMenu;
	public static StrikeRevengePerksMenu strikePerksMenu;
	
	@SuppressWarnings("rawtypes")
	public static HashMap<Player, ArrayList> playerPerks = new HashMap<Player, ArrayList>();
	
	public static Plugin plugin;
	
	BukkitTask tracker;
	BukkitTask flying;
	
	
	@Override
	public void onEnable() {
		//config file
		File configFile = new File(this.getDataFolder()+"/config.yml");
		if(!configFile.exists()){
			this.saveDefaultConfig();
		}
		//player data folder
		File playerSaveFolder = new File(this.getDataFolder()+"/playerData");
		if(!playerSaveFolder.exists()){
			playerSaveFolder.mkdir();
		}
		
	
		//tracks potion effects
		tracker = new RunnableTasker(this).runTaskTimer(this, 20, 20);
		//tracks flying perks
		flying = new RunnableFlying(this).runTaskTimer(this, 20, 20);
		
		//setup perkHashMap
		MainDataBaseHashMap.setHashMap();
		//set up foodArrayLists
		FoodArrayList.init();
		
		
		mainMenu = new TraitsMenuMain(this);
		perksSubMain = new PerksSubMain(this);
		buffPerkMenu = new BuffPerkMenu(this);
		healHarmMenu = new FeedStarveHealHarmPerksMenu(this);
		flyingPerkMenu = new FlyingPerksMenu(this);
		foodPerkMenu= new FoodPerksMenu(this);
		immunePerkMenu = new ImmunePerksMenu(this);
		miscPerksMenu = new MiscPerksMenu(this);
		playerMenu = new PlayerMenu(this);
		trucePerksMenu = new TrucePerksMenu(this);
		weaponPerksMenu = new WeaponPerksMenu(this);
		strikePerksMenu = new StrikeRevengePerksMenu(this);
		
		mainMenu.init();
		perksSubMain.init();
		buffPerkMenu.init();
		healHarmMenu.init();
		flyingPerkMenu.init();
		foodPerkMenu.init();
		immunePerkMenu.init();
		miscPerksMenu.init();
		playerMenu.init();
		trucePerksMenu.init();
		weaponPerksMenu.init();
		strikePerksMenu.init();
		
		plugin = this;
		Iterator playerIterator =Bukkit.getServer().getOnlinePlayers().iterator();
		while(playerIterator.hasNext()){
			Player player = (Player) playerIterator.next();
			File playerfile = new File(this.getDataFolder()+"/playerData/"+player.getUniqueId()+".yml");
			FileConfiguration playerData;
			
			if(!playerfile.exists()){
				try {
					playerfile.createNewFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
			playerData = new YamlConfiguration();//.loadConfiguration(playerfile);
			try {
				playerData.load(playerfile);
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			} catch (InvalidConfigurationException e2) {
				e2.printStackTrace();
			}
			if(playerData.get("ChoosenPerks")==null)
				playerData.set("ChoosenPerks", new ArrayList<>());
			
			try {
				playerData.save(playerfile);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			//stores players info when player joins server
			playerPerks.put(player, (ArrayList) playerData.get("ChoosenPerks"));
			
		}
		
		
		
		
		
		
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public void onDisable() {
		Iterator playerIterator =Bukkit.getServer().getOnlinePlayers().iterator();
		while(playerIterator.hasNext()){
			Player player = (Player) playerIterator.next();
			player.closeInventory();
			
		}
		TraitsMenuMain.playerInventory.clear();
		PlayerMenu.playerInventory.clear();
	}
	
	
	
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent e){
		//removes players info when they leave the server
		playerPerks.remove(e.getPlayer());
		
		if(TraitsMenuMain.playerInventory.containsKey(e.getPlayer().getName()))
			TraitsMenuMain.playerInventory.remove(e.getPlayer().getName());
		if(PlayerMenu.playerInventory.containsKey(e.getPlayer().getName()))
			PlayerMenu.playerInventory.remove(e.getPlayer().getName());
	}
	
	
	@SuppressWarnings("rawtypes")
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){
		for (PotionEffect effect : e.getPlayer().getActivePotionEffects()){
			e.getPlayer().removePotionEffect(effect.getType());
		}
		File playerfile = new File(this.getDataFolder()+"/playerData/"+e.getPlayer().getUniqueId()+".yml");
		FileConfiguration playerData;
		if(!playerfile.exists()){
			try {
				playerfile.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		playerData = new YamlConfiguration();//.loadConfiguration(playerfile);
		try {
			playerData.load(playerfile);
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		} catch (InvalidConfigurationException e2) {
			e2.printStackTrace();
		}
		if(playerData.get("ChoosenPerks")==null)
			playerData.set("ChoosenPerks", new ArrayList<>());
		
		try {
			playerData.save(playerfile);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		//stores players info when player joins server
		playerPerks.put(e.getPlayer(), (ArrayList) playerData.get("ChoosenPerks"));
		
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player)){
			sender.sendMessage("Have to be a player");
			return true;
		}
		Player p = (Player) sender;
		if(args.length==0){
			p.sendMessage("Commands:");
			p.sendMessage("/perks menu");
			p.sendMessage("/perks inspect <Player Name>");
		}
		if(args.length==2){
			if(args[0].equals("inspect")){
				if(Bukkit.getPlayer(args[1])!=null){
					p.sendMessage(args[1]+" perks: "+playerPerks.get(Bukkit.getPlayer(args[1])));
					
				}else{
					p.sendMessage("Usage: /perks inspect <Player name>");
				}
				return true;
			}
		}
		if(args.length==1){
			if(label.equalsIgnoreCase("perks")){
				if(args[0].equals("menu")){
					mainMenu.show(p);
					return true;
				}
				
			}
		}
		return true;
		
	}
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e){
		
	}
	
	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent e){
		//the one who hits
		Player attacker = null;
		//the one who got hit
		Player player = null;
		
		if(e.getDamager() instanceof Player)
			attacker = (Player) e.getDamager();
		if(e.getEntity() instanceof Player)
			player = (Player) e.getEntity();
		
		if(attacker!=null&&player!=null){
			attacker.sendMessage("You damaged "+player.getName()+" for: "+e.getDamage()+" damage");
			player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 50, 1));
		}
		
	}
	
	@EventHandler
	public void onEntityTarget(EntityTargetEvent e){
		/*if(e.getEntity().getType()== EntityType.SPIDER)
			if(!e.isCancelled())
				e.setCancelled(true);
		*/
		if(e.getTarget() instanceof Player){
			Player player = (Player) e.getTarget();
			if(MainPlugin.playerPerks.get(player).contains("Truce Slime")){
				if(e.getEntity().getType()==EntityType.SLIME||e.getEntity().getType()==EntityType.MAGMA_CUBE)
					e.setCancelled(true);
			}
			if(MainPlugin.playerPerks.get(player).contains("Truce Blaze")){
				if(e.getEntity().getType()==EntityType.BLAZE)
					e.setCancelled(true);
			}
			if(MainPlugin.playerPerks.get(player).contains("Truce SilverFish")){
				if(e.getEntity().getType()==EntityType.SILVERFISH)
					e.setCancelled(true);
			}
			if(MainPlugin.playerPerks.get(player).contains("Truce Spider")){
				if(e.getEntity().getType()==EntityType.SPIDER||e.getEntity().getType()==EntityType.CAVE_SPIDER)
					e.setCancelled(true);
			}
			if(MainPlugin.playerPerks.get(player).contains("Truce Undead")){
				if(e.getEntity().getType()==EntityType.ZOMBIE||e.getEntity().getType()==EntityType.SKELETON||e.getEntity().getType()==EntityType.WITHER_SKELETON)
					e.setCancelled(true);
			}
			if(MainPlugin.playerPerks.get(player).contains("Truce Creeper")){
				if(e.getEntity().getType()==EntityType.CREEPER)
					e.setCancelled(true);
			}
			if(MainPlugin.playerPerks.get(player).contains("Truce Ghast")){
				if(e.getEntity().getType()==EntityType.GHAST)
					e.setCancelled(true);
			}
			if(MainPlugin.playerPerks.get(player).contains("Truce Witch")){
				if(e.getEntity().getType()==EntityType.WITCH)
					e.setCancelled(true);
			}
			
		}
	}
	
	@EventHandler
	public void onPlayerEat(PlayerItemConsumeEvent e){
		if(MainPlugin.playerPerks.get(e.getPlayer()).contains("Water Drinker")){
			if(e.getItem().getType().equals(Material.POTION)){
				e.getPlayer().setFoodLevel(e.getPlayer().getFoodLevel()+3);
			}
		}
		if(MainPlugin.playerPerks.get(e.getPlayer()).contains("Carnivore")){
			if(!FoodArrayList.Meat.contains(e.getItem().getType())&&!e.getItem().getType().equals(Material.POTION)){
				e.getPlayer().sendMessage("[Perks]: You Are a Carnivore, you Can't Eat this");
				e.setCancelled(true);
			}
		}
		if(MainPlugin.playerPerks.get(e.getPlayer()).contains("Herbivore")){
			if(!FoodArrayList.Veggies.contains(e.getItem().getType())&&!e.getItem().getType().equals(Material.POTION)){
				e.getPlayer().sendMessage("[Perks]: You Are a Herbivore, you Can't Eat this");
				e.setCancelled(true);
			}
		}
		if(MainPlugin.playerPerks.get(e.getPlayer()).contains("Nonivore")){
			if(!e.getItem().getType().equals(Material.POTION)){
				e.getPlayer().sendMessage("[Perks]: You can't eat, you are a Nonivore");
				e.setCancelled(true);
			}
			
		}
	}
	
	
	@EventHandler
	public void onBreak(BlockBreakEvent e){
		if(MainPlugin.playerPerks.get(e.getPlayer()).contains("Stone Eater")){
			if(e.getBlock().getType().equals(Material.STONE)){
				if(e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.AIR)){
					//adds to full hunger bars
					e.getPlayer().setFoodLevel(e.getPlayer().getFoodLevel()+4);
				}
			}
		}		
		
	}
	
}
