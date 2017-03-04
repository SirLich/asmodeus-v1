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
 * NOTE: This class is no longer being developed. Please refer to CustomWeapon
 * 
 * This class was initialy going to be filled with utils, but has sort of turned into the spawner for custom weps.
 * Notes can be found at the bottom.
**/
public class WeaponUtil {
	/**
	 * This method creates a simple sword. It only takes in 2 params, tier, and level. 
	 * Everything else, such as damage, is calculated from the tier and level.   
	**/
	public static ItemStack SimpleSword(){
		return null;
	}
	
	/**
	 * This method returns a sword. It take more params than SimpleSword. 
	**/
	public static ItemStack Sword(){
		return null;
	}
	
	/**
	 * This will eventualy be used to fully custumize a sword (takes all the possible params)
	**/
	public static ItemStack CustomSword(String material, String type, int level, float dmg, float attackSpeed, String name, int durability){
		return CreateWeapon(material, type, level, dmg, attackSpeed, name, durability);
	}
	
	
	/**
	 * This method takes and returns an ItemStack. Its purpose is to set the attak speed of that Item. 
	**/
	private static ItemStack setAttackSpeed(ItemStack item, float speed){
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
		item = CraftItemStack.asBukkitCopy(nmsStack);
		return item;
	}
	
	/**
	 * This method turns a String into an ItemStack 
	**/
	private static ItemStack getItemStack(String type, String name){
		Map <String, ItemStack> m = new HashMap<String, ItemStack>();
		String s = type.toLowerCase() + name.toLowerCase();
		short itemDmg = 1;
		//Handles the return of all wooden items
		m.put("woodsword", new ItemStack(Material.WOOD_SWORD));
		m.put("woodaxe", new ItemStack(Material.WOOD_AXE));
		m.put("woodbow", new ItemStack(Material.WOOD_SPADE));
		
		//Handles the return of all iron items
		m.put("ironsword", new ItemStack(Material.IRON_SWORD));
		m.put("ironaxe", new ItemStack(Material.IRON_AXE,1,itemDmg));
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
	 * This is the class that is called by the public classes at the top.
	 * Working with the other private classes, it will eventualy return an ItemStack.
	**/
	private static ItemStack CreateWeapon(String material, String type, int level, float dmg, float attackSpeed, String name, int durability){
        ItemStack weaponItem = getItemStack(material, type);
    	//NBT
        NBTItem weaponNBT = new NBTItem(weaponItem);
        weaponNBT.setDouble("Damage", dmg);
        weaponNBT.setInteger("Level", level); 
        weaponNBT.setInteger("MaxDurability", durability);
        weaponNBT.setInteger("Durability", durability);
        weaponNBT.setBoolean("broken", false);
        weaponItem = weaponNBT.getItem();
        weaponItem = setAttackSpeed(weaponItem, attackSpeed);
        
        //META
        ItemMeta weaponMeta = weaponItem.getItemMeta();
        weaponMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        weaponMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        name = ChatColor.AQUA + material + " " + type +  " of " + name;
        weaponMeta.setDisplayName(name);
        weaponMeta.setLore(Arrays.asList(ChatColor.GOLD + "Damage: " + dmg,
        		ChatColor.GOLD + "Speed: " + attackSpeed,
        		ChatColor.GOLD + "Level: " + level));
        
        weaponItem.setItemMeta(weaponMeta);
        return weaponItem;
	}
}
/**
 * Brainstorming possible params the CreateSword should get:
 * Damage
 * AttackSpeed
 * Name
 * RecieveMessage
 * Level
 * Tier
 * Lore-line
**/

/**
 * Sword names:
 * Broadsword
 * Cutlass
 * Katana
 * Scimitar
 * 
**/

/**
 * Sword moves:
 * Set fire tick
 * Set poison tick 
 * Turn invisi and set glow, steal some life
 * Sweep (instant sword recharge)
 * 
 * 
**/

//CreateSword(Name:Bob, Tier:Diamond, Lvl:25, AttackDmg:12, AttackSpeed:-5, recieveMessage:"Yah picked up an enchanted sword"
