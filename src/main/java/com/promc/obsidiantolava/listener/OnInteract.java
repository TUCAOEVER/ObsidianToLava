package com.promc.obsidiantolava.listener;

import com.promc.obsidiantolava.file.Config;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import static org.bukkit.Sound.ITEM_BUCKET_FILL_LAVA;

public class OnInteract implements Listener {
    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getClickedBlock() == null || event.getClickedBlock().getType() != Material.OBSIDIAN) return;
        Block block = event.getClickedBlock();
        if (!player.getMetadata("ObsidianToLava").isEmpty()
                && !player.getMetadata("ObsidianToLava").get(0).asBoolean()) return;
        String worldName = block.getWorld().getName();
        if (!Config.enabledWorld.contains(worldName)) return;
        ItemStack mainHand = player.getInventory().getItemInMainHand();
        ItemStack offHand = player.getInventory().getItemInOffHand();
        if (mainHand.getType() == Material.BUCKET || offHand.getType() == Material.BUCKET) {
            event.getClickedBlock().setType(Material.AIR);
            player.getInventory().removeItem(new ItemStack(Material.BUCKET));
            player.getInventory().addItem(new ItemStack(Material.LAVA_BUCKET));
            player.playSound(block.getLocation(), ITEM_BUCKET_FILL_LAVA, 1, 1);
        }
    }
}
