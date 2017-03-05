package sirlich.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

/**
 * This class handles the player attempting to switch into and out of their second hand.
 * Generally speaking, we don't want to player to use their second hand,
 * so we cancel the event.
**/
public class SwitchHandListener implements Listener{
	@EventHandler
	public boolean PlayerSwapHandItemsEvent(PlayerSwapHandItemsEvent event){
		event.getPlayer().sendMessage("Yesp!");
		event.setCancelled(true);
		return false;
	}
}
