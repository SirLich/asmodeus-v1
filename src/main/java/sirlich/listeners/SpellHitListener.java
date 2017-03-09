package sirlich.listeners;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.util.Vector;

public class SpellHitListener implements Listener{
	@EventHandler
	public void snowballHitEvent(ProjectileHitEvent e){
		Player p = (Player) e.getEntity().getShooter();
		Particle par = Particle.SWEEP_ATTACK;
		Location loc = p.getLocation();
		
		if(e.getHitEntity() != null){
			loc = e.getHitEntity().getLocation().add(new Vector(0,1,0));
        	Bukkit.getWorld("world").playSound(e.getEntity().getLocation(), Sound.BLOCK_NOTE_PLING, 0.3f, 3f);
			par = Particle.SWEEP_ATTACK;
		}
		else if(e.getHitBlock() != null){
			loc = e.getHitBlock().getLocation().add(new Vector(0,1,0));
        	Bukkit.getWorld("world").playSound(e.getEntity().getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 0.3f, 3f);
			par = Particle.CRIT;
		}
		else{
			loc = ((Entity) e.getEntity().getShooter()).getLocation().add(new Vector(0,0,0));
		}
		p.spawnParticle(par, loc, 1);
		e.getEntity().setGravity(false);
	}
}
