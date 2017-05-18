package sirlich.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import sirlich.inventory.INVItem;

public class openInvCmd implements CommandExecutor{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
			Player p = (Player) sender;
			Inventory inv = Bukkit.createInventory(p, 9, "Example Inventory!");
			INVItem invitem = new INVItem("example", "test", 6);
			inv.setItem(5, invitem.item());
			p.openInventory(inv);
		}
		return false;	
	}

}
