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
			if(MainPlugin.playerPerks.get(p).contains("Feed Lava")){
				if(p.getLocation().getBlock().getType()==Material.LAVA||p.getLocation().getBlock().getType()==Material.STATIONARY_LAVA)
					p.setFoodLevel(p.getFoodLevel()+1);
			}
			if(MainPlugin.playerPerks.get(p).contains("Feed Sunlight")){
				if(p.getLocation().getBlock().getLightFromSky()>14){
					p.setFoodLevel(p.getFoodLevel()+1);
				}
			}
			if(MainPlugin.playerPerks.get(p).contains("Feed Vegetation")){
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
			
			if(MainPlugin.playerPerks.get(p).contains("Feed Water")){
				if(p.getLocation().getBlock().getType()==Material.WATER||p.getLocation().getBlock().getType()==Material.STATIONARY_WATER)
					if(p.getFoodLevel()!=20)
						p.setFoodLevel(p.getFoodLevel()+1);
			}
			
			if(MainPlugin.playerPerks.get(p).contains("Feed Light")){
				if(p.getLocation().getBlock().getLightLevel()>13)
					if(p.getFoodLevel()!=20)
					p.setFoodLevel(p.getFoodLevel()+1);
			}
			
			
			if(MainPlugin.playerPerks.get(p).contains("Feed Darkness")){
				if(p.getLocation().getBlock().getLightLevel()<7)
					if(p.getFoodLevel()!=20)
					p.setFoodLevel(p.getFoodLevel()+1);
			}
			
			if(MainPlugin.playerPerks.get(p).contains("Feed Always")){
				if(p.getFoodLevel()!=20)
				p.setFoodLevel(p.getFoodLevel()+1);
			}
			
			
			
			if(MainPlugin.playerPerks.get(p).contains("Starve Lava")){
				if(p.getLocation().getBlock().getType()==Material.LAVA||p.getLocation().getBlock().getType()==Material.STATIONARY_LAVA)
					if(p.getFoodLevel()!=0)
					p.setFoodLevel(p.getFoodLevel()-1);
			}
			if(MainPlugin.playerPerks.get(p).contains("Starve Sunlight")){
				if(p.getLocation().getBlock().getLightFromSky()>14){
					if(p.getFoodLevel()!=0)
					p.setFoodLevel(p.getFoodLevel()-1);
				}
			}
			if(MainPlugin.playerPerks.get(p).contains("Starve Vegetation")){
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
			
			if(MainPlugin.playerPerks.get(p).contains("Starve Water")){
				if(p.getLocation().getBlock().getType()==Material.WATER||p.getLocation().getBlock().getType()==Material.STATIONARY_WATER)
					if(p.getFoodLevel()!=0)
					p.setFoodLevel(p.getFoodLevel()-1);
			}
			
			if(MainPlugin.playerPerks.get(p).contains("Starve Light")){
				if(p.getLocation().getBlock().getLightLevel()>13)
					if(p.getFoodLevel()!=0)
					p.setFoodLevel(p.getFoodLevel()-1);
			}
			
			
			if(MainPlugin.playerPerks.get(p).contains("Starve Darkness")){
				if(p.getLocation().getBlock().getLightLevel()<7)
					if(p.getFoodLevel()!=0)
					p.setFoodLevel(p.getFoodLevel()-1);
			}
			
			if(MainPlugin.playerPerks.get(p).contains("Starve Always")){
				if(p.getFoodLevel()!=0)
				p.setFoodLevel(p.getFoodLevel()-1);
			}
			
			
			
			
			if(MainPlugin.playerPerks.get(p).contains("Heal Lava")){
				if(p.getLocation().getBlock().getType()==Material.LAVA||p.getLocation().getBlock().getType()==Material.STATIONARY_LAVA)
					if((int)p.getHealth()<20)
					p.setHealth((int)p.getHealth()+1);
			}
			if(MainPlugin.playerPerks.get(p).contains("Heal Sunlight")){
				if(p.getLocation().getBlock().getLightFromSky()>14){
					if((int)p.getHealth()<20)
						p.setHealth((int)p.getHealth()+1);
					
				}
			}
			if(MainPlugin.playerPerks.get(p).contains("Heal Vegetation")){
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
			
			if(MainPlugin.playerPerks.get(p).contains("Heal Water")){
				if(p.getLocation().getBlock().getType()==Material.WATER||p.getLocation().getBlock().getType()==Material.STATIONARY_WATER)
					if((int)p.getHealth()<20)
					p.setHealth((int)p.getHealth()+1);
			}
			
			if(MainPlugin.playerPerks.get(p).contains("Heal Light")){
				if(p.getLocation().getBlock().getLightLevel()>13)
					if((int)p.getHealth()<20)
					p.setHealth((int)p.getHealth()+1);
			}
			
			
			if(MainPlugin.playerPerks.get(p).contains("Heal Darkness")){
				if(p.getLocation().getBlock().getLightLevel()<7)
					if((int)p.getHealth()<20)
					p.setHealth((int)p.getHealth()+1);
			}
			
			if(MainPlugin.playerPerks.get(p).contains("Heal Always")){
				if((int)p.getHealth()<20)
				p.setHealth((int)p.getHealth()+1);
			}
			
			
			if(MainPlugin.playerPerks.get(p).contains("Harm Lava")){
				if(p.getLocation().getBlock().getType()==Material.LAVA||p.getLocation().getBlock().getType()==Material.STATIONARY_LAVA)
					if((int)p.getHealth()>0)
					p.setHealth((int)p.getHealth()-1);
			}
			if(MainPlugin.playerPerks.get(p).contains("Harm Sunlight")){
				if(p.getLocation().getBlock().getLightFromSky()>14){
					if((int)p.getHealth()>0)
					p.setHealth((int)p.getHealth()-1);
				}
			}
			if(MainPlugin.playerPerks.get(p).contains("Harm Vegetation")){
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
			
			if(MainPlugin.playerPerks.get(p).contains("Harm Water")){
				if(p.getLocation().getBlock().getType()==Material.WATER||p.getLocation().getBlock().getType()==Material.STATIONARY_WATER)
					if((int)p.getHealth()>0)
					p.setHealth((int)p.getHealth()-1);
			}
			
			if(MainPlugin.playerPerks.get(p).contains("Harm Light")){
				if(p.getLocation().getBlock().getLightLevel()>13)
					if((int)p.getHealth()>0)
					p.setHealth((int)p.getHealth()-1);
			}
			
			
			if(MainPlugin.playerPerks.get(p).contains("Harm Darkness")){
				if(p.getLocation().getBlock().getLightLevel()<7)
					if((int)p.getHealth()>0)
					p.setHealth((int)p.getHealth()-1);
			}
			
			if(MainPlugin.playerPerks.get(p).contains("Harm Always")){
				if((int)p.getHealth()>0)
				p.setHealth((int)p.getHealth()-1);
			}
			
		}
		
	}

}
