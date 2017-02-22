package sirlich.listeners;

import java.util.Arrays;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import de.tr7zw.itemnbtapi.NBTItem;

public class PlayerAttackListener implements Listener{
	@EventHandler //Catches all damage, but only handles entity on entity
	public void onEntityDamage(EntityDamageEvent e){
		if(e instanceof EntityDamageByEntityEvent){
			EntityDamageByEntityEvent event = (EntityDamageByEntityEvent) e;
			 
            if(event.getDamager() instanceof Player){
            	Player player = (Player) event.getDamager();
            	String[] weaponList = {"DIAMOND_SWORD","DIAMOND_AXE","DIAMOND_SHOVEL"};
            	boolean isWep = Arrays.asList(weaponList).contains(player.getInventory().getItemInMainHand().getType().name());
            	if(isWep){
            		NBTItem item = new NBTItem(player.getInventory().getItemInMainHand());
            		if(item.hasKey("Damage")){
            			event.setDamage((double)item.getInteger("Damage"));
            			player.getInventory().getItemInMainHand().setDurability((short) 500);
            		}
            		else{
            			player.sendMessage("For the love of GOD stop using that! Its going to break the code!");
            		}
            	}
            }
		}
	}
}
            
