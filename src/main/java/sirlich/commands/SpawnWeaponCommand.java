package sirlich.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * This class is a temp-class to test out WeaponUtil.
**/
public class SpawnWeaponCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
			Player p = (Player) sender;
			if(args.length >= 6){
				p.getInventory().addItem(sirlich.weapons.WeaponUtil.CustomSword(args[0],
						args[1],
						Integer.parseInt(args[2]),
						Float.parseFloat(args[3]),
						Float.parseFloat(args[4]),
						args[5],
						Short.parseShort(args[6])));
			}
			else{
				return false;
			}
		}
		else{
			//Handle the other form of this command
		}
		return true;
	}

}
