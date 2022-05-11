package fun.mcbee.plugins.beerealms.WorldCreator;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class DeleteRealm implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            UUID uuid = ((Player) sender).getPlayer().getUniqueId();
            boolean unloadWorld = Bukkit.unloadWorld("game-" + uuid, true);
            if (unloadWorld) {
                Bukkit.getWorld("game-" + uuid).getWorldFolder().delete();
                Bukkit.broadcastMessage("game-" + uuid + "§c§l has been deleted.");
            }
            return true;
        }
        return false;
    }
}