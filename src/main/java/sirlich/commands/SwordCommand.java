package sirlich.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import sirlich.weapons.SwordWeapon;

public class SwordCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
			Player p = (Player) sender;
			p.getInventory().addItem(SwordWeapon.create(args[0]));
		}
		else{
			System.out.println("Please us this command in-game");
		}
		return false;
	}

}
