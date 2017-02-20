package sirlich.weapons;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class WeaponUtil {
	
	public static String getName(String name, String type){
		
		return null;
		
	}
	/**
	 *	This function takes string input, and returns an item stack of the correct type.
	 *  NOTE: If the function returns a REDSTONE_BLOCK, this is a code meaning "Bad input"
	**/
	public static ItemStack getItemStack(String type, String name){
		Map <String, ItemStack> m = new HashMap<String, ItemStack>();
		String s = type.toLowerCase() + name.toLowerCase();
		//Handles the return of all wooden items
		m.put("woodsword", new ItemStack(Material.ANVIL));
		m.put("woodaxe", new ItemStack(Material.ANVIL));
		m.put("woodbow", new ItemStack(Material.ANVIL));
		
		//Handles the return of all iron items
		m.put("ironsword", new ItemStack(Material.ANVIL));
		m.put("ironaxe", new ItemStack(Material.ANVIL));
		m.put("ironbow", new ItemStack(Material.ANVIL));
		
		//Handles the return of all gold items
		m.put("diamondsword", new ItemStack(Material.ANVIL));
		m.put("diamondaxe", new ItemStack(Material.ANVIL));
		m.put("diamondbow", new ItemStack(Material.ANVIL));
		
		//Handles the return of all diamond items
		m.put("diamondsword", new ItemStack(Material.ANVIL));
		m.put("diamondaxe", new ItemStack(Material.ANVIL));
		m.put("diamondbow", new ItemStack(Material.ANVIL));
		
		//Handles the return of all obsidian items
		m.put("obsidiansword", new ItemStack(Material.ANVIL));
		m.put("obsidianaxe", new ItemStack(Material.ANVIL));
		m.put("obsidianbow", new ItemStack(Material.ANVIL));
		
		return m.get(s);
	}
	/**
	 * This mess right here is what creates and returns the requested weapon.
	 * Usage: WeaponUtils.create();
	**/
	
	/**
	 * Note to myself: Weapons should have:
	 * Name
	 * Tier
	 * Variation (this will set the level, which is found by: tier x 10 + (Ranfom(-Variation,Variation))
	 * Damage (Possibly set by the level? This could be an overridet to that possibly.
	 * 
	**/
	public static ItemStack create(String name, String item){
        ItemStack sword = getItemStack(item, item);
        ItemMeta swordMeta = sword.getItemMeta();
        swordMeta.setDisplayName(name);
 
        //swordMeta.setLore(Arrays.asList("line1", "line2", "line3"));
        sword.setItemMeta(swordMeta);
        return sword;
	}
}
