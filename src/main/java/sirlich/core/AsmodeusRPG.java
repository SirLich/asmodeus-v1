package sirlich.core;
import org.bukkit.plugin.java.JavaPlugin;

import sirlich.commands.SwordCommand;
import sirlich.listeners.PlayerAttackListener;

public class AsmodeusRPG extends JavaPlugin{
	// Fired when plugin is first enabled
    @Override
    public void onEnable() {
    	registerListeners();
    	registerCommands();
    }
    
    // Fired when plugin is disabled
    @Override
    public void onDisable() {

    }
    
    private void registerListeners(){
    	getServer().getPluginManager().registerEvents(new PlayerAttackListener(), this);
    }
    private void registerCommands(){
    	this.getCommand("sword").setExecutor(new SwordCommand());
    }
}
