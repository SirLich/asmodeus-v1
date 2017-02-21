package sirlich.weapons;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_11_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.tr7zw.itemnbtapi.NBTItem;
import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_11_R1.NBTTagCompound;
import net.minecraft.server.v1_11_R1.NBTTagFloat;
import net.minecraft.server.v1_11_R1.NBTTagInt;
import net.minecraft.server.v1_11_R1.NBTTagList;
import net.minecraft.server.v1_11_R1.NBTTagString;

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
	 * Currently null, this method will eventualy be used to set the attack speed for weapons.
	**/
	private static ItemStack setAttackSpeed(ItemStack item, float speed){
		//ItemStack item = new ItemStack(material.DIAMOND_SWORD, 1); //Creating new item.
		net.minecraft.server.v1_11_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
		NBTTagCompound compound = (nmsStack.hasTag()) ? nmsStack.getTag() : new NBTTagCompound();
		NBTTagList modifiers = new NBTTagList();
		NBTTagCompound attackSpeed = new NBTTagCompound();
		attackSpeed.set("AttributeName", new NBTTagString("generic.attackSpeed"));
		attackSpeed.set("Name", new NBTTagString("generic.attackDamage"));
		attackSpeed.set("Amount", new NBTTagFloat(speed));
		attackSpeed.set("Operation", new NBTTagInt(0));
		attackSpeed.set("UUIDLeast", new NBTTagInt(894654));
		attackSpeed.set("UUIDMost", new NBTTagInt(2872));
		attackSpeed.set("Slot", new NBTTagString("mainhand"));
		modifiers.add(attackSpeed);
		compound.set("AttributeModifiers", modifiers);
		nmsStack.setTag(compound);
		item = CraftItemStack.asBukkitCopy(nmsStack);
		return item;
	}
	/**
	 * Currently null, this method should eventualy return a custom name given the tier and type. 
	**/
	@SuppressWarnings("unused")
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
	public static ItemStack create(String material, String type,float attackSpeed){
        ItemStack weaponItem = getItemStack(material, type);
        ItemMeta weaponMeta = weaponItem.getItemMeta();
        weaponMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        String name = ChatColor.AQUA + material + " " + type +  " of Wind!";
        weaponMeta.setDisplayName(name);
        weaponMeta.setLore(Arrays.asList("Some meta", "Two lines", "3 Lines!"));
        weaponItem.setItemMeta(weaponMeta);
        NBTItem weaponNBT = new NBTItem(weaponItem);
        weaponNBT.setInteger("Damage", 10);
        weaponNBT.setString("Message", "You hit me!");
        weaponItem = weaponNBT.getItem();
        weaponItem = setAttackSpeed(weaponItem, attackSpeed);
        
        return weaponItem;
	}
}
