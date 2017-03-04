package sirlich.runnables;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class ManaRegenRunnable extends BukkitRunnable{
	public static ArrayList<Player> players = new ArrayList<Player>();
	
	public static void addPlayer(Player p){
		players.add(p);
	}

	public void run() {
		for(int i = 0; i < players.size(); i ++){
			Player p = (Player) players.get(i);
			p.setVelocity(new Vector(0,0.5,0));
		}
	}
	

}
