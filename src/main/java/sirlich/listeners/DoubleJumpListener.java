package sirlich.listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.util.Vector;

import sirlich.core.AsmodeusRPG;

public class DoubleJumpListener implements Listener{
	@EventHandler
	public void onFlightToggle(PlayerToggleFlightEvent event){
		Player p = (Player) event.getPlayer();
		p.sendMessage("Trying to jump!");
		if(p.getGameMode() != GameMode.CREATIVE){
			p.sendMessage("He jumped!");
			p.setVelocity(new Vector(p.getLocation().getDirection().getX()*1.5,1,p.getLocation().getDirection().getZ()*1.5));
			p.setFlying(false);
			p.setAllowFlight(false);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(AsmodeusRPG.instance(), new Runnable() {
	            public void run() {
	            	p.setAllowFlight(true);
	            	p.setFlying(false);
	            	p.sendMessage("You can jump again!");
	            }
	        }, 100);
		}
	}
}
