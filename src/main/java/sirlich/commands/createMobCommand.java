package sirlich.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import sirlich.chat.ChatUtils;

public class createMobCommand implements CommandExecutor{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] argv) {
		if(!(sender instanceof Player)){
			System.out.println("Please only use this command in-game");
			return false;
		}
		Player p = (Player) sender;
		if(argv.length < 1){
			ChatUtils.chatError(p, "Command failed. Tell me what I should spawn.");
			return false;
		}
		ChatUtils.chatWarning(p, "Attempting to spawn a mob...");
		if(argv[0].equals("zombie")){
			p.getLocation().getWorld().spawnEntity(p.getLocation(),EntityType.ZOMBIE);
			ChatUtils.chatInfo(p, "Zombie spawned.");
		} else if(argv[0].equals("bat")){
			p.getLocation().getWorld().spawnEntity(p.getLocation(),EntityType.BAT);
			ChatUtils.chatInfo(p, "bat spawned.");
		} else{
			ChatUtils.chatError(p, "Command failed. Unable to spawn that.");
			return false;
		}
		return true;
	}

}
