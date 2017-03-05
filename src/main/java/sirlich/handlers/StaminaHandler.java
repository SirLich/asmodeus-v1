package sirlich.handlers;

import java.util.ArrayList;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class StaminaHandler {
	
	private static ArrayList<Player> players = new ArrayList<Player>();
	private static ArrayList<Float> tiredness = new ArrayList<Float>();
	private static ArrayList<Boolean> isTired = new ArrayList<Boolean>();
	
	//These will eventualy get set in a config file
	public static final float EXHAUSTION_DRAIN = 0.02f;
	public static final float EXHAUSTION_MAX = 1.0f;
	
	public static final float STAMINA_REGEN = 0.01f;
	public static final float STAMINA_DRAIN = 0.02f;
	
	public static void addPlayer(Player p){
		players.add(p);
		tiredness.add(EXHAUSTION_MAX);
		isTired.add(false);
	}
	
	public static void run(){
		for(int i =0 ;i < players.size(); i++){
			Player p = players.get(i);       //Player
			Float stamina = p.getExp();            //XP
			
			if(stamina <= 0){ //Player appears to be exhausted
				if(isTired.get(i)){ //HES TIRED
					tiredness.set(i, tiredness.get(i) - EXHAUSTION_DRAIN); //He is tired, so drain some tiredness away!
					if(tiredness.get(i) < 0){ //HE WAS TIRED BUT HE NO LONGER IS
						p.sendMessage(ChatColor.LIGHT_PURPLE + "You are no longer exhausted");
						p.setFoodLevel(20);
						isTired.set(i, false); //Make him not tired
						p.setExp(0.01f);
					}
				}
				else{//HES NOT TIRED
					p.setFoodLevel(0);
					p.sendMessage(ChatColor.LIGHT_PURPLE + "You are exhausted");
					isTired.set(i, true);
					tiredness.set(i, 1.0f);
				}
			}
			else if(stamina > 0){ //Player isnt tired yet
				if(p.isSprinting()){
					if(p.getExp() > STAMINA_DRAIN){
						p.setExp(p.getExp() - STAMINA_DRAIN); //drain some of their stamina
					}
					else{
						p.setExp(0);
					}
				}
				else{
					if(p.getExp() < 1 + STAMINA_REGEN){
						p.setExp(p.getExp() + STAMINA_REGEN); //Regenerate some stamina
					}
					else{
						p.setExp(1);
					}
				}
				if(p.isSneaking()){
					p.setExp(p.getExp() + STAMINA_REGEN); //Regenerate some stamina
				}
			}
			else{ //Something went wrong
				p.setExp(1f);
			}
			/** Notes about XP:
			 * 	There are a few differant casses to consider:
			 * 		The player is at zero mana. This means either he:
			 * 			is exhausted so lower his exhaustion or he
			 * 			he is not exhausted meaning he should regain some mana back'
			 * 		The player is not at zero mana which means he is either:
			 * 			sprinting, which means we should lower his stamina
			 * 			or walking, which means we should regain some mana
			**/
		}
	}
	//Legacy code
	/*
	public static void run(){
		for(int i =0 ;i < players.size(); i++){
			Player p = players.get(i);
			boolean e = exhaustion.get(i);
			
			if(p.isSprinting()){
				if(p.getExp() >= 0.02f){
					p.setExp(p.getExp() - 0.02f);
				}
				else{
					p.setSprinting(false);
				}
			}
			else if(p.getExp() <= 1.0f){
				p.setExp(p.getExp() + 0.01f);
			}
		}
	*/
}
