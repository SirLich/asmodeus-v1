package sirlich.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;
/**
 * Simple listener to handle players picking up orbs. Players can no longer gain Exp from killing mobs etc.
**/
public class CancelExpPickupListener implements Listener{
	@EventHandler
	public void PlayerExpChangeEvent(PlayerExpChangeEvent event){
		event.setAmount(0);
	} 
}
