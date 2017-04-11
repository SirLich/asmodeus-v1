package sirlich.abilities;

import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class DoubleJumpAbility extends Ability{
	private Player p;
	private String name;
	public DoubleJumpAbility(Player p) {
		super(p);
		p = super.getPlayer();
		name = super.getName();
	}
	@Override
	public void run(){
		p.sendMessage(name);
		p.setVelocity(new Vector(p.getLocation().getDirection().getX()*1.5,1,p.getLocation().getDirection().getZ()*1.5));
	}

}
