package com.himdo.perks.Events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class SignEvents implements Listener{

	@EventHandler
	public void signPlace(SignChangeEvent e){
		if(e.getLine(0).contains("[perks]")){
			e.setLine(0, ChatColor.GREEN+"[perks]");
		}
		if(e.getLine(0).contains("[Perks]")){
			e.setLine(0, ChatColor.GREEN+"[Perks]");
		}
	}
	
	@EventHandler
	public void signInteract(PlayerInteractEvent e){
		if(e.getAction()==Action.RIGHT_CLICK_BLOCK){
			Block block = e.getClickedBlock();
			if(block.getType()==Material.SIGN||block.getType()==Material.SIGN_POST||block.getType()==Material.WALL_SIGN){
				Sign sign = (Sign) e.getClickedBlock().getState();
				if(sign.getLine(0).contains("[perks]")||sign.getLine(0).contains("[Perks]")){
					e.getPlayer().sendMessage("Clicked");
					
					
				}
			}
		}
	}
}
