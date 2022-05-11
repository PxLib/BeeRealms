package fun.mcbee.plugins.beerealms;

import fun.mcbee.plugins.beerealms.WorldCreator.CreateRealm;
import fun.mcbee.plugins.beerealms.WorldCreator.DeleteRealm;
import fun.mcbee.plugins.beerealms.WorldCreator.RealmsCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class BeeRealms extends JavaPlugin {
    private static BeeRealms instance;
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new CreateRealm(), this);

        getCommand("realm").setExecutor(new RealmsCommand());
        getCommand("delrealm").setExecutor(new DeleteRealm());
        instance = this;

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public static BeeRealms getInstance() {
        return instance;
    }
}
