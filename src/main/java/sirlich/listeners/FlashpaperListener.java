package sirlich.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import sirlich.flashpaper.LeapFlashpaper;

/**
 * Simple listener to prove that our flashpaper classes are working.
**/
public class FlashpaperListener implements Listener{
	@EventHandler
	public void FlashpaperEvent(PlayerInteractEvent event){
		if(event.getItem() != null && (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) 
				&& event.getItem().getType() == Material.PAPER){
			LeapFlashpaper flashpaper = new LeapFlashpaper((Player)event.getPlayer());
			flashpaper.use();
		}
	} 
}
