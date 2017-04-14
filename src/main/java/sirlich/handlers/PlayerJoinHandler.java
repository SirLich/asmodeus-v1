package sirlich.handlers;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import sirlich.core.PlayerList;

public class PlayerJoinHandler implements Listener{
	@EventHandler
	public void playerJoinEvent(PlayerJoinEvent event){
		PlayerList.addPlayer(event.getPlayer());
		StaminaHandler.addPlayer((Player) event.getPlayer());
		event.getPlayer().setExp(1.0f);
		event.getPlayer().setGameMode(GameMode.SURVIVAL);
		event.getPlayer().setAllowFlight(true);
		//saveResource("special.yml", false);
	}
}
