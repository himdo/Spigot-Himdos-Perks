package com.himdo.perks.Events;
public class Event_InventoryInteract{
	
}
/*import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Event_InventoryInteract implements Listener{
	private ItemStack goldAxe,purpleGlass,playerSkull;
	Boolean debug=false;
	@EventHandler
	public void onInventoryClicker(InventoryClickEvent e){
		
		//if the menu is not the correct menu like if a normal chest is opened
		if(!e.getInventory().getName().equals(inv.getName())) {
			return;
		}
		
		Player pa = (Player) e.getWhoClicked();
		//if the inventory open is called "menu"
		if(pa.getOpenInventory().getTitle().equals(inv.getName())){
			
			if(debug)
				pa.sendMessage("clicked");
			
			if(debug){
				pa.sendMessage(e.getCurrentItem()+"");
				pa.sendMessage(goldAxe+"");
			}
			if(e.getCurrentItem().equals(goldAxe)){
				if(debug)
					pa.sendMessage("you clicked it");
				pa.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,Integer.MAX_VALUE,0));
				
			}
		}
	}
	
	@EventHandler
	public void InventoryClickEvent(InventoryClickEvent e){
		Player pa = (Player) e.getWhoClicked();
		if(debug)
			pa.sendMessage(pa.getOpenInventory().getTitle()+"");
		if(pa.getOpenInventory().getTitle().equals(inv.getName())){
			if(debug)
				pa.sendMessage("Canceled");
			e.setCancelled(true);
		}
	}
}*/
