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
			String name;
			if(args.length >= 1){
				name = args[0];
			}
			else{
				name = "null";
			}
			p.getInventory().addItem(WeaponUtil.create(name,args[1]));
		}
		else{
			//Handle the other form of this command
		}
		return false;
	}

}
