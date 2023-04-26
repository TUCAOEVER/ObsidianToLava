package com.promc.obsidiantolava.file;

import com.promc.obsidiantolava.ObsidianToLava;
import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.*;

public class Config {
    public static FileConfiguration configuration;
    public static List<String> enabledWorld;
    public static Map<String, String> messages = new HashMap<>();

    public static void init() {
        ObsidianToLava.getInstance().saveDefaultConfig();
        configuration = ObsidianToLava.getInstance().getConfig();

        enabledWorld = configuration.getStringList("settings.enabled-world");
        ConfigurationSection msgConfig = configuration.getConfigurationSection("messages");
        if (msgConfig != null) {
            msgConfig.getKeys(false).forEach(msgKey -> {
                messages.put(msgKey, msgConfig.getString(msgKey));
            });
        }
    }

    public static void reload() {

        enabledWorld.clear();
        messages.clear();

        enabledWorld = configuration.getStringList("settings.enabled-world");
        ConfigurationSection msgConfig = configuration.getConfigurationSection("messages");
        if (msgConfig != null) {
            msgConfig.getKeys(false).forEach(msgKey -> {
                messages.put(msgKey, msgConfig.getString(msgKey));
            });
        }
    }

    public static String getColoredLang(String string) {
        return ChatColor.translateAlternateColorCodes('&', messages.get(string));
    }
}
