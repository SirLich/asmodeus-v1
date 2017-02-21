package sirlich.weapons;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_11_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.minecraft.server.v1_11_R1.NBTTagCompound;
import net.minecraft.server.v1_11_R1.NBTTagList;

/**
 * Note to myself: Weapons should have:
 * Name
 * Tier
 * Variation (this will set the level, which is found by: tier x 10 + (Ranfom(-Variation,Variation))
 * Damage (Possibly set by the level? This could be an overridet to that possibly.
 * 
**/

/**
 * This class is the utilities class for Weapons. It should have methods like rename, create, and other such things. 
**/
public class WeaponUtil {
	/**
	 * Currently null, this method should eventualy return a custom name given the tier and type. 
	**/
	private static String getName(String name, String type){
		
		return null;
		
	}
	/**
	 *	This function takes string input, and returns an item stack of the correct type.
	 *  NOTE: If the function returns a REDSTONE_BLOCK, this is a code meaning "Bad input"
	**/
	private static ItemStack getItemStack(String type, String name){
		Map <String, ItemStack> m = new HashMap<String, ItemStack>();
		String s = type.toLowerCase() + name.toLowerCase();
		//Handles the return of all wooden items
		m.put("woodsword", new ItemStack(Material.WOOD_SWORD));
		m.put("woodaxe", new ItemStack(Material.WOOD_AXE));
		m.put("woodbow", new ItemStack(Material.WOOD_SPADE));
		
		//Handles the return of all iron items
		m.put("ironsword", new ItemStack(Material.IRON_SWORD));
		m.put("ironaxe", new ItemStack(Material.IRON_AXE));
		m.put("ironbow", new ItemStack(Material.IRON_SPADE));
		
		
		
		//Handles the return of all gold items
		m.put("goldsword", new ItemStack(Material.GOLD_SWORD));
		m.put("goldaxe", new ItemStack(Material.GOLD_AXE));
		m.put("goldbow", new ItemStack(Material.GOLD_SPADE));
		
		//Handles the return of all diamond items
		m.put("diamondsword", new ItemStack(Material.DIAMOND_SWORD));
		m.put("diamondaxe", new ItemStack(Material.DIAMOND_AXE));
		m.put("diamondbow", new ItemStack(Material.DIAMOND_SPADE));
		
		//Handles the return of all obsidian (stone) items
		m.put("obsidiansword", new ItemStack(Material.STONE_SWORD));
		m.put("obsidianaxe", new ItemStack(Material.STONE_AXE));
		m.put("obsidianbow", new ItemStack(Material.STONE_SPADE));
		if(m.containsKey(s)){
			return m.get(s);
		}
		return new ItemStack(Material.REDSTONE_BLOCK); //else clause (bad input)
	}
	/**
	 * This mess right here is what creates and returns the requested weapon.
	 * Usage: WeaponUtils.create();
	**/
	public static ItemStack create(String material, String type){
        ItemStack weaponItem = getItemStack(material, type);
        ItemMeta weaponMeta = weaponItem.getItemMeta();
        weaponMeta.setDisplayName(material + " " + type);
        weaponMeta.setLore(Arrays.asList("Line1", "Yeah... you", "BOOd3M!"));
        weaponItem.setItemMeta(weaponMeta);
        net.minecraft.server.v1_11_R1.ItemStack weaponNMS = CraftItemStack.asNMSCopy(weaponItem);
        NBTTagCompound compound = (weaponNMS.hasTag()) ? weaponNMS.getTag() : new NBTTagCompound();
        NBTTagList modifiers = new NBTTagList();
        NBTTagCompound damage = new NBTTagCompound();
        
        return weaponItem;
	}
}
