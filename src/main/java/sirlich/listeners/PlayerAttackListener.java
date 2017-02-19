package sirlich.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerAttackListener implements Listener{
	@EventHandler
	public void onEntityDamage(EntityDamageEvent event ){
		if(event.getCause().equals("PROJECTILE")){
			System.out.println("Shots fired!");
		}
	}
}
