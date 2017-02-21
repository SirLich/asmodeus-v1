package sirlich.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import sirlich.weapons.WeaponUtil;

/**
 * This class is a temp-class to test out WeaponUtil.
**/
public class SpawnWeaponCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
			Player p = (Player) sender;
			if(args.length >= 3){
				p.getInventory().addItem(WeaponUtil.create(args[0],args[1],Float.parseFloat(args[2])));
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
