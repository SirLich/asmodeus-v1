package sirlich.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;

public class CancelExpPickupListener implements Listener{
	@EventHandler
	public void PlayerExpChangeEvent(PlayerExpChangeEvent event){
		event.setAmount(0);
	} 
}
