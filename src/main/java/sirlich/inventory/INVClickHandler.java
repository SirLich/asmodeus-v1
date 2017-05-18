package sirlich.inventory;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import de.tr7zw.itemnbtapi.NBTItem;
import sirlich.chat.ChatUtils;
import sirlich.inventory.INVList;

public class INVClickHandler implements Listener{
	@EventHandler
	public void inventoryClickEvent(InventoryClickEvent event){
		Player p = (Player) event.getWhoClicked();
		if(event.getCurrentItem() != null){
			ItemStack item = event.getCurrentItem();
			if(item.getType() == Material.STONE_AXE){
				NBTItem nbtitem = new NBTItem(item);
				if(nbtitem.hasKey("action")){
					event.setCancelled(true);
					ChatUtils.chatInfo(p, "Thats a button!");
					String action = nbtitem.getString("action");
					INVList.getAction(action).run(p);
				} else{
					ChatUtils.chatError(p, "That button is not setup right!");
				}
			}
		}
	}
	
}
