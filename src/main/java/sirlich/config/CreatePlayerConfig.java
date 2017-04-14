package sirlich.config;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import sirlich.messaging.MessageUtils;

public class CreatePlayerConfig implements Listener{
	@EventHandler
	public void playerJoinEvent(PlayerJoinEvent event){
		MessageUtils.infoMessage(event.getPlayer(),"A new player joined!");
	}
}
