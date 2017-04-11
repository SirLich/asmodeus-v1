package sirlich.handlers;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;

import de.tr7zw.itemnbtapi.NBTItem;
import net.md_5.bungee.api.ChatColor;
import sirlich.core.PlayerList;

public class ArtifactHandler implements Listener{
	/**
	 * This class is for handling players equiping Artifacts. Essentialy either the item is an Artifact, or it isnt. 
	 * Handle actions accordingly.
	 * NOTE: offhandhand and mainhand are swapped. i.e. if you want to know what was in main hand use offhand. 
	**/
	@EventHandler
	public boolean onArtifactEquip(PlayerSwapHandItemsEvent event){
		ItemStack item = event.getOffHandItem();
		Player p = (Player) event.getPlayer();
		NBTItem item2 = new NBTItem(item);
		if(item2.hasKey("artifact")){
			p.sendMessage("You equiped: " + ChatColor.DARK_AQUA + item2.getName());
		}else{
			PlayerList.getPlayer(p).getSwitchHandAbility().run();
			event.setCancelled(true);
		}
		return false;
	}
}
