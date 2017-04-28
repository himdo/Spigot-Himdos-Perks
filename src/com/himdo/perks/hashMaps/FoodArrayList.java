package com.himdo.perks.hashMaps;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class FoodArrayList {
	public static ArrayList<Material> Meat = new ArrayList<Material>();
	
	public static ArrayList<Material> MeatCooked = new ArrayList<Material>();
	public static ArrayList<Material> MeatRaw = new ArrayList<Material>();
	
	public static ArrayList<Material> Posioned = new ArrayList<Material>();
	
	public static ArrayList<Material> Veggies = new ArrayList<Material>();
	public static ArrayList<Material> Soups = new ArrayList<Material>();

	
	public static void init(){
		MeatCooked.add(Material.COOKED_BEEF);
		MeatCooked.add(Material.COOKED_CHICKEN);
		MeatCooked.add(Material.COOKED_FISH);
		MeatCooked.add(Material.COOKED_MUTTON);
		MeatCooked.add(Material.COOKED_RABBIT);
		MeatCooked.add(Material.GRILLED_PORK);
		MeatCooked.add(Material.RABBIT_STEW);

		MeatRaw.add(Material.RAW_BEEF);
		MeatRaw.add(Material.RAW_CHICKEN);
		MeatRaw.add(Material.RAW_FISH);
		MeatRaw.add(Material.RABBIT);
		MeatRaw.add(Material.PORK);
		
		Meat.addAll(MeatCooked);
		Meat.addAll(MeatRaw);

		Posioned.add(Material.POISONOUS_POTATO);
		Posioned.add(Material.ROTTEN_FLESH);
		Posioned.add(Material.SPIDER_EYE);

		Veggies.add(Material.APPLE);
		Veggies.add(Material.BREAD);
		Veggies.add(Material.BEETROOT_SOUP);
		Veggies.add(Material.MUSHROOM_SOUP);
		Veggies.add(Material.GOLDEN_APPLE);
		Veggies.add(Material.CAKE);
		Veggies.add(Material.CAKE_BLOCK);
		Veggies.add(Material.COOKIE);
		Veggies.add(Material.MELON);
		Veggies.add(Material.CARROT);
		Veggies.add(Material.GOLDEN_CARROT);
		Veggies.add(Material.POTATO);
		Veggies.add(Material.BAKED_POTATO);
		Veggies.add(Material.PUMPKIN_PIE);
		Veggies.add(Material.BEETROOT);

		Soups.add(Material.RABBIT_STEW);
		Soups.add(Material.BEETROOT_SOUP);
		Soups.add(Material.MUSHROOM_SOUP);
	}
}
