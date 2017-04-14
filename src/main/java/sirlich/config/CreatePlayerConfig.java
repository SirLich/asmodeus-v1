package sirlich.config;

import java.io.File;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import sirlich.core.AsmodeusRPG;
import sirlich.messaging.MessageUtils;

public class CreatePlayerConfig implements Listener{
	@EventHandler
	public void playerJoinEvent(PlayerJoinEvent event){
		MessageUtils.infoMessage(event.getPlayer(),"A new player joined!");
		File file = new File(AsmodeusRPG.instance().getDataFolder().getPath() + "/players",
				event.getPlayer().getUniqueId().toString());
		if(!file.exists()){
			MessageUtils.warningMessage(event.getPlayer(), "Player config not found: creating");
			file.getParentFile().mkdirs();
            AsmodeusRPG.instance().saveResource("special.yml", false);
		}
	}
}
