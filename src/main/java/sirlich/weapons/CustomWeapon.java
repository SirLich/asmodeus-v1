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
import net.minecraft.server.v1_11_R1.NBTTagByte;
import net.minecraft.server.v1_11_R1.NBTTagCompound;
import net.minecraft.server.v1_11_R1.NBTTagFloat;
import net.minecraft.server.v1_11_R1.NBTTagInt;
import net.minecraft.server.v1_11_R1.NBTTagList;
import net.minecraft.server.v1_11_R1.NBTTagString;

/**
 * This class is an attempted rewrite of WeaponUtils where instead of
 * enless methods I use a ItemStack extension. I failed :/
**/
public class CustomWeapon{	
	/**
	 * This method is one of many ways of calling createWeapon.
	 * CreateWeapon
	**/
	public static ItemStack createWeapon(){
		ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
		int level = 100;
		String name = ChatColor.AQUA + "Classic wand";
		float attackDamage = level/2;
		float attackSpeed = 16f;
		int weaponDamage = setDmgValue("classic_wand");
		int weaponDurability = (int) level/10;
		boolean broken = false;
		return makeWeapon(item, name, level, attackDamage, attackSpeed, weaponDurability, weaponDamage, broken);
	}
	public static ItemStack createWeapon(String type, int level){
		ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
		String name = setName(type);
		float attackDamage = level/2;
		float attackSpeed = 16f;
		int weaponDamage = setDmgValue(type);
		int weaponDurability = (int) level/10;
		boolean broken = false;
		return makeWeapon(item, name, level, attackDamage, attackSpeed, weaponDurability, weaponDamage, broken);
	}
	
	public static int setDmgValue(String name){
		Map <String, Integer> m = new HashMap<String, Integer>();
		m.put("classic_wand", 1);
		return m.get(name);	
	}
	
	private static String setName(String name){
		Map <String, String> m = new HashMap<String, String>();
		m.put("classic_wand", "Classic wand");
		return m.get(name);	
	}
	
	/**
	 * The "Guts". This gets called from the constructors.
	**/
	private static ItemStack makeWeapon(ItemStack item, 
			String name, 
			int level,
			float attackDamage, 
			float attackSpeed , 
			int weaponDurability, 
			int weaponDamage,
			boolean broken){
		
    	//Set NBT values for the sword
        NBTItem nbtitem = new NBTItem(item);
        nbtitem.setDouble("damage", attackDamage);
        nbtitem.setInteger("level", level); 
        nbtitem.setInteger("maxDurability", weaponDurability);
        nbtitem.setInteger("durability", weaponDurability);
        nbtitem.setBoolean("broken", broken);
        item = nbtitem.getItem();
        item = setExtraNBT(item, attackSpeed);
        
        //Set META values for the weapon.
        ItemMeta weaponMeta = item.getItemMeta();
        weaponMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        weaponMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        weaponMeta.setDisplayName(name);
        weaponMeta.setLore(Arrays.asList(ChatColor.GOLD + "Level " +level+ " " + name,
        		ChatColor.GOLD + "Damage: " + attackDamage,
        		ChatColor.GOLD + "Speed: " + attackSpeed));
        
        item.setItemMeta(weaponMeta);
        return item;
	}
	
	private static ItemStack setExtraNBT(ItemStack item, float speed){
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
		compound.set("Unbreakable", new NBTTagByte((byte) 1));
		nmsStack.setTag(compound);
		return(CraftItemStack.asBukkitCopy(nmsStack));
	}
}
