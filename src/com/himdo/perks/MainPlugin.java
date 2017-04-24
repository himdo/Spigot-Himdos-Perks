package com.himdo.perks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
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
import com.himdo.perks.init.initHashMap;

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
	
	
	BukkitTask tracker;
	
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
		
	
		
		tracker = new RunnableTasker(this).runTaskTimer(this, 20, 20);
		
		//setup perkHashMap
		initHashMap.setHashMap();
		
		
		
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
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@Override
	public void onDisable() {
		
	}
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
		
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player)){
			sender.sendMessage("Have to be a player");
			return true;
		}
		
		Player p = (Player) sender;
		if(args.length!=1){
			return false;
		}
		if(label.equalsIgnoreCase("traits")){
			if(args[0].equals("menu")){
				mainMenu.show(p);
				return true;
			}
			
		}
		return true;
		
	}
	
	
	
	@EventHandler
	public void onEntityTarget(EntityTargetEvent e){
		/*if(e.getEntity().getType()== EntityType.SPIDER)
			if(!e.isCancelled())
				e.setCancelled(true);
		*/
	}
	
}
