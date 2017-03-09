package sirlich.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class LoseHungerListener implements Listener{
	@EventHandler
	public boolean foodLevelChangeEvent(FoodLevelChangeEvent e){
		e.setCancelled(true);
		return false;
	}
}
