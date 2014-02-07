package com.eyeofender.mygar.BanManager.EventListener;

import com.eyeofender.mygar.BanManager.BanManager;
import com.eyeofender.mygar.BanManager.Entity.Player;
import com.eyeofender.mygar.BanManager.Entity.PlayerBan;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

/**
 * Created by Maxim on 07/02/14.
 */
public final class LoginListener implements Listener
{
    private BanManager plugin;

    public LoginListener(BanManager plugin) {
        this.plugin = plugin;

    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onLogin(PlayerLoginEvent event)
    {
        //check if the player is banned

        Player player = plugin.getDatabase().find(Player.class).where().ieq("uuid", event.getPlayer().getUniqueId().toString()).findUnique();

        if(player.isBanned())
        {
            player.kickPlayer("You are banned blabla");
        }
    }
}
