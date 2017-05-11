package com.himdo.perks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValueAdapter;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import com.himdo.perks.Events.FoodPerksEvents;
import com.himdo.perks.Events.SignEvents;
import com.himdo.perks.Events.SummonedEntityDeath;
import com.himdo.perks.Events.TrucePerkEvents;
import com.himdo.perks.Events.onEntityDamageEntityEvent;
import com.himdo.perks.Events.onEntityDamageEvent;
import com.himdo.perks.Events.onPlayerJoinEvents;
import com.himdo.perks.Events.onPlayerLeaveEvents;
import com.himdo.perks.Menus.BuffPerkMenu;
import com.himdo.perks.Menus.FeedStarveHealHarmPerksMenu;
import com.himdo.perks.Menus.FlyingPerksMenu;
import com.himdo.perks.Menus.FoodPerksMenu;
import com.himdo.perks.Menus.ImmunePerksMenu;
import com.himdo.perks.Menus.MiscPerksMenu;
import com.himdo.perks.Menus.PerksSubMain;
import com.himdo.perks.Menus.PlayerMenu;
import com.himdo.perks.Menus.StrikeRevengePerksMenu;
import com.himdo.perks.Menus.PerksMenuMain;
import com.himdo.perks.Menus.TrucePerksMenu;
import com.himdo.perks.Menus.WeaponPerksMenu;
import com.himdo.perks.Menus.Help.PerksSubHelpMain;
import com.himdo.perks.Misc.CalculatePoints;
import com.himdo.perks.Misc.PlayerDeleteInvaildPerks;
import com.himdo.perks.Runnables.RunnableAbsoption;
import com.himdo.perks.Runnables.RunnableBuffManager;
import com.himdo.perks.Runnables.RunnableFeedStarveHealHarm;
import com.himdo.perks.Runnables.RunnableFlying;
import com.himdo.perks.Runnables.RunnableImmunity;
import com.himdo.perks.hashMaps.FoodArrayList;
import com.himdo.perks.hashMaps.MainDataBaseHashMap;
import com.himdo.perks.hashMaps.PerkArrayList;
import com.himdo.perks.hashMaps.WeaponArrayLists;

public class MainPlugin extends JavaPlugin implements Listener{
	
	public static PerksMenuMain mainMenu;
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
	
	public static PerksSubHelpMain HelpMenu;
	
	public static HashMap<Player, ArrayList> playerPerks = new HashMap<Player, ArrayList>();
	
	public static Plugin plugin;
	
	public static FileConfiguration config;
	
	
	BukkitTask tracker;
	BukkitTask flying;
	BukkitTask ABSORPTION;
	BukkitTask ImmunityTracker;
	BukkitTask FeedPerks;
	
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
		
		config = getConfig();
		
		plugin = this;
		
		//tracks potion effects
		tracker = new RunnableBuffManager().runTaskTimer(this, 20, 20);
		//tracks ABSORPTION buff to make non op every 30 seconds
		ABSORPTION = new RunnableAbsoption().runTaskTimer(this, 20, 20*30);
		//tracks immunity from debuffs
		ImmunityTracker = new RunnableImmunity().runTaskTimer(this, 20, 20);
		//tracks flying perks
		flying = new RunnableFlying().runTaskTimer(this, 20, 20);
		//tracks feed perks every 10 seconds
		FeedPerks = new RunnableFeedStarveHealHarm().runTaskTimer(this, 20, 20*10);
		
		
		//setup perkHashMap
		MainDataBaseHashMap.setHashMap();
		//set up foodArrayLists
		FoodArrayList.init();
		//set up WeaponArrayList
		WeaponArrayLists.init();
		//set up a array list that contains all the perks names
		PerkArrayList.init();
		
		
		mainMenu = new PerksMenuMain(this);
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
		
		HelpMenu = new PerksSubHelpMain(this);
		HelpMenu.init();
		
		
		Iterator playerIterator = Bukkit.getServer().getOnlinePlayers().iterator();
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
			
			playerData.set("ChoosenPerks", PlayerDeleteInvaildPerks.Trim((ArrayList)playerData.get("ChoosenPerks")));
			
			try {
				playerData.save(playerfile);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			//stores players info when player joins server
			playerPerks.put(player, (ArrayList) playerData.get("ChoosenPerks"));
			
			Constants.canFly.put(player.getName(), false);
			
		}
		
		
		getServer().getPluginManager().registerEvents(new SummonedEntityDeath(), this);
		getServer().getPluginManager().registerEvents(new SignEvents(), this);
		getServer().getPluginManager().registerEvents(new onEntityDamageEvent(), this);
		getServer().getPluginManager().registerEvents(new FoodPerksEvents(), this);
		getServer().getPluginManager().registerEvents(new TrucePerkEvents(), this);
		getServer().getPluginManager().registerEvents(new onPlayerJoinEvents(), this);
		getServer().getPluginManager().registerEvents(new onPlayerLeaveEvents(), this);
		getServer().getPluginManager().registerEvents(new onEntityDamageEntityEvent(), this);
		//getServer().getPluginManager().registerEvents(this, this);
	}
	
	
	@Override
	public void onDisable() {
		Iterator playerIterator =Bukkit.getServer().getOnlinePlayers().iterator();
		while(playerIterator.hasNext()){
			Player player = (Player) playerIterator.next();
			player.closeInventory();
			
		}
		PerksMenuMain.playerInventory.clear();
		PlayerMenu.playerInventory.clear();
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(args.length==0){
			sender.sendMessage("Commands:");
			sender.sendMessage("/perks menu");
			sender.sendMessage("/perks inspect <Player Name>");
		}
		if(args.length==2){
			if(args[0].equalsIgnoreCase("inspect")){
				if(Bukkit.getPlayer(args[1])!=null){
					sender.sendMessage(args[1]+" perks: "+playerPerks.get(Bukkit.getPlayer(args[1])));//+" points: "+CalculatePoints.getCurrentPoints(Bukkit.getPlayer(args[1]))+"/"+config.getInt("MaximumPerkPoints")));
					
				}else{
					sender.sendMessage("Usage: /perks inspect <Player name>");
				}
				return true;
			}
		}
		
		
		
		if(args.length==1){
			
			//if(label.equalsIgnoreCase("perks")){
				
				/*
				if(args[0].equals("summon")){
					if(!(sender instanceof Player)){
						sender.sendMessage("Have to be a player");
						return true;
					}
					Player p = (Player) sender;
					LivingEntity entity = (LivingEntity) Bukkit.getWorld("world").spawn(p.getLocation(), EntityType.BLAZE.getEntityClass());
					entity.setCustomName(ChatColor.DARK_RED+p.getName()+"'s "+entity.getType());
					entity.setMetadata(p.getName(), new FixedMetadataValue(this,p.getName()));
					entity.setMetadata("owned", new FixedMetadataValue(this,p.getName()));
					
				}*/
				
				
				if(args[0].equalsIgnoreCase("menu")){
					
					if(!(sender instanceof Player)){
						sender.sendMessage("Have to be a player");
						return true;
					}

					Player p = (Player) sender;
					
					mainMenu.show(p);
					return true;
				}
				
			}
		//}
		return true;
		
	}
	
	
	
}
