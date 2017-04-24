package SaveAndLoading;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class FileLocation {
	
	public static File playerFile(Player player, Plugin plugin){
		File playerfile = new File(plugin.getDataFolder()+"/playerData/"+player.getUniqueId()+".yml");
		return playerfile;
	}
	
	public static FileConfiguration playerData(Player player,Plugin plugin){
		File playerfile = new File(plugin.getDataFolder()+"/playerData/"+player.getUniqueId()+".yml");
		
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
}
