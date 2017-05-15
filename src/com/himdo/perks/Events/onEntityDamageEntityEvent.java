package com.himdo.perks.Events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.himdo.perks.MainPlugin;
import com.himdo.perks.Misc.DiceRoller;
import com.himdo.perks.hashMaps.WeaponArrayLists;

public class onEntityDamageEntityEvent implements Listener{
	@EventHandler (priority = EventPriority.HIGHEST)//this is highest inorder to work with McMMO if it was lower then mcmmo would go first and ruin the stats
	public void onEntityDamageByEntity(EntityDamageByEntityEvent e){
		//the one who hits
		Player attackerPlayer = null;
		//the one who got hit
		Player defenderPlayer = null;
		
		LivingEntity attackerEntity=null;
		LivingEntity defenderEntity = null;
		
		
		Arrow arrow = null;
		Snowball snowball = null;
		
		if(e.getDamager() instanceof Player)
			attackerPlayer = (Player) e.getDamager();
		if(e.getEntity() instanceof Player)
			defenderPlayer = (Player) e.getEntity();
		
		if(e.getDamager() instanceof LivingEntity)
			attackerEntity = (LivingEntity) e.getDamager();
		
		if(e.getEntity() instanceof LivingEntity)
			defenderEntity = (LivingEntity) e.getEntity();
		
		
		if(e.getDamager() instanceof Arrow){
			arrow = ((Arrow)e.getDamager());
			if(arrow.getShooter()instanceof Player)
				attackerPlayer = (Player)arrow.getShooter();
			if(arrow.getShooter() instanceof LivingEntity)
				attackerEntity = (LivingEntity)arrow.getShooter();
		}
		
		if(e.getDamager() instanceof Snowball){
			snowball = ((Snowball)e.getDamager());
			if(snowball.getShooter()instanceof Player)
				attackerPlayer = (Player)snowball.getShooter();
			if(snowball.getShooter() instanceof LivingEntity)
				attackerEntity = (LivingEntity)snowball.getShooter();
		}
	
		if(snowball!=null){
			if(attackerPlayer!=null){
				if(MainPlugin.playerPerks.get(attackerPlayer).contains(MainPlugin.config.getString("Perks.SnowBallThrower.name"))){
					e.setDamage(2);
				}
			}
		}
		//Weapon Perks
		if(arrow!=null){
			if(attackerPlayer!=null){
				if(MainPlugin.playerPerks.get(attackerPlayer).contains(MainPlugin.config.getString("Perks.ExpertArchery.name"))){
					if(attackerPlayer.getInventory().getItemInMainHand().getType().equals(Material.BOW)){
						e.setDamage(e.getDamage()+e.getDamage()/4);
					}
				}
				if(MainPlugin.playerPerks.get(attackerPlayer).contains(MainPlugin.config.getString("Perks.IneptArchery.name"))){
					if(attackerPlayer.getInventory().getItemInMainHand().getType().equals(Material.BOW)){
						e.setDamage(e.getDamage()-e.getDamage()/4);
					}
				}
			}
		
			if(defenderPlayer!=null){
				
				if(MainPlugin.playerPerks.get(defenderPlayer).contains(MainPlugin.config.getString("Perks.ResistantArchery.name"))){
					if(attackerEntity.getEquipment().getItemInMainHand().getType().equals(Material.BOW)){
						e.setDamage(e.getDamage()-e.getDamage()/4);
					}
				}
				
				if(MainPlugin.playerPerks.get(defenderPlayer).contains(MainPlugin.config.getString("Perks.VulnerableArchery.name"))){
					if(attackerEntity.getEquipment().getItemInMainHand().getType().equals(Material.BOW)){
						e.setDamage(e.getDamage()+e.getDamage()/4);
					}
				}	
			}
			
		}
		if(arrow==null){
			if(attackerPlayer!=null){
				if(MainPlugin.playerPerks.get(attackerPlayer).contains(MainPlugin.config.getString("Perks.ExpertAxe.name"))){
					if(WeaponArrayLists.Axes.contains(attackerPlayer.getInventory().getItemInMainHand().getType())){
						e.setDamage(e.getDamage()+e.getDamage()/4);
					}
				}
				if(MainPlugin.playerPerks.get(attackerPlayer).contains(MainPlugin.config.getString("Perks.ExpertUnarmed.name"))){
					if(attackerPlayer.getInventory().getItemInMainHand().getType().equals(Material.AIR)){
						e.setDamage(e.getDamage()+e.getDamage()/4);
					}
				}
				if(MainPlugin.playerPerks.get(attackerPlayer).contains(MainPlugin.config.getString("Perks.ExpertSword.name"))){
					if(WeaponArrayLists.Swords.contains(attackerPlayer.getInventory().getItemInMainHand().getType())){
						e.setDamage(e.getDamage()+e.getDamage()/4);
					}
				}
				
				if(MainPlugin.playerPerks.get(attackerPlayer).contains(MainPlugin.config.getString("Perks.IneptAxe.name"))){
					if(WeaponArrayLists.Axes.contains(attackerPlayer.getInventory().getItemInMainHand().getType())){
						e.setDamage(e.getDamage()-e.getDamage()/4);
					}
				}
				if(MainPlugin.playerPerks.get(attackerPlayer).contains(MainPlugin.config.getString("Perks.IneptUnarmed.name"))){
					if(attackerPlayer.getInventory().getItemInMainHand().getType().equals(Material.AIR)){
						e.setDamage(e.getDamage()-e.getDamage()/4);
					}
				}
				if(MainPlugin.playerPerks.get(attackerPlayer).contains(MainPlugin.config.getString("Perks.IneptSword.name"))){
					if(WeaponArrayLists.Swords.contains(attackerPlayer.getInventory().getItemInMainHand().getType())){
						e.setDamage(e.getDamage()-e.getDamage()/4);
					}
				}
			}
			
			if(defenderPlayer!=null){
				if(MainPlugin.playerPerks.get(defenderPlayer).contains(MainPlugin.config.getString("Perks.ResistantAxe.name"))){
					if(WeaponArrayLists.Axes.contains(attackerEntity.getEquipment().getItemInMainHand().getType())){
						e.setDamage(e.getDamage()-e.getDamage()/4);
					}
				}
				if(MainPlugin.playerPerks.get(defenderPlayer).contains(MainPlugin.config.getString("Perks.ResistantUnarmed.name"))){
					if(attackerEntity.getEquipment().getItemInMainHand().getType().equals(Material.AIR)){
						e.setDamage(e.getDamage()-e.getDamage()/4);
					}
				}
				if(MainPlugin.playerPerks.get(defenderPlayer).contains(MainPlugin.config.getString("Perks.ResistantSword.name"))){
					if(WeaponArrayLists.Swords.contains(attackerEntity.getEquipment().getItemInMainHand().getType())){
						e.setDamage(e.getDamage()-e.getDamage()/4);
					}
				}
				
				if(MainPlugin.playerPerks.get(defenderPlayer).contains(MainPlugin.config.getString("Perks.VulnerableAxe.name"))){
					if(WeaponArrayLists.Axes.contains(attackerEntity.getEquipment().getItemInMainHand().getType())){
						e.setDamage(e.getDamage()+e.getDamage()/4);
					}
				}
				if(MainPlugin.playerPerks.get(defenderPlayer).contains(MainPlugin.config.getString("Perks.VulnerableUnarmed.name"))){
					if(attackerEntity.getEquipment().getItemInMainHand().getType().equals(Material.AIR)){
						e.setDamage(e.getDamage()+e.getDamage()/4);
					}
				}
				if(MainPlugin.playerPerks.get(defenderPlayer).contains(MainPlugin.config.getString("Perks.VulnerableSword.name"))){
					if(WeaponArrayLists.Swords.contains(attackerEntity.getEquipment().getItemInMainHand().getType())){
						e.setDamage(e.getDamage()+e.getDamage()/4);
					}
				}
			}
		}
		//End Weapon Perks
		
		
		
		//Strike
		if(attackerPlayer!=null)
			if(MainPlugin.playerPerks.get(attackerPlayer).contains(MainPlugin.config.getString("Perks.StrikeFeed.name"))){
				if(DiceRoller.Roll(MainPlugin.config.getInt("StrikeChance"))==0){
					attackerPlayer.setFoodLevel(attackerPlayer.getFoodLevel()+2);
				}
			}
		
		if(attackerPlayer!=null)
			if(MainPlugin.playerPerks.get(attackerPlayer).contains(MainPlugin.config.getString("Perks.StrikeFire.name"))){
				if(DiceRoller.Roll(MainPlugin.config.getInt("StrikeChance"))==0){
					if(defenderPlayer!=null){
						if(!MainPlugin.playerPerks.get(defenderPlayer).contains(MainPlugin.config.getString("Perks.ImmuneFire.name"))){
							defenderEntity.setFireTicks(20*3);
						}
					}else{
						defenderEntity.setFireTicks(20*3);
					}
					
				}	
			}

		if(attackerPlayer!=null)
			if(MainPlugin.playerPerks.get(attackerPlayer).contains(MainPlugin.config.getString("Perks.StrikeHunger.name"))){
				if(DiceRoller.Roll(MainPlugin.config.getInt("StrikeChance"))==0){
					if(defenderPlayer!=null){
						if(!MainPlugin.playerPerks.get(defenderPlayer).contains(MainPlugin.config.getString("Perks.ImmuneHunger.name"))){
							defenderPlayer.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 20*5, 0), true);
						}
					}else{
						defenderEntity.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 20*5, 0), true);
					}
				}
			}
		if(attackerPlayer!=null)
			if(MainPlugin.playerPerks.get(attackerPlayer).contains(MainPlugin.config.getString("Perks.StrikeNausea.name"))){
				if(DiceRoller.Roll(MainPlugin.config.getInt("StrikeChance"))==0){
					if(defenderPlayer!=null){
						if(!MainPlugin.playerPerks.get(defenderPlayer).contains(MainPlugin.config.getString("Perks.ImmuneNausea.name"))){
							defenderPlayer.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 20*5, 0), true);
						}
					}else{
						defenderEntity.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 20*5, 0), true);
					}
				}
			}
		if(attackerPlayer!=null)
			if(MainPlugin.playerPerks.get(attackerPlayer).contains(MainPlugin.config.getString("Perks.StrikeWeakness.name"))){
				if(DiceRoller.Roll(MainPlugin.config.getInt("StrikeChance"))==0){
					if(defenderPlayer!=null){
						if(!MainPlugin.playerPerks.get(defenderPlayer).contains(MainPlugin.config.getString("Perks.ImmuneWeakness.name"))){
							defenderPlayer.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 20*5, 0), true);
						}
					}else{
						defenderEntity.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 20*5, 0), true);
					}
				}
			}
		if(attackerPlayer!=null)
			if(MainPlugin.playerPerks.get(attackerPlayer).contains(MainPlugin.config.getString("Perks.StrikeArmorpen.name"))){
				if(DiceRoller.Roll(MainPlugin.config.getInt("StrikeChance"))==0){
					if(defenderPlayer!=null){
						if(!MainPlugin.playerPerks.get(defenderPlayer).contains(MainPlugin.config.getString("Perks.ImmuneArmorpen.name"))){
							defenderPlayer.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20*5, -1), true);
						}
					}else{
						defenderEntity.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20*5, -1), true);
					}
				}
			}
		if(attackerPlayer!=null)
			if(MainPlugin.playerPerks.get(attackerPlayer).contains(MainPlugin.config.getString("Perks.StrikeHarm.name"))){
				if(DiceRoller.Roll(MainPlugin.config.getInt("StrikeChance"))==0){
					if(defenderPlayer!=null){
						if(!MainPlugin.playerPerks.get(defenderPlayer).contains(MainPlugin.config.getString("Perks.ImmuneHarm.name"))){
							defenderPlayer.setHealth(defenderEntity.getHealth()-2);
						}
					}else{
						defenderEntity.setHealth(defenderEntity.getHealth()-2);
					}
				}
			}
		if(attackerPlayer!=null)
			if(MainPlugin.playerPerks.get(attackerPlayer).contains(MainPlugin.config.getString("Perks.StrikeHeal.name"))){
				if(DiceRoller.Roll(MainPlugin.config.getInt("StrikeChance"))==0){
					attackerPlayer.setHealth(attackerPlayer.getHealth()+2);
				}
			}
		if(attackerPlayer!=null)
			if(MainPlugin.playerPerks.get(attackerPlayer).contains(MainPlugin.config.getString("Perks.StrikeSlow.name"))){
				if(DiceRoller.Roll(MainPlugin.config.getInt("StrikeChance"))==0){
					if(defenderPlayer!=null){
						if(!MainPlugin.playerPerks.get(defenderPlayer).contains(MainPlugin.config.getString("Perks.ImmuneSlow.name"))){
							defenderPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20*5, 0), true);
						}
					}else{
						defenderEntity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20*5, 0), true);
					}
				}
			}
		if(attackerPlayer!=null)
			if(MainPlugin.playerPerks.get(attackerPlayer).contains(MainPlugin.config.getString("Perks.StrikePoison.name"))){
				if(DiceRoller.Roll(MainPlugin.config.getInt("StrikeChance"))==0){
					if(defenderPlayer!=null){
						if(!MainPlugin.playerPerks.get(defenderPlayer).contains(MainPlugin.config.getString("Perks.ImmunePoison.name"))){
							defenderPlayer.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 20*5, 0), true);
						}
					}else{
						defenderEntity.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 20*5, 0), true);
					}
				}
			}
		if(attackerPlayer!=null&&defenderPlayer!=null)
			if(MainPlugin.playerPerks.get(attackerPlayer).contains(MainPlugin.config.getString("Perks.StrikeStarve.name"))){
				if(DiceRoller.Roll(MainPlugin.config.getInt("StrikeChance"))==0){
					if(defenderPlayer!=null){
						if(!MainPlugin.playerPerks.get(defenderPlayer).contains(MainPlugin.config.getString("Perks.ImmuneStarve.name"))){
							defenderPlayer.setFoodLevel(defenderPlayer.getFoodLevel()-2);
						}
					}
				}
			}
		if(attackerPlayer!=null)
			if(MainPlugin.playerPerks.get(attackerPlayer).contains(MainPlugin.config.getString("Perks.StrikeWither.name"))){
				if(DiceRoller.Roll(MainPlugin.config.getInt("StrikeChance"))==0){
					if(defenderPlayer!=null){
						if(!MainPlugin.playerPerks.get(defenderPlayer).contains(MainPlugin.config.getString("Perks.ImmuneWither.name"))){
							defenderPlayer.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 20*5, 0), true);
						}
					}else{
						defenderEntity.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 20*5, 0), true);
					}
				}
			}
		if(attackerPlayer!=null)
			if(MainPlugin.playerPerks.get(attackerPlayer).contains(MainPlugin.config.getString("Perks.StrikeBlindness.name"))){
				if(DiceRoller.Roll(MainPlugin.config.getInt("StrikeChance"))==0){
					if(defenderPlayer!=null){
						if(!MainPlugin.playerPerks.get(defenderPlayer).contains(MainPlugin.config.getString("Perks.ImmuneBlindness.name"))){
							defenderPlayer.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20*5, 0), true);
						}
					}else{
						defenderEntity.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20*5, 0), true);
					}
				}
			}
		if(attackerPlayer!=null)
			if(MainPlugin.playerPerks.get(attackerPlayer).contains(MainPlugin.config.getString("Perks.StrikeStun.name"))){
				if(DiceRoller.Roll(MainPlugin.config.getInt("StrikeChance"))==0){
					if(defenderPlayer!=null){
						if(!MainPlugin.playerPerks.get(defenderPlayer).contains(MainPlugin.config.getString("Perks.ImmuneSlow.name"))){
							defenderPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20*1, 9), true);
						}
					}else{
						defenderEntity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20*1, 9), true);
					}
				}
			}
		
		//End Strike
		
		
		
		//Revenge
		if(defenderPlayer!=null)
			if(MainPlugin.playerPerks.get(defenderPlayer).contains(MainPlugin.config.getString("Perks.RevengeFeed.name"))){
				if(DiceRoller.Roll(MainPlugin.config.getInt("RevengeChance"))==0){
					defenderPlayer.setFoodLevel(defenderPlayer.getFoodLevel()+2);
				}
			}
		if(defenderPlayer!=null)
			if(MainPlugin.playerPerks.get(defenderPlayer).contains(MainPlugin.config.getString("Perks.RevengeFire.name"))){
				if(DiceRoller.Roll(MainPlugin.config.getInt("RevengeChance"))==0){
					if(attackerPlayer!=null){
						if(!MainPlugin.playerPerks.get(attackerPlayer).contains(MainPlugin.config.getString("Perks.ImmuneFire.name"))){
							attackerPlayer.setFireTicks(20*3);
						}
					}else{
						attackerEntity.setFireTicks(20*3);
					
					}
				}
			}
		if(defenderPlayer!=null)
			if(MainPlugin.playerPerks.get(defenderPlayer).contains(MainPlugin.config.getString("Perks.RevengeHunger.name"))){
				if(DiceRoller.Roll(MainPlugin.config.getInt("RevengeChance"))==0){
					if(attackerPlayer!=null){
						if(!MainPlugin.playerPerks.get(attackerPlayer).contains(MainPlugin.config.getString("Perks.ImmuneHunger.name"))){
							attackerPlayer.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 20*5, 0), true);
						}
					}else{
						attackerEntity.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 20*5, 0), true);
					}
				}
			}
		if(defenderPlayer!=null)
			if(MainPlugin.playerPerks.get(defenderPlayer).contains(MainPlugin.config.getString("Perks.RevengeNausea.name"))){
				if(DiceRoller.Roll(MainPlugin.config.getInt("RevengeChance"))==0){
					if(attackerPlayer!=null){
						if(!MainPlugin.playerPerks.get(attackerPlayer).contains(MainPlugin.config.getString("Perks.ImmuneNausea.name"))){
							attackerPlayer.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 20*5, 0), true);
						}
					}else{
						attackerEntity.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 20*5, 0), true);
					}
				}
			}
		if(defenderPlayer!=null)
			if(MainPlugin.playerPerks.get(defenderPlayer).contains(MainPlugin.config.getString("Perks.RevengeWeakness.name"))){
				if(DiceRoller.Roll(MainPlugin.config.getInt("RevengeChance"))==0){
					
					if(attackerPlayer!=null){
						if(!MainPlugin.playerPerks.get(attackerPlayer).contains(MainPlugin.config.getString("Perks.ImmuneWeakness.name"))){
							attackerPlayer.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 20*5, 0), true);
						}
					}else{
						attackerEntity.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 20*5, 0), true);
					}
					
				}
			}
		if(defenderPlayer!=null)
			if(MainPlugin.playerPerks.get(defenderPlayer).contains(MainPlugin.config.getString("Perks.RevengeArmorpen.name"))){
				if(DiceRoller.Roll(MainPlugin.config.getInt("RevengeChance"))==0){
					if(attackerPlayer!=null){
						if(!MainPlugin.playerPerks.get(attackerPlayer).contains(MainPlugin.config.getString("Perks.ImmuneArmorpen.name"))){
							attackerPlayer.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20*5, -1), true);
						}
					}else{
						attackerEntity.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20*5, -1), true);
					}
				}
			}
		if(defenderPlayer!=null)
			if(MainPlugin.playerPerks.get(defenderPlayer).contains(MainPlugin.config.getString("Perks.RevengeHarm.name"))){
				if(DiceRoller.Roll(MainPlugin.config.getInt("RevengeChance"))==0){
					if(attackerPlayer!=null){
						if(!MainPlugin.playerPerks.get(attackerPlayer).contains(MainPlugin.config.getString("Perks.ImmuneHarm.name"))){
							attackerPlayer.setHealth(defenderEntity.getHealth()-2);
						}
					}else{
						attackerEntity.setHealth(defenderEntity.getHealth()-2);
					}
				}
			}
		if(defenderPlayer!=null)
			if(MainPlugin.playerPerks.get(defenderPlayer).contains(MainPlugin.config.getString("Perks.RevengeHeal.name"))){
				if(DiceRoller.Roll(MainPlugin.config.getInt("RevengeChance"))==0){
					defenderPlayer.setHealth(defenderPlayer.getHealth()+2);
				}
			}
		if(defenderPlayer!=null)
			if(MainPlugin.playerPerks.get(defenderPlayer).contains(MainPlugin.config.getString("Perks.RevengeSlow.name"))){
				if(DiceRoller.Roll(MainPlugin.config.getInt("RevengeChance"))==0){
					if(attackerPlayer!=null){
						if(!MainPlugin.playerPerks.get(attackerPlayer).contains(MainPlugin.config.getString("Perks.ImmuneSlow.name"))){
							attackerPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20*5, 0), true);
						}
					}else{
						attackerEntity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20*5, 0), true);
					}
				}
			}
		if(defenderPlayer!=null)
			if(MainPlugin.playerPerks.get(defenderPlayer).contains(MainPlugin.config.getString("Perks.RevengePoison.name"))){
				if(DiceRoller.Roll(MainPlugin.config.getInt("RevengeChance"))==0){
					if(attackerPlayer!=null){
						if(!MainPlugin.playerPerks.get(attackerPlayer).contains(MainPlugin.config.getString("Perks.ImmunePoison.name"))){
							attackerPlayer.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 20*5, 0), true);
						}
					}else{
						attackerEntity.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 20*5, 0), true);
					}
				}
			}
		if(defenderPlayer!=null&&attackerPlayer!=null)
			if(MainPlugin.playerPerks.get(defenderPlayer).contains(MainPlugin.config.getString("Perks.RevengeStarve.name"))){
				if(DiceRoller.Roll(MainPlugin.config.getInt("RevengeChance"))==0){
					if(attackerPlayer!=null){
						if(!MainPlugin.playerPerks.get(attackerPlayer).contains(MainPlugin.config.getString("Perks.ImmuneStarve.name"))){
							attackerPlayer.setFoodLevel(attackerPlayer.getFoodLevel()-2);
						}
					}
				}
			}
		if(defenderPlayer!=null)
			if(MainPlugin.playerPerks.get(defenderPlayer).contains(MainPlugin.config.getString("Perks.RevengeWither.name"))){
				if(DiceRoller.Roll(MainPlugin.config.getInt("RevengeChance"))==0){
					if(attackerPlayer!=null){
						if(!MainPlugin.playerPerks.get(attackerPlayer).contains(MainPlugin.config.getString("Perks.ImmuneWither.name"))){
							attackerPlayer.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 20*5, 0), true);
						}
					}else{
						attackerEntity.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 20*5, 0), true);
					}
				}
			}
		if(defenderPlayer!=null)
			if(MainPlugin.playerPerks.get(defenderPlayer).contains(MainPlugin.config.getString("Perks.RevengeBlindness.name"))){
				if(DiceRoller.Roll(MainPlugin.config.getInt("RevengeChance"))==0){
					if(attackerPlayer!=null){
						if(!MainPlugin.playerPerks.get(attackerPlayer).contains(MainPlugin.config.getString("Perks.ImmuneBlindness.name"))){
							attackerPlayer.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20*5, 0), true);
						}
					}else{
						attackerEntity.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20*5, 0), true);
					}
				}
			}
		if(defenderPlayer!=null)
			if(MainPlugin.playerPerks.get(defenderPlayer).contains(MainPlugin.config.getString("Perks.RevengeStun.name"))){
				if(DiceRoller.Roll(MainPlugin.config.getInt("RevengeChance"))==0){
					if(attackerPlayer!=null){
						if(!MainPlugin.playerPerks.get(attackerPlayer).contains(MainPlugin.config.getString("Perks.ImmuneSlow.name"))){
							attackerPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20*1, 9), true);
						}
					}else{
						attackerEntity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20*1, 9), true);
					}
				}
			}
		
		//End Revenge
		
		
		//Misc Perks
		if(defenderPlayer!=null&&attackerPlayer!=null){
			//holy man attacks a unholy
			if(MainPlugin.playerPerks.get(attackerPlayer).contains(MainPlugin.config.getString("Perks.Holy.name"))){
				if(MainPlugin.playerPerks.get(defenderPlayer).contains(MainPlugin.config.getString("Perks.Unholy.name"))){
					e.setDamage(e.getDamage()+e.getDamage()/4);
				}
			}
			
			//unholy man attacks a holy
			if(MainPlugin.playerPerks.get(defenderPlayer).contains(MainPlugin.config.getString("Perks.Unholy.name"))){
				if(MainPlugin.playerPerks.get(attackerPlayer).contains(MainPlugin.config.getString("Perks.Holy.name"))){
					e.setDamage(e.getDamage()-e.getDamage()/4);
				}
			}
			
			
		}
		
		
		if(attackerPlayer!=null){
			if(MainPlugin.playerPerks.get(attackerPlayer).contains(MainPlugin.config.getString("Perks.Informed.name"))){
				if(defenderPlayer!= null){
					attackerPlayer.sendMessage(ChatColor.GREEN+"[Perks]: you did "+e.getDamage()+" to "+defenderPlayer.getName());
					attackerPlayer.sendMessage(ChatColor.GREEN+"[Perks]: "+defenderPlayer.getName()+" has "+(int)(defenderPlayer.getHealth()-e.getDamage())+ " health left");
				}else if(defenderEntity!=null){
					
					attackerPlayer.sendMessage(ChatColor.GREEN+"[Perks]: you did "+e.getDamage()+" to "+defenderEntity.getName());
					attackerPlayer.sendMessage(ChatColor.GREEN+"[Perks]: "+defenderEntity.getName()+" has "+(int)(defenderEntity.getHealth()-e.getDamage())+ " health left");
				}
				
			}
		}
		
	}
}
