package sirlich.weapons;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * This class is an attempted rewrite of WeaponUtils where instead of
 * enless methods I use a ItemStack extension.
**/
public class CustomWeapon extends ItemStack{
	public CustomWeapon(){
		this.setType(Material.ANVIL);
		this.setAmount(1);
	}
	public CustomWeapon(ItemStack is){
		this.setType(is.getType());
		this.setAmount(1);
	}
}
