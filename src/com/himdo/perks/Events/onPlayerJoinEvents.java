package com.himdo.perks.Events;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;

import com.himdo.perks.MainPlugin;

public class onPlayerJoinEvents implements Listener{
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){
		for (PotionEffect effect : e.getPlayer().getActivePotionEffects()){
			e.getPlayer().removePotionEffect(effect.getType());
		}
		File playerfile = new File(MainPlugin.plugin.getDataFolder()+"/playerData/"+e.getPlayer().getUniqueId()+".yml");
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
		MainPlugin.playerPerks.put(e.getPlayer(), (ArrayList) playerData.get("ChoosenPerks"));
		
	}
}
