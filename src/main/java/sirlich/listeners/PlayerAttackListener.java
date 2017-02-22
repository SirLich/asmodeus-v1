package sirlich.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import de.tr7zw.itemnbtapi.NBTItem;

/**
 * This possibly temp Listener handles the event where a player hits a mob.
 * Currently used to set damagage of custom weps and handle error message.
**/
public class PlayerAttackListener implements Listener{
	@EventHandler //Catches all damage, but only handles entity on entity
	public void onEntityDamage(EntityDamageEvent e){
		if(e instanceof EntityDamageByEntityEvent){
			EntityDamageByEntityEvent event = (EntityDamageByEntityEvent) e;
			 
            if(event.getDamager() instanceof Player){
            	Player player = (Player) event.getDamager();
            	//The line belows this might be usfull later
            	//String[] weaponList = {"DIAMOND_SWORD","DIAMOND_AXE","DIAMOND_SHOVEL"};
            	//boolean isWep = Arrays.asList(weaponList).contains(player.getInventory().getItemInMainHand().getType().name());
            	NBTItem item = new NBTItem(player.getInventory().getItemInMainHand());
            	if(item.hasKey("Damage")){
            		event.setDamage((double)item.getInteger("Damage"));
            		player.getInventory().getItemInMainHand().setDurability((short) (player.getInventory().getItemInMainHand().getDurability() - 10));
            	}
            }
		}
	}
}
            
