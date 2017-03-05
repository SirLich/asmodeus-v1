package sirlich.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import sirlich.handlers.StaminaHandler;

public class PlayerJoinListener implements Listener{
	@EventHandler
	public void playerJoinEvent(PlayerJoinEvent event){
		StaminaHandler.addPlayer((Player) event.getPlayer());
		event.getPlayer().setExp(1.0f);
	}
}
