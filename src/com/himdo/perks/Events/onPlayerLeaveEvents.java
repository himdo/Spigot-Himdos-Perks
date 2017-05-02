package com.himdo.perks.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.himdo.perks.Constants;
import com.himdo.perks.MainPlugin;
import com.himdo.perks.Menus.PlayerMenu;
import com.himdo.perks.Menus.TraitsMenuMain;

public class onPlayerLeaveEvents implements Listener{
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent e){
		//removes players info when they leave the server
		MainPlugin.playerPerks.remove(e.getPlayer());
		Constants.canFly.remove(e.getPlayer().getName());
		if(TraitsMenuMain.playerInventory.containsKey(e.getPlayer().getName()))
			TraitsMenuMain.playerInventory.remove(e.getPlayer().getName());
		if(PlayerMenu.playerInventory.containsKey(e.getPlayer().getName()))
			PlayerMenu.playerInventory.remove(e.getPlayer().getName());
	}
}
