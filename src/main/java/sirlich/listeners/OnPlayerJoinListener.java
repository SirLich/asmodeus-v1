package sirlich.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import sirlich.events.ManaRegenEvent;

public class OnPlayerJoinListener implements Listener{
	@EventHandler
	public void playerJoinEvent(PlayerJoinEvent event){
		ManaRegenEvent.addPlayer((Player) event.getPlayer());
	}
}
