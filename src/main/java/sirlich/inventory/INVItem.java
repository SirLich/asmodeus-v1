package sirlich.inventory;


import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.tr7zw.itemnbtapi.NBTItem;

public class INVItem {
	private String name;
	private int dmg;
	private String action;
	public INVItem(String name, String action, int dmg){
		this.name = name;
		this.dmg = dmg;
		this.action = action;
	}
	public ItemStack item(){
		ItemStack item = new ItemStack(Material.STONE_AXE, 1, (short)dmg);
		NBTItem nbtitem = new NBTItem(item);
        nbtitem.setString("action",action);
        item = nbtitem.getItem();   
        
        //Set META values for the weapon.
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.setDisplayName(name);
        item.setItemMeta(itemMeta);
        return item;
	}
}
