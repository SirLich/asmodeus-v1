package sirlich.flashpaper;

import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
/**
 * Test flashpaper. This launches the players by Vector(1,1,1)
**/
public class LeapFlashpaper implements Flashpaper{
	Player p;
	public LeapFlashpaper(Player player) {
		this.p = player;
	}

	public void use() {
		this.p.setVelocity(new Vector(this.p.getLocation().getDirection().getX()*1.5,1,this.p.getLocation().getDirection().getZ()*1.5));
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return 0;
	}
}
