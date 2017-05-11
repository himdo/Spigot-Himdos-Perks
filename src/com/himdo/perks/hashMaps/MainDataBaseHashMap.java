package com.himdo.perks.hashMaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffectType;

import com.himdo.perks.MainPlugin;

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
	//static ItemStack StrikeSteal = new ItemStack(Material.GOLD_NUGGET);
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
	//static ItemStack RevengeSteal = new ItemStack(Material.GOLD_NUGGET);
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
	//static ItemStack FeedMeditation = new ItemStack(Material.GOLD_BOOTS);
	static ItemStack FeedAlways = new ItemStack(Material.CAKE);

	//Starve
	static ItemStack StarveLava = new ItemStack(Material.LAVA_BUCKET);
	static ItemStack StarveSunlight = new ItemStack(Material.DAYLIGHT_DETECTOR);
	static ItemStack StarveVegetation = new ItemStack(Material.CARROT_ITEM);
	static ItemStack StarveWater = new ItemStack(Material.WATER_BUCKET);
	static ItemStack StarveLight = new ItemStack(Material.TORCH);
	static ItemStack StarveDarkness = new ItemStack(Material.REDSTONE_TORCH_ON);
	//static ItemStack StarveMeditation = new ItemStack(Material.GOLD_BOOTS);
	static ItemStack StarveAlways = new ItemStack(Material.CAKE);

	//Heal
	static ItemStack HealLava = new ItemStack(Material.LAVA_BUCKET);
	static ItemStack HealSunlight = new ItemStack(Material.DAYLIGHT_DETECTOR);
	static ItemStack HealVegetation = new ItemStack(Material.CARROT_ITEM);
	static ItemStack HealWater = new ItemStack(Material.WATER_BUCKET);
	static ItemStack HealLight = new ItemStack(Material.TORCH);
	static ItemStack HealDarkness = new ItemStack(Material.REDSTONE_TORCH_ON);
	//static ItemStack HealMeditation = new ItemStack(Material.GOLD_BOOTS);
	static ItemStack HealAlways = new ItemStack(Material.CAKE);

	//Harm
	static ItemStack HarmLava = new ItemStack(Material.LAVA_BUCKET);
	static ItemStack HarmSunlight = new ItemStack(Material.DAYLIGHT_DETECTOR);
	static ItemStack HarmVegetation = new ItemStack(Material.CARROT_ITEM);
	static ItemStack HarmWater = new ItemStack(Material.WATER_BUCKET);
	static ItemStack HarmLight = new ItemStack(Material.TORCH);
	static ItemStack HarmDarkness = new ItemStack(Material.REDSTONE_TORCH_ON);
	//static ItemStack HarmMeditation = new ItemStack(Material.GOLD_BOOTS);
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
	
	//Inept config.getInt("Perks.Help.cost")
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
	//static ItemStack ImmuneSteal = new ItemStack(Material.GOLD_NUGGET);
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
	
	static ItemStack Help = new ItemStack(Material.STAINED_GLASS_PANE,1, (short) MainPlugin.config.getInt("HelpPaneColor"));
	static ItemStack LeftArrow = new ItemStack(Material.STAINED_GLASS_PANE,1, (short) MainPlugin.config.getInt("BackPaneColor"));
	static ItemStack RightArrow = new ItemStack(Material.STAINED_GLASS_PANE,1, (short) MainPlugin.config.getInt("ForwardPaneColor"));
	
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
	static ItemStack BorderPurple = new ItemStack(Material.STAINED_GLASS_PANE,1, (short) MainPlugin.config.getInt("BorderPaneColor"));
	
	//Help
	static ItemStack Help1=new ItemStack(Material.APPLE);
	static ItemStack Help2=new ItemStack(Material.APPLE);
	static ItemStack Help3=new ItemStack(Material.APPLE);
	static ItemStack Help4=new ItemStack(Material.APPLE);
	static ItemStack Help5=new ItemStack(Material.APPLE);
	static ItemStack Help6=new ItemStack(Material.APPLE);
	
	
	
	//More Misc Perks
	//Snowball Damager
	static ItemStack SnowBallThrower=new ItemStack(Material.SNOW_BALL);
	
	//Informed
	static ItemStack Informed=new ItemStack(Material.BOOK);
	
	
	static private ItemMeta itemMeta;
	
	public static void setHashMap(){
		FileConfiguration config = MainPlugin.config;
		//Bukkit.getLogger().log(Level.INFO, config.getBoolean("Perks.NightVision.enabled")+"");
		//Bukkit.getLogger().log(Level.INFO, config.getList("Perks.NightVision.lore")+"");
		
		items=new HashMap<String, ItemStack>();
		perkCosts = new HashMap<ItemStack,Integer>();
		
		//borders 
		setMeta(BorderPurple, " ", null,false);
		addToMap(BorderPurple,"Border Purple");
		
		//Help
		
		if(config.getBoolean("Perks.Help1.enabled")){
			setMeta(Help1, config.getString("Perks.Help1.name"), config.getList("Perks.Help1.lore"),false);
			addToMap(Help1,"Help 1");
		}
		//setMeta(Help1, "What are Perks?", Arrays.asList("Perks are abilitys","that make you unique."),false);
		//addToMap(Help1,"Help 1");
		if(config.getBoolean("Perks.Help2.enabled")){
			setMeta(Help2, config.getString("Perks.Help2.name"), config.getList("Perks.Help2.lore"),false);
			addToMap(Help2,"Help 2");
		}
		if(config.getBoolean("Perks.Help3.enabled")){
			setMeta(Help3, config.getString("Perks.Help3.name"), config.getList("Perks.Help3.lore"),false);
			addToMap(Help3,"Help 3");
		}
		if(config.getBoolean("Perks.Help4.enabled")){
			setMeta(Help4, config.getString("Perks.Help4.name"), config.getList("Perks.Help4.lore"),false);
			addToMap(Help4,"Help 4");
		}
		if(config.getBoolean("Perks.Help5.enabled")){
			setMeta(Help5, config.getString("Perks.Help5.name"), config.getList("Perks.Help5.lore"),false);
			addToMap(Help5,"Help 5");
		}
		if(config.getBoolean("Perks.Help6.enabled")){
			setMeta(Help6, config.getString("Perks.Help6.name"), config.getList("Perks.Help6.lore"),false);
			addToMap(Help6,"Help 6");
		}
		
		
		
		
		
		
		
		//Icons
		//main
		if(config.getBoolean("Perks.Perks.enabled"))
			setMeta(AddPerk, 			config.getString("Perks.Perks.name"), config.getList("Perks.Perks.lore"), config.getInt("MenuItemCost"));
		//setSkull("MHF_Question", Help, "Help",  Arrays.asList("Click to get Help"),0);
		//setSkull("MHF_ArrowLeft", LeftArrow, "Back",  Arrays.asList("Click to go Back"),0);
		//setSkull("MHF_ArrowRight", RightArrow, "Next",  Arrays.asList("Click to go to Next page"),0);
		if(config.getBoolean("Perks.Help.enabled"))
			setMeta( Help, 				config.getString("Perks.Help.name"),  config.getList("Perks.Help.lore"), config.getInt("MenuItemCost"));
		if(config.getBoolean("Perks.LeftArrow.enabled"))
			setMeta( LeftArrow, 		config.getString("Perks.LeftArrow.name"),  config.getList("Perks.LeftArrow.lore"), config.getInt("MenuItemCost"));
		if(config.getBoolean("Perks.RightArrow.enabled"))
			setMeta( RightArrow, 		config.getString("Perks.RightArrow.name"),  config.getList("Perks.RightArrow.lore"), config.getInt("MenuItemCost"));
		
		//secondary
		PotionMeta p = (PotionMeta) Buffs.getItemMeta();
		p.addCustomEffect(PotionEffectType.HEAL.createEffect(0, 0), true);
		Buffs.setItemMeta(p);
		if(config.getBoolean("Perks.Buffs.enabled"))
			setMeta(Buffs, 				config.getString("Perks.Buffs.name"), config.getList("Perks.Buffs.lore"), config.getInt("MenuItemCost"));
		if(config.getBoolean("Perks.Food.enabled"))
			setMeta(Food,				config.getString("Perks.Food.name"), config.getList("Perks.Food.lore"), config.getInt("MenuItemCost"));
		if(config.getBoolean("Perks.Truce.enabled"))
			setMeta(Truce,				config.getString("Perks.Truce.name"), config.getList("Perks.Truce.lore"), config.getInt("MenuItemCost"));
		if(config.getBoolean("Perks.Misc.enabled"))
			setMeta(Misc,				config.getString("Perks.Misc.name"), config.getList("Perks.Misc.lore"), config.getInt("MenuItemCost"));
		if(config.getBoolean("Perks.Fly.enabled"))
			setMeta(Fly, 				config.getString("Perks.Fly.name"), config.getList("Perks.Fly.lore"), config.getInt("MenuItemCost"));
		if(config.getBoolean("Perks.Immune.enabled"))
			setMeta(Immune, 			config.getString("Perks.Immune.name"), config.getList("Perks.Help2.lore"), config.getInt("MenuItemCost"));
		if(config.getBoolean("Perks.WeaponStats.enabled"))
			setMeta(WeaponStats,		config.getString("Perks.WeaponStats.name"), config.getList("Perks.WeaponStats.lore"), config.getInt("MenuItemCost"));
		if(config.getBoolean("Perks.StrikeRevenge.enabled"))
			setMeta(StrikeRevenge, 		config.getString("Perks.StrikeRevenge.name"), config.getList("Perks.StrikeRevenge.lore"), config.getInt("MenuItemCost"));
		if(config.getBoolean("Perks.FeedStarveHealHarm.enabled"))
			setMeta(FeedStarveHealHarm, config.getString("Perks.FeedStarveHealHarm.name"), config.getList("Perks.FeedStarveHealHarm.lore"), config.getInt("MenuItemCost"));
		
		//Buffs/debuffs
		if(config.getBoolean("Perks.NightVision.enabled"))
			setMeta(NightVision, 		config.getString("Perks.NightVision.name"), config.getList("Perks.NightVision.lore"), config.getInt("Perks.NightVision.cost"));
		if(config.getBoolean("Perks.WaterBreathing.enabled"))
			setMeta(WaterBreathing, 	config.getString("Perks.WaterBreathing.name"), config.getList("Perks.WaterBreathing.lore"), config.getInt("Perks.WaterBreathing.cost"));
		if(config.getBoolean("Perks.Haste.enabled"))
			setMeta(Haste,				config.getString("Perks.Haste.name"), config.getList("Perks.Haste.lore"), config.getInt("Perks.Haste.cost"));
		if(config.getBoolean("Perks.Jump.enabled"))
			setMeta(Jump, 				config.getString("Perks.Jump.name"), config.getList("Perks.Jump.lore"), config.getInt("Perks.Jump.cost"));
		if(config.getBoolean("Perks.Speed.enabled"))
			setMeta(Speed, 				config.getString("Perks.Speed.name"), config.getList("Perks.Speed.lore"), config.getInt("Perks.Speed.cost"));
		if(config.getBoolean("Perks.HealthBoost.enabled"))
			setMeta(HealthBoost,		config.getString("Perks.HealthBoost.name"), config.getList("Perks.HealthBoost.lore"), config.getInt("Perks.HealthBoost.cost"));
		if(config.getBoolean("Perks.Haste2.enabled"))
			setMeta(Haste2,				config.getString("Perks.Haste2.name"), config.getList("Perks.Haste2.lore"), config.getInt("Perks.Haste2.cost"));
		if(config.getBoolean("Perks.Jump2.enabled"))
			setMeta(Jump2, 				config.getString("Perks.Jump2.name"), config.getList("Perks.Jump2.lore"), config.getInt("Perks.Jump2.cost"));
		//setSkull("MHF_Ocelot", Speed2, "Speed Boost 2",  Arrays.asList("Adds Permanent Speed Boost 2"), config.getInt("Perks.Help.cost")0);
		//setSkull("MHF_Golem", HealthBoost2, "Health Boost 2", Arrays.asList("Adds Permanent Health Boost 2"), config.getInt("Perks.Help.cost")0);
		if(config.getBoolean("Perks.Speed2.enabled"))
			setMeta( Speed2, 			config.getString("Perks.Speed2.name"), config.getList("Perks.Speed2.lore"), config.getInt("Perks.Speed2.cost"));
		if(config.getBoolean("Perks.HealthBoost2.enabled"))
			setMeta( HealthBoost2, 		config.getString("Perks.HealthBoost2.name"), config.getList("Perks.HealthBoost2.lore"), config.getInt("Perks.HealthBoost2.cost"));
		if(config.getBoolean("Perks.MiningFatigue.enabled"))
			setMeta(MiningFatigue,		config.getString("Perks.MiningFatigue.name"), config.getList("Perks.MiningFatigue.lore"), config.getInt("Perks.MiningFatigue.cost"));
		if(config.getBoolean("Perks.Slow.enabled"))
			setMeta(Slow,				config.getString("Perks.Slow.name"), config.getList("Perks.Slow.lore"), config.getInt("Perks.Slow.cost"));
		if(config.getBoolean("Perks.Blind.enabled"))
			setMeta(Blind,				config.getString("Perks.Blind.name"), config.getList("Perks.Blind.lore"), config.getInt("Perks.Blind.cost"));
		
		
		//Strike and Revenge
		if(config.getBoolean("Perks.StrikeArmorpen.enabled"))
			setMeta(StrikeArmorpen,		config.getString("Perks.StrikeArmorpen.name"), config.getList("Perks.StrikeArmorpen.lore"), config.getInt("Perks.StrikeArmorpen.cost"));
		if(config.getBoolean("Perks.RevengeArmorpen.enabled"))
			setMeta(RevengeArmorpen,	config.getString("Perks.RevengeArmorpen.name"), config.getList("Perks.RevengeArmorpen.lore"), config.getInt("Perks.RevengeArmorpen.cost"));
		if(config.getBoolean("Perks.StrikeBlindness.enabled"))
			setMeta(StrikeBlindness,	config.getString("Perks.StrikeBlindness.name"), config.getList("Perks.StrikeBlindness.lore"), config.getInt("Perks.StrikeBlindness.cost"));
		if(config.getBoolean("Perks.RevengeBlindness.enabled"))
			setMeta(RevengeBlindness,	config.getString("Perks.RevengeBlindness.name"), config.getList("Perks.RevengeBlindness.lore"), config.getInt("Perks.RevengeBlindness.cost"));
		if(config.getBoolean("Perks.StrikeFeed.enabled"))
			setMeta(StrikeFeed,			config.getString("Perks.StrikeFeed.name"), config.getList("Perks.StrikeFeed.lore"), config.getInt("Perks.StrikeFeed.cost"));
		if(config.getBoolean("Perks.RevengeFeed.enabled"))
			setMeta(RevengeFeed,		config.getString("Perks.RevengeFeed.name"), config.getList("Perks.RevengeFeed.lore"), config.getInt("Perks.RevengeFeed.cost"));
		if(config.getBoolean("Perks.StrikeFire.enabled"))
			setMeta(StrikeFire,			config.getString("Perks.StrikeFire.name"), config.getList("Perks.StrikeFire.lore"), config.getInt("Perks.StrikeFire.cost"));
		if(config.getBoolean("Perks.RevengeFire.enabled"))
			setMeta(RevengeFire,		config.getString("Perks.RevengeFire.name"), config.getList("Perks.RevengeFire.lore"), config.getInt("Perks.RevengeFire.cost"));
		if(config.getBoolean("Perks.StrikeHarm.enabled"))
			setMeta(StrikeHarm,			config.getString("Perks.StrikeHarm.name"), config.getList("Perks.StrikeHarm.lore"), config.getInt("Perks.StrikeHarm.cost"));
		if(config.getBoolean("Perks.RevengeHarm.enabled"))
			setMeta(RevengeHarm,		config.getString("Perks.RevengeHarm.name"), config.getList("Perks.RevengeHarm.lore"), config.getInt("Perks.RevengeHarm.cost"));
		if(config.getBoolean("Perks.StrikeHeal.enabled"))
			setMeta(StrikeHeal,			config.getString("Perks.StrikeHeal.name"), config.getList("Perks.StrikeHeal.lore"), config.getInt("Perks.StrikeHeal.cost"));
		if(config.getBoolean("Perks.RevengeHeal.enabled"))
			setMeta(RevengeHeal,		config.getString("Perks.RevengeHeal.name"), config.getList("Perks.RevengeHeal.lore"), config.getInt("Perks.RevengeHeal.cost"));
		if(config.getBoolean("Perks.StrikeHunger.enabled"))
			setMeta(StrikeHunger,		config.getString("Perks.StrikeHunger.name"), config.getList("Perks.StrikeHunger.lore"), config.getInt("Perks.StrikeHunger.cost"));
		if(config.getBoolean("Perks.RevengeHunger.enabled"))
			setMeta(RevengeHunger,		config.getString("Perks.RevengeHunger.name"), config.getList("Perks.RevengeHunger.lore"), config.getInt("Perks.RevengeHunger.cost"));
		if(config.getBoolean("Perks.StrikeNausea.enabled"))
			setMeta(StrikeNausea,		config.getString("Perks.StrikeNausea.name"), config.getList("Perks.StrikeNausea.lore"), config.getInt("Perks.StrikeNausea.cost"));
		if(config.getBoolean("Perks.RevengeNausea.enabled"))
			setMeta(RevengeNausea,		config.getString("Perks.RevengeNausea.name"), config.getList("Perks.RevengeNausea.lore"), config.getInt("Perks.RevengeNausea.cost"));
		if(config.getBoolean("Perks.StrikePoison.enabled"))
			setMeta(StrikePoison,		config.getString("Perks.StrikePoison.name"), config.getList("Perks.StrikePoison.lore"), config.getInt("Perks.StrikePoison.cost"));
		if(config.getBoolean("Perks.RevengePoison.enabled"))
			setMeta(RevengePoison,		config.getString("Perks.RevengePoison.name"), config.getList("Perks.RevengePoison.lore"), config.getInt("Perks.RevengePoison.cost"));
		if(config.getBoolean("Perks.StrikeSlow.enabled"))
			setMeta(StrikeSlow,			config.getString("Perks.StrikeSlow.name"), config.getList("Perks.StrikeSlow.lore"), config.getInt("Perks.StrikeSlow.cost"));
		if(config.getBoolean("Perks.RevengeSlow.enabled"))
			setMeta(RevengeSlow,		config.getString("Perks.RevengeSlow.name"), config.getList("Perks.RevengeSlow.lore"), config.getInt("Perks.RevengeSlow.cost"));
		if(config.getBoolean("Perks.StrikeStarve.enabled"))
			setMeta(StrikeStarve,		config.getString("Perks.StrikeStarve.name"), config.getList("Perks.StrikeStarve.lore"), config.getInt("Perks.StrikeStarve.cost"));
		if(config.getBoolean("Perks.RevengeStarve.enabled"))
			setMeta(RevengeStarve,		config.getString("Perks.RevengeStarve.name"), config.getList("Perks.RevengeStarve.lore"), config.getInt("Perks.RevengeStarve.cost"));
		if(config.getBoolean("Perks.StrikeStun.enabled"))
			setMeta(StrikeStun,			config.getString("Perks.StrikeStun.name"), config.getList("Perks.StrikeStun.lore"), config.getInt("Perks.StrikeStun.cost"));
		if(config.getBoolean("Perks.RevengeStun.enabled"))
			setMeta(RevengeStun,		config.getString("Perks.RevengeStun.name"), config.getList("Perks.RevengeStun.lore"), config.getInt("Perks.RevengeStun.cost"));
		if(config.getBoolean("Perks.StrikeWeakness.enabled"))
			setMeta(StrikeWeakness,		config.getString("Perks.StrikeWeakness.name"), config.getList("Perks.StrikeWeakness.lore"), config.getInt("Perks.StrikeWeakness.cost"));
		if(config.getBoolean("Perks.RevengeWeakness.enabled"))
			setMeta(RevengeWeakness,	config.getString("Perks.RevengeWeakness.name"), config.getList("Perks.RevengeWeakness.lore"), config.getInt("Perks.RevengeWeakness.cost"));
		if(config.getBoolean("Perks.StrikeWither.enabled"))
			setMeta(StrikeWither,		config.getString("Perks.StrikeWither.name"), config.getList("Perks.StrikeWither.lore"), config.getInt("Perks.StrikeWither.cost"));
		if(config.getBoolean("Perks.RevengeWither.enabled"))
			setMeta(RevengeWither,		config.getString("Perks.RevengeWither.name"), config.getList("Perks.RevengeWither.lore"), config.getInt("Perks.RevengeWither.cost"));
		
		//Food
		if(config.getBoolean("Perks.WaterDrinker.enabled"))
			setMeta(WaterDrinker, 		config.getString("Perks.WaterDrinker.name"), config.getList("Perks.WaterDrinker.lore"), config.getInt("Perks.WaterDrinker.cost"));
		if(config.getBoolean("Perks.StoneEater.enabled"))
			setMeta(StoneEater, 		config.getString("Perks.StoneEater.name"), config.getList("Perks.StoneEater.lore"), config.getInt("Perks.StoneEater.cost"));
		if(config.getBoolean("Perks.Carnivore.enabled"))
			setMeta(Carnivore, 			config.getString("Perks.Carnivore.name"), config.getList("Perks.Carnivore.lore"), config.getInt("Perks.Carnivore.cost"));
		if(config.getBoolean("Perks.Herbivore.enabled"))
			setMeta(Herbivore, 			config.getString("Perks.Herbivore.name"), config.getList("Perks.Herbivore.lore"), config.getInt("Perks.Herbivore.cost"));
		if(config.getBoolean("Perks.Nonivore.enabled"))
			setMeta(Nonivore, 			config.getString("Perks.Nonivore.name"), config.getList("Perks.Nonivore.lore"), config.getInt("Perks.Nonivore.cost"));
		
		//Feed
		if(config.getBoolean("Perks.FeedLava.enabled"))
			setMeta(FeedLava,			config.getString("Perks.FeedLava.name"), config.getList("Perks.FeedLava.lore"), config.getInt("Perks.FeedLava.cost"));
		if(config.getBoolean("Perks.FeedSunlight.enabled"))
			setMeta(FeedSunlight,		config.getString("Perks.FeedSunlight.name"), config.getList("Perks.FeedSunlight.lore"), config.getInt("Perks.FeedSunlight.cost"));
		if(config.getBoolean("Perks.FeedVegetation.enabled"))
			setMeta(FeedVegetation,		config.getString("Perks.FeedVegetation.name"), config.getList("Perks.FeedVegetation.lore"), config.getInt("Perks.FeedVegetation.cost"));
		if(config.getBoolean("Perks.FeedWater.enabled"))
			setMeta(FeedWater,			config.getString("Perks.FeedWater.name"), config.getList("Perks.FeedWater.lore"), config.getInt("Perks.FeedWater.cost"));
		if(config.getBoolean("Perks.FeedLight.enabled"))
			setMeta(FeedLight,			config.getString("Perks.FeedLight.name"), config.getList("Perks.FeedLight.lore"), config.getInt("Perks.FeedLight.cost"));
		if(config.getBoolean("Perks.FeedDarkness.enabled"))
			setMeta(FeedDarkness,		config.getString("Perks.FeedDarkness.name"), config.getList("Perks.FeedDarkness.lore"), config.getInt("Perks.FeedDarkness.cost"));
		//setMeta(FeedMeditation,"Feed Meditation",Arrays.asList("Get feed while not moving"), config.getInt("Perks.Help.cost"));
		if(config.getBoolean("Perks.FeedAlways.enabled"))
			setMeta(FeedAlways,			config.getString("Perks.FeedAlways.name"), config.getList("Perks.FeedAlways.lore"), config.getInt("Perks.FeedAlways.cost"));
		
		//Starve
		if(config.getBoolean("Perks.StarveLava.enabled"))
			setMeta(StarveLava,			config.getString("Perks.StarveLava.name"), config.getList("Perks.StarveLava.lore"), config.getInt("Perks.StarveLava.cost"));
		if(config.getBoolean("Perks.StarveSunlight.enabled"))
			setMeta(StarveSunlight,		config.getString("Perks.StarveSunlight.name"), config.getList("Perks.StarveSunlight.lore"), config.getInt("Perks.StarveSunlight.cost"));
		if(config.getBoolean("Perks.StarveVegetation.enabled"))
			setMeta(StarveVegetation,	config.getString("Perks.StarveVegetation.name"), config.getList("Perks.StarveVegetation.lore"), config.getInt("Perks.StarveVegetation.cost"));
		if(config.getBoolean("Perks.StarveWater.enabled"))
			setMeta(StarveWater,		config.getString("Perks.StarveWater.name"), config.getList("Perks.StarveWater.lore"), config.getInt("Perks.StarveWater.cost"));
		if(config.getBoolean("Perks.StarveLight.enabled"))
			setMeta(StarveLight,		config.getString("Perks.StarveLight.name"), config.getList("Perks.StarveLight.lore"), config.getInt("Perks.StarveLight.cost"));
		if(config.getBoolean("Perks.StarveDarkness.enabled"))
			setMeta(StarveDarkness,		config.getString("Perks.StarveDarkness.name"), config.getList("Perks.StarveDarkness.lore"), config.getInt("Perks.StarveDarkness.cost"));
		//setMeta(StarveMeditation,"Starve Meditation",Arrays.asList("Loose Food Level while not Moving"), config.getInt("Perks.Help.cost"));
		if(config.getBoolean("Perks.StarveAlways.enabled"))
			setMeta(StarveAlways,		config.getString("Perks.StarveAlways.name"), config.getList("Perks.StarveAlways.lore"), config.getInt("Perks.StarveAlways.cost"));
		
		//Heal
		if(config.getBoolean("Perks.HealLava.enabled"))
			setMeta(HealLava,			config.getString("Perks.HealLava.name"),				config.getList("Perks.HealLava.lore"), config.getInt("Perks.HealLava.cost"));
		if(config.getBoolean("Perks.HealSunlight.enabled"))
			setMeta(HealSunlight,		config.getString("Perks.HealSunlight.name"), 			config.getList("Perks.HealSunlight.lore"), config.getInt("Perks.HealSunlight.cost"));
		if(config.getBoolean("Perks.HealVegetation.enabled"))
			setMeta(HealVegetation,		config.getString("Perks.HealVegetation.name"), 			config.getList("Perks.HealVegetation.lore"), config.getInt("Perks.HealVegetation.cost"));
		if(config.getBoolean("Perks.HealWater.enabled"))
			setMeta(HealWater,			config.getString("Perks.HealWater.name"), 				config.getList("Perks.HealWater.lore"), config.getInt("Perks.HealWater.cost"));
		if(config.getBoolean("Perks.HealLight.enabled"))
			setMeta(HealLight,			config.getString("Perks.HealLight.name"),				config.getList("Perks.HealLight.lore"), config.getInt("Perks.HealLight.cost"));
		if(config.getBoolean("Perks.HealDarkness.enabled"))
			setMeta(HealDarkness,		config.getString("Perks.HealDarkness.name"), 			config.getList("Perks.HealDarkness.lore"), config.getInt("Perks.HealDarkness.cost"));
		//setMeta(HealMeditation,"Heal Meditation",Arrays.asList("Restore Health while not Moving"), config.getInt("Perks.Help.cost"));
		if(config.getBoolean("Perks.HealAlways.enabled"))
			setMeta(HealAlways,			config.getString("Perks.HealAlways.name"), 				config.getList("Perks.HealAlways.lore"), config.getInt("Perks.HealAlways.cost"));
		
		//Harm
		if(config.getBoolean("Perks.HarmLava.enabled"))
			setMeta(HarmLava,			config.getString("Perks.HarmLava.name"), 				config.getList("Perks.HarmLava.lore"), config.getInt("Perks.HarmLava.cost"));
		if(config.getBoolean("Perks.HarmSunlight.enabled"))
			setMeta(HarmSunlight,		config.getString("Perks.HarmSunlight.name"), 			config.getList("Perks.HarmSunlight.lore"), config.getInt("Perks.HarmSunlight.cost"));
		if(config.getBoolean("Perks.HarmVegetation.enabled"))
			setMeta(HarmVegetation,		config.getString("Perks.HarmVegetation.name"), 			config.getList("Perks.HarmVegetation.lore"), config.getInt("Perks.HarmVegetation.cost"));
		if(config.getBoolean("Perks.HarmWater.enabled"))
			setMeta(HarmWater,			config.getString("Perks.HarmWater.name"), 				config.getList("Perks.HarmWater.lore"), config.getInt("Perks.HarmWater.cost"));
		if(config.getBoolean("Perks.HarmLight.enabled"))
			setMeta(HarmLight,			config.getString("Perks.HarmLight.name"), 				config.getList("Perks.HarmLight.lore"), config.getInt("Perks.HarmLight.cost"));
		if(config.getBoolean("Perks.HarmDarkness.enabled"))
			setMeta(HarmDarkness,		config.getString("Perks.HarmDarkness.name"), 			config.getList("Perks.HarmDarkness.lore"), config.getInt("Perks.HarmDarkness.cost"));
		//setMeta(HarmMeditation,"Harm Meditation",Arrays.asList("Loose Health while not Moving"), config.getInt("Perks.Help.cost"));
		if(config.getBoolean("Perks.HarmAlways.enabled"))
			setMeta(HarmAlways,			config.getString("Perks.HarmAlways.name"), 				config.getList("Perks.HarmAlways.lore"), config.getInt("Perks.HarmAlways.cost"));
		
		//Weapon Expert
		if(config.getBoolean("Perks.ExpertArchery.enabled"))
			setMeta(ExpertArchery,		config.getString("Perks.ExpertArchery.name"), 			config.getList("Perks.ExpertArchery.lore"), config.getInt("Perks.ExpertArchery.cost"));
		if(config.getBoolean("Perks.ExpertAxe.enabled"))
			setMeta(ExpertAxe,			config.getString("Perks.ExpertAxe.name"), 				config.getList("Perks.ExpertAxe.lore"), config.getInt("Perks.ExpertAxe.cost"));
		if(config.getBoolean("Perks.ExpertSword.enabled"))
			setMeta(ExpertSword,		config.getString("Perks.ExpertSword.name"), 			config.getList("Perks.ExpertSword.lore"), config.getInt("Perks.ExpertSword.cost"));
		if(config.getBoolean("Perks.ExpertUnarmed.enabled"))
			setMeta(ExpertUnarmed,		config.getString("Perks.ExpertUnarmed.name"), 			config.getList("Perks.ExpertUnarmed.lore"), config.getInt("Perks.ExpertUnarmed.cost"));
		
		//Weapon Resistant
		if(config.getBoolean("Perks.ResistantArchery.enabled"))
			setMeta(ResistantArchery,	config.getString("Perks.ResistantArchery.name"), 		config.getList("Perks.ResistantArchery.lore"), config.getInt("Perks.ResistantArchery.cost"));
		if(config.getBoolean("Perks.ResistantAxe.enabled"))
			setMeta(ResistantAxe,		config.getString("Perks.ResistantAxe.name"), 			config.getList("Perks.ResistantAxe.lore"), config.getInt("Perks.ResistantAxe.cost"));
		if(config.getBoolean("Perks.ResistantSword.enabled"))
			setMeta(ResistantSword,		config.getString("Perks.ResistantSword.name"), 			config.getList("Perks.ResistantSword.lore"), config.getInt("Perks.ResistantSword.cost"));
		if(config.getBoolean("Perks.ResistantUnarmed.enabled"))
			setMeta(ResistantUnarmed,	config.getString("Perks.ResistantUnarmed.name"), 		config.getList("Perks.ResistantUnarmed.lore"), config.getInt("Perks.ResistantUnarmed.cost"));
		
		//Weapon Inept
		if(config.getBoolean("Perks.IneptArchery.enabled"))
			setMeta(IneptArchery,		config.getString("Perks.IneptArchery.name"), 			config.getList("Perks.IneptArchery.lore"), config.getInt("Perks.IneptArchery.cost"));
		if(config.getBoolean("Perks.IneptAxe.enabled"))
			setMeta(IneptAxe,			config.getString("Perks.IneptAxe.name"), 				config.getList("Perks.IneptAxe.lore"), config.getInt("Perks.IneptAxe.cost"));
		if(config.getBoolean("Perks.IneptSword.enabled"))
			setMeta(IneptSword,			config.getString("Perks.IneptSword.name"), 				config.getList("Perks.IneptSword.lore"), config.getInt("Perks.IneptSword.cost"));
		if(config.getBoolean("Perks.IneptUnarmed.enabled"))
			setMeta(IneptUnarmed,		config.getString("Perks.IneptUnarmed.name"), 			config.getList("Perks.IneptUnarmed.lore"), config.getInt("Perks.IneptUnarmed.cost"));
		
		//Weapon Vulnerable
		if(config.getBoolean("Perks.VulnerableArchery.enabled"))
			setMeta(VulnerableArchery,	config.getString("Perks.VulnerableArchery.name"), 		config.getList("Perks.VulnerableArchery.lore"), config.getInt("Perks.VulnerableArchery.cost"));
		if(config.getBoolean("Perks.VulnerableAxe.enabled"))
			setMeta(VulnerableAxe,		config.getString("Perks.VulnerableAxe.name"), 			config.getList("Perks.VulnerableAxe.lore"), config.getInt("Perks.VulnerableAxe.cost"));
		if(config.getBoolean("Perks.VulnerableSword.enabled"))
			setMeta(VulnerableSword,	config.getString("Perks.VulnerableSword.name"),			config.getList("Perks.VulnerableSword.lore"), config.getInt("Perks.VulnerableSword.cost"));
		if(config.getBoolean("Perks.VulnerableUnarmed.enabled"))
			setMeta(VulnerableUnarmed,	config.getString("Perks.VulnerableUnarmed.name"),		config.getList("Perks.VulnerableUnarmed.lore"), config.getInt("Perks.VulnerableUnarmed.cost"));
		
		//Misc
		if(config.getBoolean("Perks.Holy.enabled"))
			setMeta(Holy,				config.getString("Perks.Holy.name"),					config.getList("Perks.Holy.lore"), config.getInt("Perks.Holy.cost"));
		if(config.getBoolean("Perks.Unholy.enabled"))
			setMeta(Unholy,				config.getString("Perks.Unholy.name"), 					config.getList("Perks.Unholy.lore"), config.getInt("Perks.Unholy.cost"));
		if(config.getBoolean("Perks.SnowBallThrower.enabled"))
			setMeta(SnowBallThrower,	config.getString("Perks.SnowBallThrower.name"), 		config.getList("Perks.SnowBallThrower.lore"), config.getInt("Perks.SnowBallThrower.cost"));
		if(config.getBoolean("Perks.Informed.enabled"))
			setMeta(Informed, 			config.getString("Perks.Informed.name"), 				config.getList("Perks.Informed.lore"), config.getInt("Perks.Informed.cost"));
		
		
		//Immunity
		if(config.getBoolean("Perks.ImmuneArmorpen.enabled"))
			setMeta(ImmuneArmorpen,		config.getString("Perks.ImmuneArmorpen.name"), 			config.getList("Perks.ImmuneArmorpen.lore"), config.getInt("Perks.ImmuneArmorpen.cost"));
		if(config.getBoolean("Perks.ImmuneHarm.enabled"))
			setMeta(ImmuneHarm,			config.getString("Perks.ImmuneHarm.name"), 				config.getList("Perks.ImmuneHarm.lore"), config.getInt("Perks.ImmuneHarm.cost"));
		if(config.getBoolean("Perks.ImmuneHunger.enabled"))
			setMeta(ImmuneHunger,		config.getString("Perks.ImmuneHunger.name"),			config.getList("Perks.ImmuneHunger.lore"), config.getInt("Perks.ImmuneHunger.cost"));
		if(config.getBoolean("Perks.ImmuneNausea.enabled"))
			setMeta(ImmuneNausea,		config.getString("Perks.ImmuneNausea.name"), 			config.getList("Perks.ImmuneNausea.lore"), config.getInt("Perks.ImmuneNausea.cost"));
		if(config.getBoolean("Perks.ImmuneStarve.enabled"))
			setMeta(ImmuneStarve,		config.getString("Perks.ImmuneStarve.name"), 			config.getList("Perks.ImmuneStarve.lore"), config.getInt("Perks.ImmuneStarve.cost"));
		if(config.getBoolean("Perks.ImmuneFall.enabled"))
			setMeta(ImmuneFall,			config.getString("Perks.ImmuneFall.name"), 				config.getList("Perks.ImmuneFall.lore"), config.getInt("Perks.ImmuneFall.cost"));
		//setMeta(ImmuneSteal,"Immune Steal",Arrays.asList("Immune to StealStrike", "and StealRevenge."), config.getInt("Perks.Help.cost"));
		if(config.getBoolean("Perks.ImmuneWeakness.enabled"))
			setMeta(ImmuneWeakness,		config.getString("Perks.ImmuneWeakness.name"),			config.getList("Perks.ImmuneWeakness.lore"), config.getInt("Perks.ImmuneWeakness.cost"));
		if(config.getBoolean("Perks.ImmuneWither.enabled"))
			setMeta(ImmuneWither,		config.getString("Perks.ImmuneWither.name"), 			config.getList("Perks.ImmuneWither.lore"), config.getInt("Perks.ImmuneWither.cost"));
		if(config.getBoolean("Perks.ImmuneFire.enabled"))
			setMeta(ImmuneFire,			config.getString("Perks.ImmuneFire.name"), 				config.getList("Perks.ImmuneFire.lore"), config.getInt("Perks.ImmuneFire.cost"));
		if(config.getBoolean("Perks.ImmunePoison.enabled"))
			setMeta(ImmunePoison,		config.getString("Perks.ImmunePoison.name"), 			config.getList("Perks.ImmunePoison.lore"), config.getInt("Perks.ImmunePoison.cost"));
		if(config.getBoolean("Perks.ImmuneBlindness.enabled"))
			setMeta(ImmuneBlindness,	config.getString("Perks.ImmuneBlindness.name"), 		config.getList("Perks.ImmuneBlindness.lore"), config.getInt("Perks.ImmuneBlindness.cost"));
		if(config.getBoolean("Perks.ImmuneSlow.enabled"))
			setMeta(ImmuneSlow,			config.getString("Perks.ImmuneSlow.name"), 				config.getList("Perks.ImmuneSlow.lore"), config.getInt("Perks.ImmuneSlow.cost"));
		
		//Fly
		if(config.getBoolean("Perks.FlyWater.enabled"))
			setMeta(FlyWater,			config.getString("Perks.FlyWater.name"), 				config.getList("Perks.FlyWater.lore"), config.getInt("Perks.FlyWater.cost"));
		if(config.getBoolean("Perks.FlyLava.enabled"))
			setMeta(FlyLava,			config.getString("Perks.FlyLava.name"), 				config.getList("Perks.FlyLava.lore"), config.getInt("Perks.FlyLava.cost"));
		if(config.getBoolean("Perks.FlyWeb.enabled"))
			setMeta(FlyWeb,				config.getString("Perks.FlyWeb.name"), 					config.getList("Perks.FlyWeb.lore"), config.getInt("Perks.FlyWeb.cost"));
		
		//Truce
		if(config.getBoolean("Perks.TruceSlime.enabled"))
			setSkull(config.getString("Perks.TruceSlime.playerSkull"),		TruceSlime,			config.getString("Perks.TruceSlime.name"),	config.getList("Perks.TruceSlime.lore"), config.getInt("Perks.TruceSlime.cost"));
		if(config.getBoolean("Perks.TruceBlaze.enabled"))
			setSkull(config.getString("Perks.TruceBlaze.playerSkull"),		TruceBlaze,			config.getString("Perks.TruceBlaze.name"),	config.getList("Perks.TruceBlaze.lore"), config.getInt("Perks.TruceBlaze.cost"));
		if(config.getBoolean("Perks.TruceSilverFish.enabled"))
			setSkull(config.getString("Perks.TruceSilverFish.playerSkull"),		TruceSilverFish,config.getString("Perks.TruceSilverFish.name"),	config.getList("Perks.TruceSilverFish.lore"), config.getInt("Perks.TruceSilverFish.cost"));
		if(config.getBoolean("Perks.TruceSpider.enabled"))
			setSkull(config.getString("Perks.TruceSpider.playerSkull"),		TruceSpider,		config.getString("Perks.TruceSpider.name"),	config.getList("Perks.TruceSpider.lore"), config.getInt("Perks.TruceSpider.cost"));
		if(config.getBoolean("Perks.TruceUndead.enabled"))
			setSkull(config.getString("Perks.TruceUndead.playerSkull"),		TruceUndead,		config.getString("Perks.TruceUndead.name"),	config.getList("Perks.TruceUndead.lore"), config.getInt("Perks.TruceUndead.cost"));
		if(config.getBoolean("Perks.TruceCreeper.enabled"))
			setSkull(config.getString("Perks.TruceCreeper.playerSkull"),		TruceCreeper,	config.getString("Perks.TruceCreeper.name"),	config.getList("Perks.TruceCreeper.lore"), config.getInt("Perks.TruceCreeper.cost"));
		if(config.getBoolean("Perks.TruceGhast.enabled"))
			setSkull(config.getString("Perks.TruceGhast.playerSkull"),		TruceGhast,			config.getString("Perks.TruceGhast.name"),	config.getList("Perks.TruceGhast.lore"), config.getInt("Perks.TruceGhast.cost"));
		if(config.getBoolean("Perks.TruceWitch.enabled"))
			setSkull(config.getString("Perks.TruceWitch.playerSkull"),		TruceWitch,			config.getString("Perks.TruceWitch.name"),	config.getList("Perks.TruceWitch.lore"), config.getInt("Perks.TruceWitch.cost"));
		
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
		//if(config.getBoolean("Perks.Help1.enabled"))
		if(cost!=MainPlugin.config.getInt("MenuItemCost")){
			List<String> completeList = new ArrayList<String>();
			completeList.addAll(lore);
			completeList.add("Costs: "+cost+" to equip");
			itemMeta.setLore(completeList);
		}else{
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
