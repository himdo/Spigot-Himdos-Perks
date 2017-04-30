package com.himdo.perks.hashMaps;

import java.util.ArrayList;

import org.bukkit.Material;

public class WeaponArrayLists {
	public static ArrayList<Material> Axes = new ArrayList<Material>();
	public static ArrayList<Material> Swords = new ArrayList<Material>();
	public static ArrayList<Material> Shovel = new ArrayList<Material>();
	public static ArrayList<Material> PickAxe = new ArrayList<Material>();
	public static ArrayList<Material> Hoe = new ArrayList<Material>();
	
	public static ArrayList<Material> Wood = new ArrayList<Material>();
	public static ArrayList<Material> Stone = new ArrayList<Material>();
	public static ArrayList<Material> Iron = new ArrayList<Material>();
	public static ArrayList<Material> Gold = new ArrayList<Material>();
	public static ArrayList<Material> Diamond = new ArrayList<Material>();
	
	
	
	public static void init(){
		Axes.add(Material.DIAMOND_AXE);
		Axes.add(Material.GOLD_AXE);
		Axes.add(Material.IRON_AXE);
		Axes.add(Material.STONE_AXE);
		Axes.add(Material.WOOD_AXE);

		Swords.add(Material.DIAMOND_SWORD);
		Swords.add(Material.GOLD_SWORD);
		Swords.add(Material.IRON_SWORD);
		Swords.add(Material.STONE_SWORD);
		Swords.add(Material.WOOD_SWORD);

		Shovel.add(Material.DIAMOND_SPADE);
		Shovel.add(Material.GOLD_SPADE);
		Shovel.add(Material.IRON_SPADE);
		Shovel.add(Material.STONE_SPADE);
		Shovel.add(Material.WOOD_SPADE);

		PickAxe.add(Material.DIAMOND_SWORD);
		PickAxe.add(Material.GOLD_SWORD);
		PickAxe.add(Material.IRON_SWORD);
		PickAxe.add(Material.STONE_SWORD);
		PickAxe.add(Material.WOOD_SWORD);

		Hoe.add(Material.DIAMOND_HOE);
		Hoe.add(Material.GOLD_HOE);
		Hoe.add(Material.IRON_HOE);
		Hoe.add(Material.STONE_HOE);
		Hoe.add(Material.WOOD_HOE);

		Wood.add(Material.WOOD_AXE);
		Wood.add(Material.WOOD_SWORD);
		Wood.add(Material.WOOD_SPADE);
		Wood.add(Material.WOOD_SWORD);
		Wood.add(Material.WOOD_HOE);
		
		
	}
	
}
