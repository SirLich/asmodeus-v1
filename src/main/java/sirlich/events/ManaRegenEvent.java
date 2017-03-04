package sirlich.events;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
public class ManaRegenEvent {
	private static ArrayList<Player> players = new ArrayList<Player>();
	public static void addPlayer(Player p){
		players.add(p);
	}
	public static void run(){
		for(int i =0 ;i < players.size(); i++){
			Player p = players.get(i);
			p.setVelocity(new Vector(0,1,0));
			
		}
		Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "" + players);
	}
}
