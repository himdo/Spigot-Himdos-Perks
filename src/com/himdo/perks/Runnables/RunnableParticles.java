package com.himdo.perks.Runnables;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Particle;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.himdo.perks.MainPlugin;

import net.minecraft.server.v1_11_R1.BlockPosition;
import net.minecraft.server.v1_11_R1.Entity;
import net.minecraft.server.v1_11_R1.EnumParticle;
import net.minecraft.server.v1_11_R1.PacketPlayOutWorldEvent;
import net.minecraft.server.v1_11_R1.PacketPlayOutWorldParticles;

public class RunnableParticles extends BukkitRunnable{
	@Override
	public void run() {
		for(Player p : Bukkit.getOnlinePlayers()){
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.Holy.name"))){
				Random random = new Random();
				float max = .5f;
				float min = -.5f;
				float x = random.nextFloat()*(max-min)+max;
				float y = random.nextFloat()*(max-min)+max;
				float z = random.nextFloat()*(max-min)+max;
				PacketPlayOutWorldParticles packetParticles = 
						new PacketPlayOutWorldParticles(EnumParticle.CRIT, true, 
								(float)p.getLocation().getX()+x-1, (float)p.getLocation().getY()+y-.5f,
						(float)p.getLocation().getZ()+z-1, 0, 0, 0, 0, 1, 1);
				((CraftPlayer)p).getHandle().playerConnection.sendPacket(packetParticles);
			}
			if(MainPlugin.playerPerks.get(p).contains(MainPlugin.config.getString("Perks.Unholy.name"))){
				Random random = new Random();
				float max = .5f;
				float min = -.5f;
				float x = random.nextFloat()*(max-min)+max;
				float y = random.nextFloat()*(max-min)+max;
				float z = random.nextFloat()*(max-min)+max;
				
				PacketPlayOutWorldParticles packetParticles = 
						new PacketPlayOutWorldParticles(EnumParticle.SMOKE_NORMAL, true, 
								(float)p.getLocation().getX()+x-1, (float)p.getLocation().getY()+y-1,
						(float)p.getLocation().getZ()+z-1, 0, 0, 0, 0, 10, 1);
				
				((CraftPlayer)p).getHandle().playerConnection.sendPacket(packetParticles);
			}
			
			
			/*;*/
			
			
		}
	}
}
