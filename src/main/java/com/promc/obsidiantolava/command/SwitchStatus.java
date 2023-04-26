package com.promc.obsidiantolava.command;

import com.promc.obsidiantolava.ObsidianToLava;
import com.promc.obsidiantolava.file.Config;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;

import java.util.List;

import static com.promc.obsidiantolava.file.Config.getColoredLang;

public class SwitchStatus implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("switch")) {
                if (sender instanceof Player) {
                    Player player = (Player) sender;
                    if (!player.hasPermission("obsidiantolava.switch")) {
                        player.sendMessage(getColoredLang("no-permission"));
                    } else {
                        List<MetadataValue> metadataValues = player.getMetadata("ObsidianToLava");
                        if (metadataValues.isEmpty() || metadataValues.get(0).asBoolean()) {
                            FixedMetadataValue metadataValue = new FixedMetadataValue(ObsidianToLava.getInstance(), false);
                            player.setMetadata("ObsidianToLava", metadataValue);
                            player.sendMessage(getColoredLang("switch-off-otl"));
                        } else {
                            FixedMetadataValue metadataValue = new FixedMetadataValue(ObsidianToLava.getInstance(), true);
                            player.setMetadata("ObsidianToLava", metadataValue);
                            player.sendMessage(getColoredLang("switch-on-otl"));
                        }
                    }
                }

            } else if (args[0].equalsIgnoreCase("reload")) {
                if (sender instanceof Player && !sender.hasPermission("obsidiantolava.switch")) {
                    sender.sendMessage(getColoredLang("no-permission"));
                    return true;
                }
                Config.reload();
                sender.sendMessage("[ObsidianToLava] Reloaded Success.");
            } else {
                sender.sendMessage(getColoredLang("unknown-command"));
            }
        }
        return true;
    }
}
