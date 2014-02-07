package com.eyeofender.mygar.BanManager;

import com.eyeofender.mygar.BanManager.Command.BanCommandExecutor;
import com.eyeofender.mygar.BanManager.Command.UnbanCommandExecutor;
import com.eyeofender.mygar.BanManager.Entity.Player;
import com.eyeofender.mygar.BanManager.Entity.PlayerBan;
import com.eyeofender.mygar.BanManager.EventListener.LoginListener;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.bukkit.plugin.java.JavaPlugin;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxim on 07/02/14.
 */
public final class BanManager extends JavaPlugin
{
    public void onEnable()
    {
        getLogger().info("Starting BanManager");
        setupDatabase();

        getCommand("ban").setExecutor(new BanCommandExecutor(this));
        getCommand("unban").setExecutor(new UnbanCommandExecutor(this));

        getServer().getPluginManager().registerEvents(new LoginListener(this), this);
    }

    public void onDisable()
    {
        getLogger().info("Stopping BanManager");
    }

    private void setupDatabase()
    {
        try{
            getDatabase().find(PlayerBan.class).findRowCount();
            getDatabase().find(Player.class).findRowCount();
        } catch(PersistenceException ex) {
            System.out.println("Installing database for " + getDescription().getName() + " due to first usage");
            installDDL();
        }
    }

    @Override
    public List<Class<?>> getDatabaseClasses() {
        List<Class<?>> list = new ArrayList<Class<?>>();
        list.add(PlayerBan.class);
        list.add(Player.class);
        return list;
    }

}
