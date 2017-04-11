package sirlich.abilities;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Ability {
	private Player player;
	private double EnergyCost;
	private String name = "Basic Ability";
	
	public Player getPlayer(){
		return player;
	}
	public String getName(){
		return name;
	}
	public Ability(Player p){
		player = p;
	}
	public double getEnergyCost() {
		return EnergyCost;
	}
	public void setEnergyCost(double energyCost) {
		EnergyCost = energyCost;
	}
	public void run(){
		player.sendMessage(ChatColor.AQUA + "The ability " + name + " was run.");
	}
}
