package sirlich.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

import de.tr7zw.itemnbtapi.NBTItem;
import sirlich.weapons.WeaponHandler;

public class HandleWeaponAttacks implements Listener {
	@EventHandler
	public void onEntityDamage(EntityDamageEvent event) {
		if (event instanceof EntityDamageByEntityEvent) {
			EntityDamageByEntityEvent e = (EntityDamageByEntityEvent) event;

			// This should eventualy handle any dmg going to the player
			if (e.getEntity() instanceof Player) {
				Player p = (Player) e.getEntity();
				if (p.getHealth() < 10) {
					p.getInventory().setHelmet(new ItemStack(Material.PUMPKIN));
				}
			}
			/**
			 * Most code should go in here. This handles a player attaking a
			 * mob.
			 **/
			if (e.getDamager() instanceof Player) {
				Player player = (Player) e.getDamager();
				NBTItem wep = new NBTItem(player.getInventory().getItemInMainHand());

				/**
				 * Check if the item is a Weapon.
				 **/
				if (wep.hasKey("sword")) {
					WeaponHandler.handleSwordAttack(player,e.getEntity(),wep,e);
				}
				else if (wep.hasKey("staff")) {
					WeaponHandler.handleWandAttack(player, e.getEntity(), wep, e);
				}
				else if (wep.hasKey("wand")) {

				}
				else if (wep.hasKey("axe")) {

				} 
				else {
					event.setCancelled(true);
				}
			}
		}
	}
}
