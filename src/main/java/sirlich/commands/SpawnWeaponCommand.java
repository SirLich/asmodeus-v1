package sirlich.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import sirlich.weapons.CustomWeapon;

/**
 * This class is a temp-class to test out weapons.
**/
public class SpawnWeaponCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
			Player p = (Player) sender;
			if(args.length >= 2){
				/*p.getInventory().addItem(sirlich.weapons.WeaponUtil.CustomSword(args[0],
						args[1],
						Integer.parseInt(args[2]),
						Float.parseFloat(args[3]),
						Float.parseFloat(args[4]),
						args[5],
						Integer.parseInt(args[6])));*/
				p.getInventory().addItem(CustomWeapon.createWeapon(args[0],Integer.parseInt(args[1])));
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
