package com.himdo.perks.SaveAndLoading;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class CustomConfig extends YamlConfiguration{
	@SuppressWarnings("unused")
	private File file=null;
	@SuppressWarnings("unused")
	private FileConfiguration playerData = null;
	public CustomConfig() {
		playerData = new YamlConfiguration();
		
		// TODO Auto-generated constructor stub
	}
}
