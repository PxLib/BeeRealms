package fun.mcbee.plugins.beerealms.WorldCreator;

import fun.mcbee.plugins.beerealms.BeeRealms;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class RealmsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {

            UUID uuid = ((Player) sender).getPlayer().getUniqueId();
            Bukkit.getPlayer(uuid).teleport(Bukkit.getWorld("game-"+uuid).getSpawnLocation());
        }
            return true;
    }
}
