package sirlich.weapons;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SwordWeapon {
	public static ItemStack create(String name){
        ItemStack sword = new ItemStack(Material.GHAST_TEAR, 1);
        ItemMeta swordMeta = sword.getItemMeta();
        swordMeta.setDisplayName(name);
 
        //swordMeta.setLore(Arrays.asList("line1", "line2", "line3"));
        sword.setItemMeta(swordMeta);
        return sword;
	}
}
