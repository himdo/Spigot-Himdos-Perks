package com.himdo.perks;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.himdo.perks.init.initHashMap;

public class CalculatePoints {
	public static int getCurrentPoints(Player player){
		int totalPoints=0;
		
		YamlConfiguration playerConfig = YamlConfiguration.loadConfiguration(new File(MainPlugin.plugin.getDataFolder()+"/playerData/"+player.getUniqueId()+".yml"));
		
		ArrayList perks = (ArrayList) playerConfig.get("ChoosenPerks");
		
		for(int i=0;i<perks.size();i++){
			totalPoints+=0;
			ArrayList<String> lore = (ArrayList<String>) initHashMap.items.get(perks.get(i)).getItemMeta().getLore();
			int size = lore.size();
			String loreParts = lore.get(size-1);
			totalPoints+=Integer.parseInt(loreParts.split(" ")[1]);
		}
		return totalPoints;
	}
	
	public static int getPointsForItem(ItemStack itemStack){
		int points = 0;
		List<String> lore = itemStack.getItemMeta().getLore();
		
		int size = lore.size();
		String loreParts =lore.get(size-1);
		points=Integer.parseInt(loreParts.split(" ")[1]);
		
		return points;
	}
}
