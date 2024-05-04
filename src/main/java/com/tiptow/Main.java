package com.tiptow;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;

public class Main extends JavaPlugin implements Listener {
    private Set<Player> dimensionPlayers = new HashSet<>();

    @Override
    public void onEnable() {
        // Register events
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        Set<Player> recipients = new HashSet<>(event.getRecipients());
        for (Player recipient : recipients) {
            if (!player.getWorld().equals(recipient.getWorld())) {
                event.getRecipients().remove(recipient);
            }
        }
    }
}
