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
public class HandleRPGInventory implements Listener{
	
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
	**/
	@EventHandler
    public void onItemSpawn(ItemSpawnEvent event) {
		boolean n = event.getEntity().getItemStack().getType() == Material.NETHER_STAR;
		if(n == true){
       		event.getEntity().remove();  
        }   
    }
	
	/**
	 * Planned method to cancel certain inventory events to stop players
	 * from messing with the RPG inventory.
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
	
	
	/**
	 * Currently not working class to handle the close of a players inventory.
	 * We may not need this at all.
	 * NOTE: Also contains code to handle schedulars. 
	**/
	/*
	@EventHandler
	public void onInventoryCloseEvent(InventoryCloseEvent event){
    	Player p = (Player) event.getPlayer();
		if(event.getInventory() instanceof PlayerInventory){
			p.getOpenInventory().setItem(80, new ItemStack(Material.AIR));
			p.getOpenInventory().setItem(81, new ItemStack(Material.AIR));
			p.getOpenInventory().setItem(82, new ItemStack(Material.AIR));
			p.getOpenInventory().setItem(83, new ItemStack(Material.AIR));

		}
		//This will be usefull for scheduling events later on
		final ScheduledExecutorService worker = Executors.newSingleThreadScheduledExecutor();
		Runnable task = new Runnable() {
	        public void run() {
	            event.getPlayer().openInventory(event.getPlayer().getInventory());
	        }
	    };
	    worker.schedule(task, 1, TimeUnit.SECONDS);// We set the time delay here  
	}
	*/
}