package com.eyeofender.mygar.BanManager.Command;

import com.eyeofender.mygar.BanManager.BanManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by Maxim on 07/02/14.
 */
public class UnbanCommandExecutor implements CommandExecutor
{

    private BanManager plugin;

    public UnbanCommandExecutor(BanManager plugin)
    {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        return false;
    }
}

