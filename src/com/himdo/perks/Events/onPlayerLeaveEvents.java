package com.himdo.perks.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.himdo.perks.Constants;
import com.himdo.perks.MainPlugin;
import com.himdo.perks.Menus.PlayerMenu;
import com.himdo.perks.Menus.PerksMenuMain;

public class onPlayerLeaveEvents implements Listener{
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent e){
		//removes players info when they leave the server
		MainPlugin.playerPerks.remove(e.getPlayer());
		Constants.canFly.remove(e.getPlayer().getName());
		//if the player has his own main menu it gets deleted
		if(PerksMenuMain.playerInventory.containsKey(e.getPlayer().getName()))
			PerksMenuMain.playerInventory.remove(e.getPlayer().getName());
		//if the player has his own personal perk menu it gets deleted
		if(PlayerMenu.playerInventory.containsKey(e.getPlayer().getName()))
			PlayerMenu.playerInventory.remove(e.getPlayer().getName());
	}
}
