package sirlich.inventory;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class INVInventory {
	private Inventory inv;
	private String name;
	//Inventory inv = Bukkit.createInventory(p, size, title);
	public void openInventory(Player p){
		p.openInventory(inv);
	}
}
