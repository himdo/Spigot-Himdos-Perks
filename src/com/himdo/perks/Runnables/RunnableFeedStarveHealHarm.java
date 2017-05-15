package com.himdo.perks.Runnables;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.himdo.perks.MainPlugin;

public class RunnableFeedStarveHealHarm extends BukkitRunnable{

	@Override
	public void run() {
		for(Player p : Bukkit.getOnlinePlayers()){
			if(p.isDead()){
				continue;
			}
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.FeedLava.name"))){
				if(p.getLocation().getBlock().getType()==Material.LAVA||p.getLocation().getBlock().getType()==Material.STATIONARY_LAVA)
					p.setFoodLevel(p.getFoodLevel()+1);
			}
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.FeedSunlight.name"))){
				if(p.getLocation().getBlock().getLightFromSky()>14){
					p.setFoodLevel(p.getFoodLevel()+1);
				}
			}
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.FeedVegetation.name"))){
				Boolean fed = false;
				for(int x = -3; x<3;x++){
					for(int y =-3; y<3;y++){
						Material m = p.getLocation().getBlock().getRelative(x, 0, y).getType();
						
						if(m.equals(Material.CARROT)||m.equals(Material.POTATO)||m.equals(Material.CROPS)){
							fed = true;
							p.setFoodLevel(p.getFoodLevel()+1);
							break;
						}
						
					}
					if(fed){
						break;
					}
				}
			}
			
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.FeedWater.name"))){
				if(p.getLocation().getBlock().getType()==Material.WATER||p.getLocation().getBlock().getType()==Material.STATIONARY_WATER)
					if(p.getFoodLevel()!=20)
						p.setFoodLevel(p.getFoodLevel()+1);
			}
			
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.FeedLight.name"))){
				if(p.getLocation().getBlock().getLightLevel()>13)
					if(p.getFoodLevel()!=20)
					p.setFoodLevel(p.getFoodLevel()+1);
			}
			
			
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.FeedDarkness.name"))){
				if(p.getLocation().getBlock().getLightLevel()<7)
					if(p.getFoodLevel()!=20)
					p.setFoodLevel(p.getFoodLevel()+1);
			}
			
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.FeedAlways.name"))){
				if(p.getFoodLevel()!=20)
				p.setFoodLevel(p.getFoodLevel()+1);
			}
			
			
			
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.StarveLava.name"))){
				if(p.getLocation().getBlock().getType()==Material.LAVA||p.getLocation().getBlock().getType()==Material.STATIONARY_LAVA)
					if(p.getFoodLevel()!=0)
					p.setFoodLevel(p.getFoodLevel()-1);
			}
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.StarveSunlight.name"))){
				if(p.getLocation().getBlock().getLightFromSky()>14){
					if(p.getFoodLevel()!=0)
					p.setFoodLevel(p.getFoodLevel()-1);
				}
			}
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.StarveVegetation.name"))){
				Boolean starved = false;
				for(int x = -3; x<3;x++){
					for(int y =-3; y<3;y++){
						Material m = p.getLocation().getBlock().getRelative(x, 0, y).getType();
						if(m.equals(Material.CARROT)||m.equals(Material.POTATO)||m.equals(Material.WHEAT)){
							if(p.getFoodLevel()!=0){
								starved = true;
							p.setFoodLevel(p.getFoodLevel()-1);
							}
							
							break;
						}
						
					}
					if(starved){
						break;
					}
				}
			}
			
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.StarveWater.name"))){
				if(p.getLocation().getBlock().getType()==Material.WATER||p.getLocation().getBlock().getType()==Material.STATIONARY_WATER)
					if(p.getFoodLevel()!=0)
					p.setFoodLevel(p.getFoodLevel()-1);
			}
			
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.StarveLight.name"))){
				if(p.getLocation().getBlock().getLightLevel()>13)
					if(p.getFoodLevel()!=0)
					p.setFoodLevel(p.getFoodLevel()-1);
			}
			
			
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.StarveDarkness.name"))){
				if(p.getLocation().getBlock().getLightLevel()<7)
					if(p.getFoodLevel()!=0)
					p.setFoodLevel(p.getFoodLevel()-1);
			}
			
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.StarveAlways.name"))){
				if(p.getFoodLevel()!=0)
				p.setFoodLevel(p.getFoodLevel()-1);
			}
			
			
			
			
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.HealLava.name"))){
				if(p.getLocation().getBlock().getType()==Material.LAVA||p.getLocation().getBlock().getType()==Material.STATIONARY_LAVA)
					if((int)p.getHealth()<20)
					p.setHealth((int)p.getHealth()+1);
			}
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.HealSunlight.name"))){
				if(p.getLocation().getBlock().getLightFromSky()>14){
					if((int)p.getHealth()<20)
						p.setHealth((int)p.getHealth()+1);
					
				}
			}
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.HealVegetation.name"))){
				Boolean healed = false;
				for(int x = -3; x<3;x++){
					for(int y =-3; y<3;y++){
						Material m = p.getLocation().getBlock().getRelative(x, 0, y).getType();
						if(m.equals(Material.CARROT)||m.equals(Material.POTATO)||m.equals(Material.WHEAT)){
							if((int)p.getHealth()<20){
								healed = true;
							p.setHealth((int)p.getHealth()+1);
							}
							
							break;
						}
						
					}
					if(healed){
						break;
					}
				}
			}
			
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.HealWater.name"))){
				if(p.getLocation().getBlock().getType()==Material.WATER||p.getLocation().getBlock().getType()==Material.STATIONARY_WATER)
					if((int)p.getHealth()<20)
					p.setHealth((int)p.getHealth()+1);
			}
			
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.HealLight.name"))){
				if(p.getLocation().getBlock().getLightLevel()>13)
					if((int)p.getHealth()<20)
					p.setHealth((int)p.getHealth()+1);
			}
			
			
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.HealDarkness.name"))){
				if(p.getLocation().getBlock().getLightLevel()<7)
					if((int)p.getHealth()<20)
					p.setHealth((int)p.getHealth()+1);
			}
			
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.HealAlways.name"))){
				if((int)p.getHealth()<20)
				p.setHealth((int)p.getHealth()+1);
			}
			
			
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.HarmLava.name"))){
				if(p.getLocation().getBlock().getType()==Material.LAVA||p.getLocation().getBlock().getType()==Material.STATIONARY_LAVA)
					if((int)p.getHealth()>0)
					p.setHealth((int)p.getHealth()-1);
			}
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.HarmSunlight.name"))){
				if(p.getLocation().getBlock().getLightFromSky()>14){
					if((int)p.getHealth()>0)
					p.setHealth((int)p.getHealth()-1);
				}
			}
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.HarmVegetation.name"))){
				Boolean harmed = false;
				for(int x = -3; x<3;x++){
					for(int y =-3; y<3;y++){
						Material m = p.getLocation().getBlock().getRelative(x, 0, y).getType();
						
						if(m.equals(Material.CARROT)||m.equals(Material.POTATO)||m.equals(Material.WHEAT)){
							if((int)p.getHealth()>0){
								harmed = true;
							p.setHealth((int)p.getHealth()-1);
							}
							
							break;
						}
						
					}
					if(harmed){
						break;
					}
				}
			}
			
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.HarmWater.name"))){
				if(p.getLocation().getBlock().getType()==Material.WATER||p.getLocation().getBlock().getType()==Material.STATIONARY_WATER)
					if((int)p.getHealth()>0)
					p.setHealth((int)p.getHealth()-1);
			}
			
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.HarmLight.name"))){
				if(p.getLocation().getBlock().getLightLevel()>13)
					if((int)p.getHealth()>0)
					p.setHealth((int)p.getHealth()-1);
			}
			
			
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.HarmDarkness.name"))){
				if(p.getLocation().getBlock().getLightLevel()<7)
					if((int)p.getHealth()>0)
					p.setHealth((int)p.getHealth()-1);
			}
			
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.HarmAlways.name"))){
				if((int)p.getHealth()>0)
				p.setHealth((int)p.getHealth()-1);
			}
			
		}
		
	}

}
