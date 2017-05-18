package sirlich.inventory;

import org.bukkit.entity.Player;

import sirlich.chat.ChatUtils;

public class INVAction {
	public void run(Player p){
		ChatUtils.chatInfo(p, "This is the default inventoryClick return");
	}
}
