package sirlich.listeners;


import org.bukkit.Achievement;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
/**
 * This class handles all sorts of inventory things.
 * I plan on using the players 2x2 crafting slot as a GUI,
 * so among other things this Listener handles that. 
 * 
 * NOTE: Currently throwing an error when clicked outside of the inventory!
**/
public class RPGInventoryListener implements Listener{
	
	/**
	 * This method removes the OPEN_INVENTORY achievment. This is usefull
	 * because we will us this achievment later to get access to a player
	 * inventory event, something that is usualy client-side.
	**/
	@EventHandler
	public void onJoin(PlayerJoinEvent event){
	    event.getPlayer().removeAchievement(Achievement.OPEN_INVENTORY);
	}
	 
	/**
	 * This event makes use of the OPEN_INVENTORY achievment to gain
	 * access to an event that is usualy client side. Anything in here will run once
	 * when a player opens their inventory. This event should set the RPG inventory 
	 * in the 2x2 crafting slot.
	**/
	@EventHandler
	public void onInventoryOpenEvent(PlayerAchievementAwardedEvent event){
	    if(event.getAchievement().equals(Achievement.OPEN_INVENTORY)){
	    	Player p = (Player) event.getPlayer();
	        event.setCancelled(true);
	        p.getOpenInventory().setItem(1, new ItemStack(Material.NETHER_STAR));
	        p.getOpenInventory().setItem(2, new ItemStack(Material.NETHER_STAR));
	        p.getOpenInventory().setItem(3, new ItemStack(Material.NETHER_STAR));
	        p.getOpenInventory().setItem(4, new ItemStack(Material.NETHER_STAR));
	    }
	}
	
	/**
	 * This event handles the event of an item "dropping". I use this method
	 * to cancel the drop of certain items such as NETHER_STARS, which would
	 * otherwise spam the map.
	 * 
	 * TODO: Add the other items I need to drop.
	**/
	@EventHandler
    public void onItemSpawn(ItemSpawnEvent event) {
		boolean n = event.getEntity().getItemStack().getType() == Material.NETHER_STAR;
		boolean t = event.getEntity().getItemStack().getType() == Material.GOLD_SWORD;
		if(n){
       		event.getEntity().remove();  
        }   
		if(t){
			event.getEntity().setPickupDelay(2147483647);
			event.getEntity().setInvulnerable(true);
		}
    }
	
	/**
	 * Planned method to cancel certain inventory events to stop players
	 * from messing with the RPG inventory.
	 * 
	 * TODO: Add the other items I need to cancel.
	**/
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if(event.getCurrentItem() == null){
			return;
		}else{
			ItemStack clicked = event.getCurrentItem();
			if(clicked.getType() == Material.NETHER_STAR){ //add other special item-cases eventualy
				event.setCancelled(true);
			}
		}
	}
}