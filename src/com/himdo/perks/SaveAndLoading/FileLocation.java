package com.himdo.perks.SaveAndLoading;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.himdo.perks.MainPlugin;

public class FileLocation {
	
	public static File playerFile(Player player){
		File playerfile = new File(MainPlugin.plugin.getDataFolder()+"/playerData/"+player.getUniqueId()+".yml");
		return playerfile;
	}
	
	public static FileConfiguration playerData(Player player){
		File playerfile = new File(MainPlugin.plugin.getDataFolder()+"/playerData/"+player.getUniqueId()+".yml");
		
		FileConfiguration playerData = new YamlConfiguration();
		try {
			playerData.load(playerfile);
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		} catch (InvalidConfigurationException e2) {
			e2.printStackTrace();
		}
		return playerData;
		
	}
	
	
	@SuppressWarnings("rawtypes")
	public static void save(Player player){
		FileConfiguration playerData = playerData(player);
		playerData.set("ChoosenPerks", (ArrayList) MainPlugin.playerPerks.get(player));
		try {
			playerData.save(playerFile(player));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
