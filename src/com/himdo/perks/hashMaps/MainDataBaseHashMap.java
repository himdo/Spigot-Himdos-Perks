package com.himdo.perks.hashMaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffectType;

public class MainDataBaseHashMap {
	public static HashMap<String, ItemStack> items;
	public static HashMap<ItemStack, Integer> perkCosts;
	
	//Buffs
	static ItemStack NightVision = new ItemStack(Material.GOLDEN_CARROT);
	static ItemStack WaterBreathing = new ItemStack(Material.WATER_BUCKET);
	static ItemStack Haste = new ItemStack(Material.GOLD_PICKAXE);
	static ItemStack Jump = new ItemStack(Material.PISTON_BASE);
	static ItemStack Speed = new ItemStack(Material.REDSTONE);
	static ItemStack HealthBoost = new ItemStack(Material.IRON_BLOCK);
	
	//Buffs 2x
	static ItemStack Haste2 = new ItemStack(Material.DIAMOND_PICKAXE);
	static ItemStack Jump2 = new ItemStack(Material.PISTON_STICKY_BASE);
	//static ItemStack Speed2 = new ItemStack(Material.SKULL_ITEM,1,(byte)3);
	//static ItemStack HealthBoost2 = new ItemStack(Material.SKULL_ITEM,1,(byte)3);
	static ItemStack Speed2 = new ItemStack(Material.SUGAR);
	static ItemStack HealthBoost2 = new ItemStack(Material.APPLE);
	
	
	//de Buffs
	static ItemStack MiningFatigue = new ItemStack(Material.WOOD_PICKAXE);
	static ItemStack Slow = new ItemStack(Material.SOUL_SAND);
	static ItemStack Blind = new ItemStack(Material.COAL_BLOCK);
	
	//Holy and un Holy
	static ItemStack Holy = new ItemStack(Material.GLOWSTONE);
	static ItemStack Unholy = new ItemStack(Material.OBSIDIAN);
	
	//Strike and Revenge
	//Strike
	static ItemStack StrikeFeed = new ItemStack(Material.COOKED_BEEF);
	static ItemStack StrikeFire = new ItemStack(Material.FLINT_AND_STEEL);
	static ItemStack StrikeHunger = new ItemStack(Material.ROTTEN_FLESH);
	static ItemStack StrikeNausea = new ItemStack(Material.MILK_BUCKET);
	static ItemStack StrikeSteal = new ItemStack(Material.GOLD_NUGGET);
	static ItemStack StrikeArmorpen = new ItemStack(Material.LEATHER_CHESTPLATE);
	static ItemStack StrikeHarm = new ItemStack(Material.IRON_SWORD);
	static ItemStack StrikeHeal = new ItemStack(Material.WHEAT);
	static ItemStack StrikeSlow = new ItemStack(Material.SOUL_SAND);
	static ItemStack StrikePoison = new ItemStack(Material.SPIDER_EYE);
	static ItemStack StrikeStarve = new ItemStack(Material.COAL);
	//static ItemStack StrikeWither = new ItemStack(Material.SKULL_ITEM,1,(byte)1);
	static ItemStack StrikeWither = new ItemStack(Material.STONE_SWORD);
	static ItemStack StrikeBlindness = new ItemStack(Material.COAL_BLOCK);
	static ItemStack StrikeStun = new ItemStack(Material.WOOD_SWORD);
	static ItemStack StrikeWeakness = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
	
	//Revenge
	static ItemStack RevengeFeed = new ItemStack(Material.COOKED_BEEF);
	static ItemStack RevengeFire = new ItemStack(Material.FLINT_AND_STEEL);
	static ItemStack RevengeHunger = new ItemStack(Material.ROTTEN_FLESH);
	static ItemStack RevengeNausea = new ItemStack(Material.MILK_BUCKET);
	static ItemStack RevengeSteal = new ItemStack(Material.GOLD_NUGGET);
	static ItemStack RevengeArmorpen = new ItemStack(Material.LEATHER_CHESTPLATE);
	static ItemStack RevengeHarm = new ItemStack(Material.IRON_SWORD);
	static ItemStack RevengeHeal = new ItemStack(Material.WHEAT);
	static ItemStack RevengeSlow = new ItemStack(Material.SOUL_SAND);
	static ItemStack RevengePoison = new ItemStack(Material.SPIDER_EYE);
	static ItemStack RevengeStarve = new ItemStack(Material.COAL);
	//static ItemStack RevengeWither = new ItemStack(Material.SKULL_ITEM,1,(byte)1);
	static ItemStack RevengeWither = new ItemStack(Material.STONE_SWORD);
	static ItemStack RevengeBlindness = new ItemStack(Material.COAL_BLOCK);
	static ItemStack RevengeStun = new ItemStack(Material.WOOD_SWORD);
	static ItemStack RevengeWeakness = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
	
	//Food
	static ItemStack WaterDrinker = new ItemStack(Material.WATER_BUCKET);
	static ItemStack StoneEater = new ItemStack(Material.STONE);
	static ItemStack Carnivore = new ItemStack(Material.PORK);
	static ItemStack Herbivore = new ItemStack(Material.CARROT_ITEM);
	static ItemStack Nonivore = new ItemStack(Material.BOWL);
	
	//Feed, Starve, Heal, Harm
	static ItemStack FeedLava = new ItemStack(Material.LAVA_BUCKET);
	static ItemStack FeedSunlight = new ItemStack(Material.DAYLIGHT_DETECTOR);
	static ItemStack FeedVegetation = new ItemStack(Material.CARROT_ITEM);
	static ItemStack FeedWater = new ItemStack(Material.WATER_BUCKET);
	static ItemStack FeedLight = new ItemStack(Material.TORCH);
	static ItemStack FeedDarkness = new ItemStack(Material.REDSTONE_TORCH_ON);
	static ItemStack FeedMeditation = new ItemStack(Material.GOLD_BOOTS);
	static ItemStack FeedAlways = new ItemStack(Material.CAKE);

	//Starve
	static ItemStack StarveLava = new ItemStack(Material.LAVA_BUCKET);
	static ItemStack StarveSunlight = new ItemStack(Material.DAYLIGHT_DETECTOR);
	static ItemStack StarveVegetation = new ItemStack(Material.CARROT_ITEM);
	static ItemStack StarveWater = new ItemStack(Material.WATER_BUCKET);
	static ItemStack StarveLight = new ItemStack(Material.TORCH);
	static ItemStack StarveDarkness = new ItemStack(Material.REDSTONE_TORCH_ON);
	static ItemStack StarveMeditation = new ItemStack(Material.GOLD_BOOTS);
	static ItemStack StarveAlways = new ItemStack(Material.CAKE);

	//Heal
	static ItemStack HealLava = new ItemStack(Material.LAVA_BUCKET);
	static ItemStack HealSunlight = new ItemStack(Material.DAYLIGHT_DETECTOR);
	static ItemStack HealVegetation = new ItemStack(Material.CARROT_ITEM);
	static ItemStack HealWater = new ItemStack(Material.WATER_BUCKET);
	static ItemStack HealLight = new ItemStack(Material.TORCH);
	static ItemStack HealDarkness = new ItemStack(Material.REDSTONE_TORCH_ON);
	static ItemStack HealMeditation = new ItemStack(Material.GOLD_BOOTS);
	static ItemStack HealAlways = new ItemStack(Material.CAKE);

	//Harm
	static ItemStack HarmLava = new ItemStack(Material.LAVA_BUCKET);
	static ItemStack HarmSunlight = new ItemStack(Material.DAYLIGHT_DETECTOR);
	static ItemStack HarmVegetation = new ItemStack(Material.CARROT_ITEM);
	static ItemStack HarmWater = new ItemStack(Material.WATER_BUCKET);
	static ItemStack HarmLight = new ItemStack(Material.TORCH);
	static ItemStack HarmDarkness = new ItemStack(Material.REDSTONE_TORCH_ON);
	static ItemStack HarmMeditation = new ItemStack(Material.GOLD_BOOTS);
	static ItemStack HarmAlways = new ItemStack(Material.CAKE);
	
	//Weapon strength and Weakness
	//Expert
	static ItemStack ExpertArchery = new ItemStack(Material.BOW);
	static ItemStack ExpertAxe = new ItemStack(Material.IRON_AXE);
	static ItemStack ExpertSword = new ItemStack(Material.IRON_SWORD);
	static ItemStack ExpertUnarmed = new ItemStack(Material.TRIPWIRE_HOOK);
	
	//Resistant
	static ItemStack ResistantArchery = new ItemStack(Material.BOW);
	static ItemStack ResistantAxe = new ItemStack(Material.IRON_AXE);
	static ItemStack ResistantSword = new ItemStack(Material.IRON_SWORD);
	static ItemStack ResistantUnarmed = new ItemStack(Material.TRIPWIRE_HOOK);
	
	//Inept -50
	static ItemStack IneptArchery = new ItemStack(Material.BOW);
	static ItemStack IneptAxe = new ItemStack(Material.IRON_AXE);
	static ItemStack IneptSword = new ItemStack(Material.IRON_SWORD);
	static ItemStack IneptUnarmed = new ItemStack(Material.TRIPWIRE_HOOK);
	
	//Vulnerable

	static ItemStack VulnerableArchery = new ItemStack(Material.BOW);
	static ItemStack VulnerableAxe = new ItemStack(Material.IRON_AXE);
	static ItemStack VulnerableSword = new ItemStack(Material.IRON_SWORD);
	static ItemStack VulnerableUnarmed = new ItemStack(Material.TRIPWIRE_HOOK);
	

	
	//Immunity
	static ItemStack ImmuneArmorpen = new ItemStack(Material.LEATHER_CHESTPLATE);
	static ItemStack ImmuneHarm = new ItemStack(Material.IRON_SWORD);
	static ItemStack ImmuneHunger = new ItemStack(Material.ROTTEN_FLESH);
	static ItemStack ImmuneNausea = new ItemStack(Material.MILK_BUCKET);
	static ItemStack ImmuneStarve = new ItemStack(Material.COAL);
	static ItemStack ImmuneFall = new ItemStack(Material.LEATHER_BOOTS);
	static ItemStack ImmuneSteal = new ItemStack(Material.GOLD_NUGGET);
	static ItemStack ImmuneWeakness = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
	//static ItemStack ImmuneWither = new ItemStack(Material.SKULL_ITEM,1,(byte)1);
	static ItemStack ImmuneWither = new ItemStack(Material.STONE_SWORD);
	static ItemStack ImmuneFire = new ItemStack(Material.FLINT_AND_STEEL);
	static ItemStack ImmunePoison = new ItemStack(Material.SPIDER_EYE);
	static ItemStack ImmuneBlindness = new ItemStack(Material.COAL_BLOCK);
	static ItemStack ImmuneSlow = new ItemStack(Material.SOUL_SAND);
	
	//Fly
	static ItemStack FlyWater = new ItemStack(Material.WATER_BUCKET);
	static ItemStack FlyLava = new ItemStack(Material.LAVA_BUCKET);
	static ItemStack FlyWeb = new ItemStack(Material.WEB);
	
	//Truce
	static ItemStack TruceSlime = new ItemStack(Material.SKULL_ITEM,1,(byte)3);
	static ItemStack TruceBlaze = new ItemStack(Material.SKULL_ITEM,1,(byte)3);
	static ItemStack TruceSilverFish = new ItemStack(Material.SKULL_ITEM,1,(byte)3);
	static ItemStack TruceSpider = new ItemStack(Material.SKULL_ITEM,1,(byte)3);
	static ItemStack TruceUndead = new ItemStack(Material.SKULL_ITEM,1,(byte)3);
	static ItemStack TruceCreeper = new ItemStack(Material.SKULL_ITEM,1,(byte)3);
	static ItemStack TruceGhast = new ItemStack(Material.SKULL_ITEM,1,(byte)3);
	static ItemStack TruceWitch = new ItemStack(Material.SKULL_ITEM,1,(byte)3);
	
	
	
	
	//Icons
	//main
	static ItemStack AddPerk = new ItemStack(Material.EMERALD);
	//static ItemStack Help = new ItemStack(Material.SKULL_ITEM,1,(byte)3);
	//static ItemStack LeftArrow = new ItemStack(Material.SKULL_ITEM,1,(byte)3);
	//static ItemStack RightArrow = new ItemStack(Material.SKULL_ITEM,1,(byte)3);
	static ItemStack Help = new ItemStack(Material.STAINED_GLASS_PANE,1, (short) 15);
	static ItemStack LeftArrow = new ItemStack(Material.STAINED_GLASS_PANE,1, (short) 13);
	static ItemStack RightArrow = new ItemStack(Material.STAINED_GLASS_PANE,1, (short) 14);
	
	//subSettings
	static ItemStack Buffs = new ItemStack(Material.POTION);
	static ItemStack Food = new ItemStack(Material.COOKED_CHICKEN);
	static ItemStack Truce = new ItemStack(Material.SLIME_BALL);
	static ItemStack Misc = new ItemStack(Material.PUMPKIN);
	static ItemStack Fly = new ItemStack(Material.FEATHER);
	static ItemStack Immune = new ItemStack(Material.EMERALD_BLOCK);
	static ItemStack WeaponStats = new ItemStack(Material.ARROW);
	static ItemStack StrikeRevenge = new ItemStack(Material.GOLD_SWORD);
	static ItemStack FeedStarveHealHarm = new ItemStack(Material.FERMENTED_SPIDER_EYE);
	
	
	//Borders
	static ItemStack BorderPurple = new ItemStack(Material.STAINED_GLASS_PANE,1, (short) 10);
	
	static private ItemMeta itemMeta;
	
	public static void setHashMap(){
		items=new HashMap<String, ItemStack>();
		perkCosts = new HashMap<ItemStack,Integer>();
		
		//borders 
		setMeta(BorderPurple, " ", null,false);
		addToMap(BorderPurple,"Border Purple");
		
		
		//Icons
		//main
		setMeta(AddPerk, "Perks", Arrays.asList("Click to open all the different perks"),0);
		//setSkull("MHF_Question", Help, "Help",  Arrays.asList("Click to get Help"),0);
		//setSkull("MHF_ArrowLeft", LeftArrow, "Back",  Arrays.asList("Click to go Back"),0);
		//setSkull("MHF_ArrowRight", RightArrow, "Next",  Arrays.asList("Click to go to Next page"),0);
		setMeta( Help, "Help",  Arrays.asList("Click to get Help"),0);
		setMeta( LeftArrow, "Back",  Arrays.asList("Click to go Back"),0);
		setMeta( RightArrow, "Next",  Arrays.asList("Click to go to Next page"),0);
		
		//secondary
		PotionMeta p = (PotionMeta) Buffs.getItemMeta();
		p.addCustomEffect(PotionEffectType.HEAL.createEffect(0, 0), true);
		Buffs.setItemMeta(p);
		
		setMeta(Buffs, "Buffs", Arrays.asList("Click to show buff/","debuff based perks"),0);
		setMeta(Food,"Food Perks", Arrays.asList("Click to show food based perks"),0);
		setMeta(Truce,"Truce Perks", Arrays.asList("Click to show mob truce based perks"),0);
		setMeta(Misc, "Misc Perks", Arrays.asList("Click to show misc perks"),0);
		setMeta(Fly, "Flying Perks", Arrays.asList("Click to show flying based perks"),0);
		setMeta(Immune, "Immune Perks", Arrays.asList("Click to show immunity based perks"),0);
		setMeta(WeaponStats, "Weapon Perks", Arrays.asList("Click to show weapon","stats based perks"),0);
		setMeta(StrikeRevenge, "Strike/Revenge Perks", Arrays.asList("Click to show strike","and revenge based perks"),0);
		setMeta(FeedStarveHealHarm, "Feed/Starve/Heal/Harm Perks", Arrays.asList("Click to show Feed/Starve","And Heal/Harm based perks"),0);
		
		//Buffs/debuffs
		setMeta(NightVision, "Night Vision", Arrays.asList("Adds Permanent Night Vison"),20);
		setMeta(WaterBreathing, "Water Breathing", Arrays.asList("Adds Permanent Water Breathing"),40);
		setMeta(Haste,"Haste",Arrays.asList("Adds Permanent Haste"),50);
		setMeta(Jump, "Jump Boost", Arrays.asList("Adds Permanent Jump Boost"),50);
		setMeta(Speed, "Speed Boost", Arrays.asList("Adds Permanent Speed Boost"),50);
		setMeta(HealthBoost,"Health Boost",Arrays.asList("Adds a Permanent Health Boost"),50);
		
		setMeta(Haste2,"Haste 2",Arrays.asList("Adds Permanent Haste 2"),100);
		setMeta(Jump2, "Jump Boost 2", Arrays.asList("Adds Permanent Jump Boost 2"),100);
		//setSkull("MHF_Ocelot", Speed2, "Speed Boost 2",  Arrays.asList("Adds Permanent Speed Boost 2"),100);
		//setSkull("MHF_Golem", HealthBoost2, "Health Boost 2", Arrays.asList("Adds Permanent Health Boost 2"),100);
		setMeta( Speed2, "Speed Boost 2",  Arrays.asList("Adds Permanent Speed Boost 2"),100);
		setMeta( HealthBoost2, "Health Boost 2", Arrays.asList("Adds Permanent Health Boost 2"),100);
		
		setMeta(MiningFatigue,"Mining Fatigue",Arrays.asList("Adds Permanent Mining Fatigue"),-50);
		setMeta(Slow,"Slowness",Arrays.asList("Adds Permanent Slowness"),-50);
		setMeta(Blind,"Blindness",Arrays.asList("Adds Permanent Blindness"),-60);
		
		
		//Strike and Revenge
		setMeta(StrikeArmorpen,"Strike Armorpen",Arrays.asList("Chance to give negative", "resistance while damaging Enemys"),50);
		setMeta(RevengeArmorpen,"Revenge Armorpen",Arrays.asList("Chance to give negative", "resistance while taking damage from Enemys"),50);
		setMeta(StrikeBlindness,"Strike Blindness",Arrays.asList("Chance to give Blindness", "while damaging Enemys"),50);
		setMeta(RevengeBlindness,"Revenge Blindness",Arrays.asList("Chance to give Blindness", "while taking damage from Enemys"),50);
		setMeta(StrikeFeed,"Strike Feed",Arrays.asList("Chance to get Feed", "while damaging Enemys"),50);
		setMeta(RevengeFeed,"Revenge Feed",Arrays.asList("Chance to get Feed", "while taking damage from Enemys"),50);
		setMeta(StrikeFire,"Strike Fire",Arrays.asList("Chance to catch enemys on", "fire while damaging Enemys"),50);
		setMeta(RevengeFire,"Revenge Fire",Arrays.asList("Chance to catch enemys on", "fire while taking damage from Enemys"),50);
		setMeta(StrikeHarm,"Strike Harm",Arrays.asList("Chance to give enemys extra", "damage while damaging Enemys"),50);
		setMeta(RevengeHarm,"Revenge Harm",Arrays.asList("Chance to give enemys extra", "damage while taking damage from Enemys"),50);
		setMeta(StrikeHeal,"Strike Heal",Arrays.asList("Chance to heal while", "damaging Enemys"),50);
		setMeta(RevengeHeal,"Revenge Heal",Arrays.asList("Chance to heal while", "taking damage from Enemys"),50);
		setMeta(StrikeHunger,"Strike Hunger",Arrays.asList("Chance to give hunger to", "Enemys while damaging Enemys"),50);
		setMeta(RevengeHunger,"Revenge Hunger",Arrays.asList("Chance to give hunger", "to Enemys while taking damage from Enemys"),50);
		setMeta(StrikeNausea,"Strike Nausea",Arrays.asList("Chance to give Nausea to", "Enemys while damaging Enemys"),50);
		setMeta(RevengeNausea,"Revenge Nausea",Arrays.asList("Chance to give Nausea", "to Enemys while taking damage from Enemys"),50);
		setMeta(StrikePoison,"Strike Poison",Arrays.asList("Chance to give poison to", "Enemys while damaging Enemys"),50);
		setMeta(RevengePoison,"Revenge Poison",Arrays.asList("Chance to give poison to", "Enemys while taking damage from Enemys"),50);
		setMeta(StrikeSlow,"Strike Slow",Arrays.asList("Chance to give slowness to", "Enemys while damaging Enemys"),50);
		setMeta(RevengeSlow,"Revenge Slow",Arrays.asList("Chance to give slowness to", "Enemys while taking damage from Enemys"),50);
		setMeta(StrikeStarve,"Strike Starve",Arrays.asList("Chance to remove hunger", "from Enemys while damaging Enemys"),50);
		setMeta(RevengeStarve,"Revenge Starve",Arrays.asList("Chance to remove hunger", "from Enemys while taking damage from Enemys"),50);
		setMeta(StrikeSteal,"Strike Steal",Arrays.asList("Chance to steal money", "to Enemys while damaging Enemys"),50);
		setMeta(RevengeSteal,"Revenge Steal",Arrays.asList("Chance to steal money", "to Enemys while taking damage from Enemys"),50);
		setMeta(StrikeStun,"Strike Stun",Arrays.asList("Chance to stun Enemys", "while damaging Enemys"),50);
		setMeta(RevengeStun,"Revenge Stun",Arrays.asList("Chance to stun Enemys", "while taking damage from Enemys"),50);
		setMeta(StrikeWeakness,"Strike Weakness",Arrays.asList("Chance to give weakness", "to Enemys while damaging Enemys"),50);
		setMeta(RevengeWeakness,"Revenge Weakness",Arrays.asList("Chance to give weakness", "to Enemys while taking damage from Enemys"),50);
		setMeta(StrikeWither,"Strike Wither",Arrays.asList("Chance to give wither to Enemys", "while damaging Enemys"),50);
		setMeta(RevengeWither,"Revenge Wither",Arrays.asList("Chance to give wither to Enemys", "while taking damage from Enemys"),50);
		
		//Food
		setMeta(WaterDrinker, "Water Drinker", Arrays.asList("Gain 3 food when drinking water bottle"),15);
		setMeta(StoneEater, "Stone Eater", Arrays.asList("Gain food when breaking stone by hand"),30);
		setMeta(Carnivore, "Carnivore", Arrays.asList("Can only eat Meats and Cake"),-20);
		setMeta(Herbivore, "Herbivore", Arrays.asList("Can only eat Herb food and Cake"),20);
		setMeta(Nonivore, "Nonivore", Arrays.asList("Can't Eat"),-50);
		
		//Feed
		setMeta(FeedLava,"Feed Lava",Arrays.asList("Get feed while in Lava"),25);
		setMeta(FeedSunlight,"Feed Sunlight",Arrays.asList("Get feed while in Sunlight"),25);
		setMeta(FeedVegetation,"Feed Vegetation",Arrays.asList("Get feed while near Vegetation"),25);
		setMeta(FeedWater,"Feed Water",Arrays.asList("Get feed while in Water"),25);
		setMeta(FeedLight,"Feed Light",Arrays.asList("Get feed while in Light"),35);
		setMeta(FeedDarkness,"Feed Darkness",Arrays.asList("Get feed while in Darkness"),50);
		setMeta(FeedMeditation,"Feed Meditation",Arrays.asList("Get feed while not moving"),50);
		setMeta(FeedAlways,"Feed Always",Arrays.asList("Get feed Always"),100);
		
		//Starve
		setMeta(StarveLava,"Starve Lava",Arrays.asList("Loose Food Level in Lava"),-25);
		setMeta(StarveSunlight,"Starve Sunlight",Arrays.asList("Loose Food Level in Sunlight"),-25);
		setMeta(StarveVegetation,"Starve Vegetation",Arrays.asList("Loose Food Level near Vegetation"),-25);
		setMeta(StarveWater,"Starve Water",Arrays.asList("Loose Food Level in Water"),-25);
		setMeta(StarveLight,"Starve Light",Arrays.asList("Loose Food Level in Light"),-35);
		setMeta(StarveDarkness,"Starve Darkness",Arrays.asList("Loose Food Level in Darkness"),-50);
		setMeta(StarveMeditation,"Starve Meditation",Arrays.asList("Loose Food Level while not Moving"),-50);
		setMeta(StarveAlways,"Starve Always",Arrays.asList("Loose Food Level Always"),-100);
		
		//Heal
		setMeta(HealLava,"Heal Lava",Arrays.asList("Restore Health in lava"),25);
		setMeta(HealSunlight,"Heal Sunlight",Arrays.asList("Restore Health in Sunlight"),25);
		setMeta(HealVegetation,"Heal Vegetation",Arrays.asList("Restore Health near Vegetation"),25);
		setMeta(HealWater,"Heal Water",Arrays.asList("Restore Health in Water"),25);
		setMeta(HealLight,"Heal Light",Arrays.asList("Restore Health in Light"),35);
		setMeta(HealDarkness,"Heal Darkness",Arrays.asList("Restore Health in Darkness"),50);
		setMeta(HealMeditation,"Heal Meditation",Arrays.asList("Restore Health while not Moving"),50);
		setMeta(HealAlways,"Heal Always",Arrays.asList("Restore Health Always"),100);
		
		//Harm
		setMeta(HarmLava,"Harm Lava",Arrays.asList("Loose Health in Lava"),-25);
		setMeta(HarmSunlight,"Harm Sunlight",Arrays.asList("Loose Health in Sunlight"),-25);
		setMeta(HarmVegetation,"Harm Vegetation",Arrays.asList("Loose Health near Vegetation"),-25);
		setMeta(HarmWater,"Harm Water",Arrays.asList("Loose Health in Water"),-25);
		setMeta(HarmLight,"Harm Light",Arrays.asList("Loose Health in Light"),-35);
		setMeta(HarmDarkness,"Harm Darkness",Arrays.asList("Loose Health in Darkness"),-50);
		setMeta(HarmMeditation,"Harm Meditation",Arrays.asList("Loose Health while not Moving"),-50);
		setMeta(HarmAlways,"Harm Always",Arrays.asList("Loose Health Always"),-100);
		
		//Weapon Expert
		setMeta(ExpertArchery,"Expert Archery",Arrays.asList("Deal +25% damage"),50);
		setMeta(ExpertAxe,"Expert Axe",Arrays.asList("Deal +25% damage"),50);
		setMeta(ExpertSword,"Expert Sword",Arrays.asList("Deal +25% damage"),50);
		setMeta(ExpertUnarmed,"Expert Unarmed",Arrays.asList("Deal +25% damage"),50);
		
		//Weapon Resistant
		setMeta(ResistantArchery,"Resistant Archery",Arrays.asList("Take -25% damage"),50);
		setMeta(ResistantAxe,"Resistant Axe",Arrays.asList("Take -25% damage"),50);
		setMeta(ResistantSword,"Resistant Sword",Arrays.asList("Take -25% damage"),50);
		setMeta(ResistantUnarmed,"Resistant Unarmed",Arrays.asList("Take -25% damage"),50);
		
		//Weapon Inept
		setMeta(IneptArchery,"Inept Archery",Arrays.asList("Deal -25% damage"),-50);
		setMeta(IneptAxe,"Inept Axe",Arrays.asList("Deal -25% damage"),-50);
		setMeta(IneptSword,"Inept Sword",Arrays.asList("Deal -25% damage"),-50);
		setMeta(IneptUnarmed,"Inept Unarmed",Arrays.asList("Deal -25% damage"),-50);
		
		//Weapon Vulnerable
		setMeta(VulnerableArchery,"Vulnerable Archery",Arrays.asList("Take +25% damage"),-50);
		setMeta(VulnerableAxe,"Vulnerable Axe",Arrays.asList("Take +25% damage"),-50);
		setMeta(VulnerableSword,"Vulnerable Sword",Arrays.asList("Take +25% damage"),-50);
		setMeta(VulnerableUnarmed,"Vulnerable Unarmed",Arrays.asList("Take +25% damage"),-50);
		
		//Misc
		setMeta(Holy,"Holy",Arrays.asList("Deals extra damage to Unholy people","Takes less damage to Unholy people"),25);
		setMeta(Unholy,"Unholy",Arrays.asList("Takes more damage from Holy people","Deals less damage to Holy people"),-25);
		
		
		
		//Immunity
		setMeta(ImmuneArmorpen,"Immune Armorpen",Arrays.asList("Immune to ArmorpenStrike", "and ArmorpenRevenge."),50);
		setMeta(ImmuneHarm,"Immune Harm",Arrays.asList("Immune to Thorns Enchantment,", "HarmStrike and HarmRevenge."),50);
		setMeta(ImmuneHunger,"Immune Hunger",Arrays.asList("Immune to HungerStrike,", "HungerRevenge, and all Hunger effects."),20);
		setMeta(ImmuneNausea,"Immune Nausea",Arrays.asList("Immune to NauseaStrike,", "NauseaRevenge, and all Nausea/Confusion effects."),20);
		setMeta(ImmuneStarve,"Immune Starve",Arrays.asList("Immune to StarveStrike", "and StarveRevenge."),50);
		setMeta(ImmuneFall,"Immune Fall",Arrays.asList("Immune to damage taken", "from fall damage."),30);
		setMeta(ImmuneSteal,"Immune Steal",Arrays.asList("Immune to StealStrike", "and StealRevenge."),30);
		
		setMeta(ImmuneWeakness,"Immune Weakness",Arrays.asList("Immune to WeaknessStrike, WeaknessRevenge,", "and all Weakness effects."),30);
		setMeta(ImmuneWither,"Immune Wither",Arrays.asList("Immune to WitherStrike, WitherRevenge,", "and all Wither effects."),30);
		setMeta(ImmuneFire,"Immune Fire",Arrays.asList("Immune to Fire and Lava."),50);
		setMeta(ImmunePoison,"Immune Poison",Arrays.asList("Immune to PoisonStrike, PoisonRevenge,", "and all Poison effects."),40);
		setMeta(ImmuneBlindness,"Immune Blindness",Arrays.asList("Immune to BlindStrike,", "BlindRevenge, and all Blind effects."),50);
		setMeta(ImmuneSlow,"Immune Slow",Arrays.asList("Immune to SlowStrike, SlowRevenge,", "StunStrike, StunRevenge and all Slow effects."),50);
		
		//Fly
		setMeta(FlyWater,"Fly Water",Arrays.asList("Fly when in Water"),50);
		setMeta(FlyLava,"Fly Lava",Arrays.asList("Fly when in Lava"),50);
		setMeta(FlyWeb,"Fly Web",Arrays.asList("Fly when in Webs"),50);
		
		//Truce
		setSkull("MHF_Slime",TruceSlime,"Truce Slime",Arrays.asList("Truce with Slimes and Magma Cubes"),15);
		setSkull("MHF_Blaze",TruceBlaze,"Truce Blaze",Arrays.asList("Truce with Blazes"),30);
		setSkull("AlexVMiner",TruceSilverFish,"Truce SilverFish",Arrays.asList("Truce with Silverfishes"),30);
		setSkull("MHF_Spider",TruceSpider,"Truce Spider",Arrays.asList("Truce with Spiders and Cave Spiders"),30);
		setSkull("MHF_Skeleton",TruceUndead,"Truce Undead",Arrays.asList("Truce with Zombies,", "Skeletons and Wither Skeletons"),30);
		setSkull("MHF_Creeper",TruceCreeper,"Truce Creeper",Arrays.asList("Truce with Creepers"),40);
		setSkull("MHF_Ghast",TruceGhast,"Truce Ghast",Arrays.asList("Truce with Ghasts"),50);
		setSkull("MHF_Villager",TruceWitch,"Truce Witch",Arrays.asList("Truce with Witches"),60);
		
	}
	
	@SuppressWarnings("rawtypes")
	static void setSkull(String playerName,ItemStack itemStack, String ItemName, List lore,Integer cost){
		SkullMeta skullmeta = (SkullMeta) itemStack.getItemMeta();
		skullmeta.setOwner(playerName);
		itemStack.setItemMeta(skullmeta);
		
		setMeta(itemStack,ItemName,lore,cost);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	static void setMeta(ItemStack itemStack, String name, List lore,Integer cost){
		itemMeta = itemStack.getItemMeta();
		itemMeta.setDisplayName(name);
		if(cost!=0){
			List<String> completeList = new ArrayList<String>();
			completeList.addAll(lore);
			completeList.add("Costs: "+cost+" to equip");
			itemMeta.setLore(completeList);
		}else{
			//List<String> completeList = new ArrayList<String>();
			//completeList.addAll(lore);
			//completeList.add("Costs: "+cost);
			//itemMeta.setLore(completeList);
			itemMeta.setLore(lore);
		}
		itemStack.setItemMeta(itemMeta);
		addToMap(itemStack);
		perkCosts.put(itemStack,cost);
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	static void setMeta(ItemStack itemStack, String name, List lore,Boolean addToHashMap){
		itemMeta = itemStack.getItemMeta();
		itemMeta.setDisplayName(name);
		itemMeta.setLore(lore);
		itemStack.setItemMeta(itemMeta);
		if(addToHashMap)
			addToMap(itemStack);
		
	}
	
	static void addToMap(ItemStack item){
		items.put(item.getItemMeta().getDisplayName().toString(),item);
		
	}
	
	static void addToMap(ItemStack item,String name){
		items.put(name,item);
		
	}
	
}
