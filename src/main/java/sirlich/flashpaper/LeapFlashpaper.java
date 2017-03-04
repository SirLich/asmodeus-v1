package sirlich.flashpaper;

import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class LeapFlashpaper implements Flashpaper{
	Player p;
	public LeapFlashpaper(Player player) {
		this.p = player;
	}

	public void use() {
		this.p.setVelocity(new Vector(1,1,1));
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return 0;
	}
}
