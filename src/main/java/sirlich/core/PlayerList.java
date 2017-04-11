package sirlich.core;

import java.util.HashMap;

import org.bukkit.entity.Player;

import sirlich.abilities.Ability;
import sirlich.abilities.DoubleJumpAbility;

public class PlayerList {
	public static HashMap <Player,Player2> playerMap = new HashMap<Player,Player2>();
	public static void addPlayer(Player p){
		Player2 p2 = new Player2();
		
		Ability toggleFlyAbility = new Ability(p);
		Ability switchHandAbility = new DoubleJumpAbility(p);
		Ability dropWeaponAbility = new Ability(p);

		p2.setToggleFlyAbility(toggleFlyAbility);
		p2.setSwitchHandAbility(switchHandAbility);
		p2.setDropWeaponAbility(dropWeaponAbility);


		playerMap.put(p,p2);
	}
	public static Player2 getPlayer(Player p){
		return playerMap.get(p);
	}
}
