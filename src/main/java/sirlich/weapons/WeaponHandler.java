package sirlich.weapons;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import de.tr7zw.itemnbtapi.NBTItem;

/**
 * This is going to be one of the few non-temp classes written so far.
 * This class should cleanly handle all forms of damage coming from our custom weapons. 
 * There will be a number of placeholders for the moment.
**/
public class WeaponHandler {
	/* Placeholder class. Will eventualy handle sword swings*/
	public static void handleSwordAttack(Player p, Entity entity, NBTItem wep, Event e){
		
	}
	/* Placeholder class. Will eventualy handle wand direct attacks (not spells) */
	public static void handleWandAttack(Player p, Entity entity, NBTItem wep, EntityDamageByEntityEvent e){
		e.setCancelled(true);
	}
	/* Placeholder class. Will eventualy handle axe direct attacks (not axe throw etc) */
	public static void handleAxeAttack(Player p, Entity entity, NBTItem wep, EntityDamageByEntityEvent e){
		e.setCancelled(true);
	}
	/* Placeholder class. Will eventualy handle bow direct attacks (not arrows) */
	public static void handleBowAttack(Player p, Entity entity, NBTItem wep, EntityDamageByEntityEvent e){
		e.setCancelled(true);
	}
}
