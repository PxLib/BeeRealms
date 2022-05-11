package fun.mcbee.plugins.beerealms.WorldCreator;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CreateRealm implements Listener {


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        UUID uuid = e.getPlayer().getUniqueId();
        World realm = Bukkit.getWorld("game-"+uuid);

        if(realm == null) {
            WorldCreator creator = new WorldCreator("game-"+uuid);
            creator.createWorld();
            Bukkit.getConsoleSender().sendMessage("[Beerealms] World created!");
        }else {
            Bukkit.getConsoleSender().sendMessage("World already exists");
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        UUID uuid = e.getPlayer().getUniqueId();
        World realm = Bukkit.getWorld("game-"+uuid);

        boolean unloadWorld = Bukkit.unloadWorld(realm, true);

        List<Player> playerList = Bukkit.getOnlinePlayers().stream().filter(p -> p.getWorld().equals("game-"+uuid)).collect(Collectors.toList());

        if(unloadWorld) {
            playerList.get(0).teleport(Bukkit.getWorld("world").getSpawnLocation());
            Bukkit.getConsoleSender().sendMessage("[Beerealms] World unloaded!");

        }

    }
    /*
    @EventHandler
    public void PlayerJoin(PlayerJoinEvent event) {
        UUID uuid = event.getPlayer().getUniqueId();
        if (Bukkit.getWorld(uuid) == null) {
            Bukkit.createWorld(new WorldCreator(uuid.toString()));
            Bukkit.getConsoleSender().sendMessage("§cWorld " + event.getPlayer().getUniqueId().toString() + " Created");

        } else {
            if (Bukkit.getWorld(uuid).getName().equals(uuid.toString())) {
                Bukkit.getConsoleSender().sendMessage("§cWorld " + event.getPlayer().getUniqueId().toString() + " Already Exists");
            }
        }
    }
        @EventHandler
        public void PlayerLeave (PlayerQuitEvent event){
            UUID uuid = event.getPlayer().getUniqueId();
            Bukkit.unloadWorld(uuid.toString(), true);
            Bukkit.getConsoleSender().sendMessage("§cWorld " + uuid.toString() + " unloaded");
    }*/
}