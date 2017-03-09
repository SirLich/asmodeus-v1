package sirlich.listeners;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class SpellHitListener implements Listener{
	@EventHandler
	public void snowballHitEvent(ProjectileHitEvent e){
		Player p = (Player) e.getEntity().getShooter();
		Particle par = Particle.VILLAGER_HAPPY;
		Location loc = p.getLocation();
		
		for (Particle c : Particle.values())
		    System.out.println(c);
		
		if(e.getHitEntity() != null){
			loc = e.getHitEntity().getLocation();
		}
		if(e.getHitBlock() != null){
			loc = e.getHitEntity().getLocation();
		}
		p.spawnParticle(par, loc, 100);
	}
}
