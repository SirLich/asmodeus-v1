package sirlich.inventory;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class INVItem {
	private String name;
	private INVAction action;
	private int slot;
	private int damage;
	public INVItem(String name, INVAction action, int slot, int damage){
		this.setName(name);
		this.setAction(action);
		this.setSlot(slot);
		this.damage = damage;
	}
	public ItemStack getItem(){
		ItemStack item = new ItemStack(Material.STONE_AXE, 1, (short)damage);
		ItemMeta meta = item.getItemMeta();
		meta.setUnbreakable(true); // On versions 1.11 and above
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
		item.setItemMeta(meta);
		return item;
	}
	public int getSlot() {
		return slot;
	}
	public void setSlot(int slot) {
		this.slot = slot;
	}
	public INVAction getAction() {
		return action;
	}
	public void setAction(INVAction action) {
		this.action = action;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
