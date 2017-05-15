package com.himdo.perks.Menus;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.Plugin;

import com.himdo.perks.MainPlugin;
import com.himdo.perks.Misc.CalculatePoints;
import com.himdo.perks.Misc.MenuChecker;
import com.himdo.perks.SaveAndLoading.FileLocation;
import com.himdo.perks.hashMaps.MainDataBaseHashMap;

public class ImmunePerksMenu implements Listener{
	private Inventory inv;
	//Player player;
	Plugin plugin;
	
	public ImmunePerksMenu(Plugin plugin) {
		this.plugin=plugin;
		inv = Bukkit.getServer().createInventory(null, 9*4,MainPlugin.config.getString("Menu.ImmunePerkMenu.Name"));
		Bukkit.getServer().getPluginManager().registerEvents( this, plugin);
	}
	
	public void show(Player p){
		//this.player = p;
		
		p.openInventory(inv);
		
	}
	
	

	@EventHandler
	public void onInventoryClicker(InventoryClickEvent e){
		Player player = (Player) e.getWhoClicked();
		
		if(!MenuChecker.menuChecker(e,inv))
			return;
		if(e.getCurrentItem().equals(MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.LeftArrow.name")))){
			MainPlugin.perksSubMain.show(player);
			if(MainPlugin.config.getBoolean("PlaySounds")){
				player.playSound(player.getLocation(), Sound.ITEM_HOE_TILL, 1, 1);
			}
			return;
		}
		if((CalculatePoints.getCurrentPoints(player)+CalculatePoints.getPointsForItem(e.getCurrentItem()) )>MainPlugin.config.getInt("MaximumPerkPoints")){
			player.sendMessage("Costs to many Points");
			return;
		}
		if(MainPlugin.playerPerks.get(player).size()>8){
			player.sendMessage("Too Many Perks Chosen");
			return;
		}
		
		if(MainPlugin.config.getBoolean("PlaySounds")){
			player.playSound(player.getLocation(), Sound.ENTITY_BAT_TAKEOFF, 1, 1);
		}
		if(MainPlugin.config.getBoolean("FireworkOnEquip")){
			//Spawn the Firework, get the FireworkMeta.
            Firework fw = (Firework) player.getWorld().spawnEntity(player.getLocation(), EntityType.FIREWORK);
            FireworkMeta fwm = fw.getFireworkMeta();
           
            //Our random generator
            Random r = new Random();   
 
            //Get the type
            int rt = r.nextInt(4) + 1;
            Type type = Type.BALL;       
            if (rt == 1) type = Type.BALL;
            if (rt == 2) type = Type.BALL_LARGE;
            if (rt == 3) type = Type.BURST;
            if (rt == 4) type = Type.CREEPER;
            if (rt == 5) type = Type.STAR;
               
            //Create our effect with this
            FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(Color.GREEN).withFade(Color.BLUE).with(type).trail(r.nextBoolean()).build();
           
            //Then apply the effect to the meta
            fwm.addEffect(effect);
           
            //Generate some random power and set it
            int rp = r.nextInt(2) + 1;
            fwm.setPower(rp);
           
            //Then apply this to our rocket
            fw.setFireworkMeta(fwm);  
		}
		MainPlugin.playerPerks.get(player).add(e.getCurrentItem().getItemMeta().getDisplayName());
		FileLocation.save(player);
	}
	

	@EventHandler
	public void InventoryClickEvent(InventoryClickEvent e){
		Player pa = (Player) e.getWhoClicked();
		if(pa.getOpenInventory().getTitle().equals(inv.getName())){
			e.setCancelled(true);
		}		
	}

	public void init() {

		//sets up the border
		for(int i = 0; i<9; i++){
			inv.setItem(i, MainDataBaseHashMap.items.get("Border Purple"));
			inv.setItem(9*3+i, MainDataBaseHashMap.items.get("Border Purple"));
		}
		inv.clear(9*3+1);
		inv.setItem(9*3+1, MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.LeftArrow.name")));

		inv.setItem(9,   MainDataBaseHashMap.items.get("Border Purple"));
		inv.setItem(MainPlugin.config.getInt("Perks.ImmuneArmorpen.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.ImmuneArmorpen.name")));
		inv.setItem(MainPlugin.config.getInt("Perks.ImmuneHarm.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.ImmuneHarm.name")));
		inv.setItem(MainPlugin.config.getInt("Perks.ImmuneHunger.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.ImmuneHunger.name")));
		inv.setItem(MainPlugin.config.getInt("Perks.ImmuneNausea.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.ImmuneNausea.name")));
		inv.setItem(MainPlugin.config.getInt("Perks.ImmuneStarve.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.ImmuneStarve.name")));
		inv.setItem(MainPlugin.config.getInt("Perks.ImmuneFall.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.ImmuneFall.name")));
		//inv.setItem(9+7, MainDataBaseHashMap.items.get("Immune Steal"));
		inv.setItem(9+8, MainDataBaseHashMap.items.get("Border Purple"));
		
		inv.setItem(9*2,   MainDataBaseHashMap.items.get("Border Purple"));
		inv.setItem(MainPlugin.config.getInt("Perks.ImmuneWeakness.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.ImmuneWeakness.name")));
		inv.setItem(MainPlugin.config.getInt("Perks.ImmuneWither.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.ImmuneWither.name")));
		inv.setItem(MainPlugin.config.getInt("Perks.ImmuneFire.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.ImmuneFire.name")));
		inv.setItem(MainPlugin.config.getInt("Perks.ImmunePoison.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.ImmunePoison.name")));
		inv.setItem(MainPlugin.config.getInt("Perks.ImmuneBlindness.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.ImmuneBlindness.name")));
		inv.setItem(MainPlugin.config.getInt("Perks.ImmuneSlow.inventorySlot"), MainDataBaseHashMap.items.get(MainPlugin.config.getString("Perks.ImmuneSlow.name")));
		//inv.setItem(9*2+7, initHashMap.items.get());
		inv.setItem(9*2+8, MainDataBaseHashMap.items.get("Border Purple"));
		
				
	}
}
