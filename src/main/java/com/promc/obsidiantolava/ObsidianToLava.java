package com.promc.obsidiantolava;

import com.promc.obsidiantolava.command.SwitchStatus;
import com.promc.obsidiantolava.file.Config;
import com.promc.obsidiantolava.listener.OnInteract;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class ObsidianToLava extends JavaPlugin {

    public static Plugin instance;
    public static Plugin getInstance() {
        return instance;
    }
    @Override
    public void onEnable() {
        ObsidianToLava.instance = this;
        Config.init();
        Bukkit.getPluginManager().registerEvents(new OnInteract(), this);
        Bukkit.getPluginCommand("obsidiantolava").setExecutor(new SwitchStatus());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
