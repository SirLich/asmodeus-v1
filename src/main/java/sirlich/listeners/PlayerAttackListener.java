package sirlich.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerAttackListener implements Listener{
	
	@EventHandler //Catches all damage, but only handles entity on entity
	public void onEntityDamage(EntityDamageEvent e){
		if(e instanceof EntityDamageByEntityEvent){
			EntityDamageByEntityEvent event = (EntityDamageByEntityEvent) e;
			 
            if(event.getDamager() instanceof Player){
            	Player player = (Player) event.getDamager();
            	if(player.getInventory().getItemInMainHand().getType().equals(Material.STICK)){
            		e.setDamage((double)100);
            	}
            }
		}
	}
}
            
