package sirlich.flashpaper;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;

import sirlich.core.AsmodeusRPG;

/**
 * Test flashpaper. This launches the players by Vector(1,1,1)
 * EDIT: Now launches spells.
**/
public class LeapFlashpaper implements Flashpaper{
	Player p;
	public LeapFlashpaper(Player player) {
		this.p = player;
	}
	public void use() {
		//this.p.setVelocity(new Vector(this.p.getLocation().getDirection().getX()*1.5,1,this.p.getLocation().getDirection().getZ()*1.5));
		Location loc = p.getEyeLocation().toVector().add(p.getLocation().getDirection().multiply(2)).toLocation(p.getWorld(), p.getLocation().getYaw(), p.getLocation().getPitch());
		Snowball snow = p.getWorld().spawn(loc, Snowball.class);
		snow.setShooter(p);
		snow.setVelocity(p.getEyeLocation().getDirection().multiply(1));
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(AsmodeusRPG.instance(), new Runnable() {
            public void run() {
            	if(snow.hasGravity()){
                	Bukkit.getWorld("world").playSound(snow.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 0.3f, 3f);
            	}
        		snow.remove();
            }
        }, 10);
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return 0;
	}
}
