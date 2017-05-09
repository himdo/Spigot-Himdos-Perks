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
				if(MainPlugin.playerPerks.get(attackerPlayer).contains("Snow Baller")){
					e.setDamage(2);
				}
			}
		}
		//Weapon Perks
		if(arrow!=null){
			if(attackerPlayer!=null){
				if(MainPlugin.playerPerks.get(attackerPlayer).contains("Expert Archery")){
					if(attackerPlayer.getInventory().getItemInMainHand().getType().equals(Material.BOW)){
						e.setDamage(e.getDamage()+e.getDamage()/4);
					}
				}
				if(MainPlugin.playerPerks.get(attackerPlayer).contains("Inept Archery")){
					if(attackerPlayer.getInventory().getItemInMainHand().getType().equals(Material.BOW)){
						e.setDamage(e.getDamage()-e.getDamage()/4);
					}
				}
			}
		
			if(defenderPlayer!=null){
				
				if(MainPlugin.playerPerks.get(defenderPlayer).contains("Resistant Archery")){
					if(attackerEntity.getEquipment().getItemInMainHand().getType().equals(Material.BOW)){
						e.setDamage(e.getDamage()-e.getDamage()/4);
					}
				}
				
				if(MainPlugin.playerPerks.get(defenderPlayer).contains("Vulnerable Archery")){
					if(attackerEntity.getEquipment().getItemInMainHand().getType().equals(Material.BOW)){
						e.setDamage(e.getDamage()+e.getDamage()/4);
					}
				}	
			}
			
		}
		if(arrow==null){
			if(attackerPlayer!=null){
				if(MainPlugin.playerPerks.get(attackerPlayer).contains("Expert Axe")){
					if(WeaponArrayLists.Axes.contains(attackerPlayer.getInventory().getItemInMainHand().getType())){
						e.setDamage(e.getDamage()+e.getDamage()/4);
					}
				}
				if(MainPlugin.playerPerks.get(attackerPlayer).contains("Expert Unarmed")){
					if(attackerPlayer.getInventory().getItemInMainHand().getType().equals(Material.AIR)){
						e.setDamage(e.getDamage()+e.getDamage()/4);
					}
				}
				if(MainPlugin.playerPerks.get(attackerPlayer).contains("Expert Sword")){
					if(WeaponArrayLists.Swords.contains(attackerPlayer.getInventory().getItemInMainHand().getType())){
						e.setDamage(e.getDamage()+e.getDamage()/4);
					}
				}
				
				if(MainPlugin.playerPerks.get(attackerPlayer).contains("Inept Axe")){
					if(WeaponArrayLists.Axes.contains(attackerPlayer.getInventory().getItemInMainHand().getType())){
						e.setDamage(e.getDamage()-e.getDamage()/4);
					}
				}
				if(MainPlugin.playerPerks.get(attackerPlayer).contains("Inept Unarmed")){
					if(attackerPlayer.getInventory().getItemInMainHand().getType().equals(Material.AIR)){
						e.setDamage(e.getDamage()-e.getDamage()/4);
					}
				}
				if(MainPlugin.playerPerks.get(attackerPlayer).contains("Inept Sword")){
					if(WeaponArrayLists.Swords.contains(attackerPlayer.getInventory().getItemInMainHand().getType())){
						e.setDamage(e.getDamage()-e.getDamage()/4);
					}
				}
			}
			
			if(defenderPlayer!=null){
				if(MainPlugin.playerPerks.get(defenderPlayer).contains("Resistant Axe")){
					if(WeaponArrayLists.Axes.contains(attackerEntity.getEquipment().getItemInMainHand().getType())){
						e.setDamage(e.getDamage()-e.getDamage()/4);
					}
				}
				if(MainPlugin.playerPerks.get(defenderPlayer).contains("Resistant Unarmed")){
					if(attackerEntity.getEquipment().getItemInMainHand().getType().equals(Material.AIR)){
						e.setDamage(e.getDamage()-e.getDamage()/4);
					}
				}
				if(MainPlugin.playerPerks.get(defenderPlayer).contains("Resistant Sword")){
					if(WeaponArrayLists.Swords.contains(attackerEntity.getEquipment().getItemInMainHand().getType())){
						e.setDamage(e.getDamage()-e.getDamage()/4);
					}
				}
				
				if(MainPlugin.playerPerks.get(defenderPlayer).contains("Vulnerable Axe")){
					if(WeaponArrayLists.Axes.contains(attackerEntity.getEquipment().getItemInMainHand().getType())){
						e.setDamage(e.getDamage()+e.getDamage()/4);
					}
				}
				if(MainPlugin.playerPerks.get(defenderPlayer).contains("Vulnerable Unarmed")){
					if(attackerEntity.getEquipment().getItemInMainHand().getType().equals(Material.AIR)){
						e.setDamage(e.getDamage()+e.getDamage()/4);
					}
				}
				if(MainPlugin.playerPerks.get(defenderPlayer).contains("Vulnerable Sword")){
					if(WeaponArrayLists.Swords.contains(attackerEntity.getEquipment().getItemInMainHand().getType())){
						e.setDamage(e.getDamage()+e.getDamage()/4);
					}
				}
			}
		}
		//End Weapon Perks
		
		
		
		//Strike
		if(attackerPlayer!=null)
			if(MainPlugin.playerPerks.get(attackerPlayer).contains("Strike Feed")){
				if(DiceRoller.Roll(MainPlugin.config.getInt("StrikeChance"))==0){
					attackerPlayer.setFoodLevel(attackerPlayer.getFoodLevel()+2);
				}
			}
		
		if(attackerPlayer!=null)
			if(MainPlugin.playerPerks.get(attackerPlayer).contains("Strike Fire")){
				if(DiceRoller.Roll(MainPlugin.config.getInt("StrikeChance"))==0){
					if(defenderPlayer!=null){
						if(!MainPlugin.playerPerks.get(defenderPlayer).contains("Immune Fire")){
							defenderEntity.setFireTicks(20*3);
						}
					}else{
						defenderEntity.setFireTicks(20*3);
					}
					
				}	
			}

		if(attackerPlayer!=null)
			if(MainPlugin.playerPerks.get(attackerPlayer).contains("Strike Hunger")){
				if(DiceRoller.Roll(MainPlugin.config.getInt("StrikeChance"))==0){
					if(defenderPlayer!=null){
						if(!MainPlugin.playerPerks.get(defenderPlayer).contains("Immune Hunger")){
							defenderPlayer.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 20*5, 0), true);
						}
					}else{
						defenderEntity.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 20*5, 0), true);
					}
				}
			}
		if(attackerPlayer!=null)
			if(MainPlugin.playerPerks.get(attackerPlayer).contains("Strike Nausea")){
				if(DiceRoller.Roll(MainPlugin.config.getInt("StrikeChance"))==0){
					if(defenderPlayer!=null){
						if(!MainPlugin.playerPerks.get(defenderPlayer).contains("Immune Nausea")){
							defenderPlayer.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 20*5, 0), true);
						}
					}else{
						defenderEntity.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 20*5, 0), true);
					}
				}
			}
		if(attackerPlayer!=null)
			if(MainPlugin.playerPerks.get(attackerPlayer).contains("Strike Weakness")){
				if(DiceRoller.Roll(MainPlugin.config.getInt("StrikeChance"))==0){
					if(defenderPlayer!=null){
						if(!MainPlugin.playerPerks.get(defenderPlayer).contains("Immune Weakness")){
							defenderPlayer.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 20*5, 0), true);
						}
					}else{
						defenderEntity.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 20*5, 0), true);
					}
				}
			}
		if(attackerPlayer!=null)
			if(MainPlugin.playerPerks.get(attackerPlayer).contains("Strike Armorpen")){
				if(DiceRoller.Roll(MainPlugin.config.getInt("StrikeChance"))==0){
					if(defenderPlayer!=null){
						if(!MainPlugin.playerPerks.get(defenderPlayer).contains("Immune Armorphen")){
							defenderPlayer.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20*5, -1), true);
						}
					}else{
						defenderEntity.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20*5, -1), true);
					}
				}
			}
		if(attackerPlayer!=null)
			if(MainPlugin.playerPerks.get(attackerPlayer).contains("Strike Harm")){
				if(DiceRoller.Roll(MainPlugin.config.getInt("StrikeChance"))==0){
					if(defenderPlayer!=null){
						if(!MainPlugin.playerPerks.get(defenderPlayer).contains("Immune Harm")){
							defenderPlayer.setHealth(defenderEntity.getHealth()-2);
						}
					}else{
						defenderEntity.setHealth(defenderEntity.getHealth()-2);
					}
				}
			}
		if(attackerPlayer!=null)
			if(MainPlugin.playerPerks.get(attackerPlayer).contains("Strike Heal")){
				if(DiceRoller.Roll(MainPlugin.config.getInt("StrikeChance"))==0){
					attackerPlayer.setHealth(attackerPlayer.getHealth()+2);
				}
			}
		if(attackerPlayer!=null)
			if(MainPlugin.playerPerks.get(attackerPlayer).contains("Strike Slow")){
				if(DiceRoller.Roll(MainPlugin.config.getInt("StrikeChance"))==0){
					if(defenderPlayer!=null){
						if(!MainPlugin.playerPerks.get(defenderPlayer).contains("Immune Slow")){
							defenderPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20*5, 0), true);
						}
					}else{
						defenderEntity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20*5, 0), true);
					}
				}
			}
		if(attackerPlayer!=null)
			if(MainPlugin.playerPerks.get(attackerPlayer).contains("Strike Poison")){
				if(DiceRoller.Roll(MainPlugin.config.getInt("StrikeChance"))==0){
					if(defenderPlayer!=null){
						if(!MainPlugin.playerPerks.get(defenderPlayer).contains("Immune Poison")){
							defenderPlayer.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 20*5, 0), true);
						}
					}else{
						defenderEntity.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 20*5, 0), true);
					}
				}
			}
		if(attackerPlayer!=null&&defenderPlayer!=null)
			if(MainPlugin.playerPerks.get(attackerPlayer).contains("Strike Starve")){
				if(DiceRoller.Roll(MainPlugin.config.getInt("StrikeChance"))==0){
					if(defenderPlayer!=null){
						if(!MainPlugin.playerPerks.get(defenderPlayer).contains("Immune Starve")){
							defenderPlayer.setFoodLevel(defenderPlayer.getFoodLevel()-2);
						}
					}
				}
			}
		if(attackerPlayer!=null)
			if(MainPlugin.playerPerks.get(attackerPlayer).contains("Strike Wither")){
				if(DiceRoller.Roll(MainPlugin.config.getInt("StrikeChance"))==0){
					if(defenderPlayer!=null){
						if(!MainPlugin.playerPerks.get(defenderPlayer).contains("Immune Wither")){
							defenderPlayer.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 20*5, 0), true);
						}
					}else{
						defenderEntity.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 20*5, 0), true);
					}
				}
			}
		if(attackerPlayer!=null)
			if(MainPlugin.playerPerks.get(attackerPlayer).contains("Strike Blindness")){
				if(DiceRoller.Roll(MainPlugin.config.getInt("StrikeChance"))==0){
					if(defenderPlayer!=null){
						if(!MainPlugin.playerPerks.get(defenderPlayer).contains("Immune Blindness")){
							defenderPlayer.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20*5, 0), true);
						}
					}else{
						defenderEntity.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20*5, 0), true);
					}
				}
			}
		if(attackerPlayer!=null)
			if(MainPlugin.playerPerks.get(attackerPlayer).contains("Strike Stun")){
				if(DiceRoller.Roll(MainPlugin.config.getInt("StrikeChance"))==0){
					if(defenderPlayer!=null){
						if(!MainPlugin.playerPerks.get(defenderPlayer).contains("Immune Slow")){
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
			if(MainPlugin.playerPerks.get(defenderPlayer).contains("Revenge Feed")){
				if(DiceRoller.Roll(MainPlugin.config.getInt("RevengeChance"))==0){
					defenderPlayer.setFoodLevel(defenderPlayer.getFoodLevel()+2);
				}
			}
		if(defenderPlayer!=null)
			if(MainPlugin.playerPerks.get(defenderPlayer).contains("Revenge Fire")){
				if(DiceRoller.Roll(MainPlugin.config.getInt("RevengeChance"))==0){
					if(attackerPlayer!=null){
						if(!MainPlugin.playerPerks.get(attackerPlayer).contains("Immune Fire")){
							attackerPlayer.setFireTicks(20*3);
						}
					}else{
						attackerEntity.setFireTicks(20*3);
					
					}
				}
			}
		if(defenderPlayer!=null)
			if(MainPlugin.playerPerks.get(defenderPlayer).contains("Revenge Hunger")){
				if(DiceRoller.Roll(MainPlugin.config.getInt("RevengeChance"))==0){
					if(attackerPlayer!=null){
						if(!MainPlugin.playerPerks.get(attackerPlayer).contains("Immune Hunger")){
							attackerPlayer.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 20*5, 0), true);
						}
					}else{
						attackerEntity.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 20*5, 0), true);
					}
				}
			}
		if(defenderPlayer!=null)
			if(MainPlugin.playerPerks.get(defenderPlayer).contains("Revenge Nausea")){
				if(DiceRoller.Roll(MainPlugin.config.getInt("RevengeChance"))==0){
					if(attackerPlayer!=null){
						if(!MainPlugin.playerPerks.get(attackerPlayer).contains("Immune Nausea")){
							attackerPlayer.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 20*5, 0), true);
						}
					}else{
						attackerEntity.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 20*5, 0), true);
					}
				}
			}
		if(defenderPlayer!=null)
			if(MainPlugin.playerPerks.get(defenderPlayer).contains("Revenge Weakness")){
				if(DiceRoller.Roll(MainPlugin.config.getInt("RevengeChance"))==0){
					
					if(attackerPlayer!=null){
						if(!MainPlugin.playerPerks.get(attackerPlayer).contains("Immune Weakness")){
							attackerPlayer.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 20*5, 0), true);
						}
					}else{
						attackerEntity.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 20*5, 0), true);
					}
					
				}
			}
		if(defenderPlayer!=null)
			if(MainPlugin.playerPerks.get(defenderPlayer).contains("Revenge Armorpen")){
				if(DiceRoller.Roll(MainPlugin.config.getInt("RevengeChance"))==0){
					if(attackerPlayer!=null){
						if(!MainPlugin.playerPerks.get(attackerPlayer).contains("Immune Armorphen")){
							attackerPlayer.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20*5, -1), true);
						}
					}else{
						attackerEntity.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20*5, -1), true);
					}
				}
			}
		if(defenderPlayer!=null)
			if(MainPlugin.playerPerks.get(defenderPlayer).contains("Revenge Harm")){
				if(DiceRoller.Roll(MainPlugin.config.getInt("RevengeChance"))==0){
					if(attackerPlayer!=null){
						if(!MainPlugin.playerPerks.get(attackerPlayer).contains("Immune Harm")){
							attackerPlayer.setHealth(defenderEntity.getHealth()-2);
						}
					}else{
						attackerEntity.setHealth(defenderEntity.getHealth()-2);
					}
				}
			}
		if(defenderPlayer!=null)
			if(MainPlugin.playerPerks.get(defenderPlayer).contains("Revenge Heal")){
				if(DiceRoller.Roll(MainPlugin.config.getInt("RevengeChance"))==0){
					defenderPlayer.setHealth(defenderPlayer.getHealth()+2);
				}
			}
		if(defenderPlayer!=null)
			if(MainPlugin.playerPerks.get(defenderPlayer).contains("Revenge Slow")){
				if(DiceRoller.Roll(MainPlugin.config.getInt("RevengeChance"))==0){
					if(attackerPlayer!=null){
						if(!MainPlugin.playerPerks.get(attackerPlayer).contains("Immune Slow")){
							attackerPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20*5, 0), true);
						}
					}else{
						attackerEntity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20*5, 0), true);
					}
				}
			}
		if(defenderPlayer!=null)
			if(MainPlugin.playerPerks.get(defenderPlayer).contains("Revenge Poison")){
				if(DiceRoller.Roll(MainPlugin.config.getInt("RevengeChance"))==0){
					if(attackerPlayer!=null){
						if(!MainPlugin.playerPerks.get(attackerPlayer).contains("Immune Poison")){
							attackerPlayer.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 20*5, 0), true);
						}
					}else{
						attackerEntity.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 20*5, 0), true);
					}
				}
			}
		if(defenderPlayer!=null&&attackerPlayer!=null)
			if(MainPlugin.playerPerks.get(defenderPlayer).contains("Revenge Starve")){
				if(DiceRoller.Roll(MainPlugin.config.getInt("RevengeChance"))==0){
					if(attackerPlayer!=null){
						if(!MainPlugin.playerPerks.get(attackerPlayer).contains("Immune Starve")){
							attackerPlayer.setFoodLevel(attackerPlayer.getFoodLevel()-2);
						}
					}
				}
			}
		if(defenderPlayer!=null)
			if(MainPlugin.playerPerks.get(defenderPlayer).contains("Revenge Wither")){
				if(DiceRoller.Roll(MainPlugin.config.getInt("RevengeChance"))==0){
					if(attackerPlayer!=null){
						if(!MainPlugin.playerPerks.get(attackerPlayer).contains("Immune Wither")){
							attackerPlayer.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 20*5, 0), true);
						}
					}else{
						attackerEntity.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 20*5, 0), true);
					}
				}
			}
		if(defenderPlayer!=null)
			if(MainPlugin.playerPerks.get(defenderPlayer).contains("Revenge Blindness")){
				if(DiceRoller.Roll(MainPlugin.config.getInt("RevengeChance"))==0){
					if(attackerPlayer!=null){
						if(!MainPlugin.playerPerks.get(attackerPlayer).contains("Immune Blindness")){
							attackerPlayer.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20*5, 0), true);
						}
					}else{
						attackerEntity.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20*5, 0), true);
					}
				}
			}
		if(defenderPlayer!=null)
			if(MainPlugin.playerPerks.get(defenderPlayer).contains("Revenge Stun")){
				if(DiceRoller.Roll(MainPlugin.config.getInt("RevengeChance"))==0){
					if(attackerPlayer!=null){
						if(!MainPlugin.playerPerks.get(attackerPlayer).contains("Immune Slow")){
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
			if(MainPlugin.playerPerks.get(attackerPlayer).contains("Holy")){
				if(MainPlugin.playerPerks.get(defenderPlayer).contains("Unholy")){
					e.setDamage(e.getDamage()+e.getDamage()/4);
				}
			}
			
			//unholy man attacks a holy
			if(MainPlugin.playerPerks.get(defenderPlayer).contains("Unholy")){
				if(MainPlugin.playerPerks.get(attackerPlayer).contains("Holy")){
					e.setDamage(e.getDamage()-e.getDamage()/4);
				}
			}
			
			
		}
		
		
		if(attackerPlayer!=null){
			if(MainPlugin.playerPerks.get(attackerPlayer).contains("Informed")){
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
