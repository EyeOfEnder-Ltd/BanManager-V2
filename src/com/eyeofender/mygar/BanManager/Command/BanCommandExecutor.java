    package com.eyeofender.mygar.BanManager.Command;

import com.eyeofender.mygar.BanManager.BanManager;
import com.eyeofender.mygar.BanManager.Entity.Player;
import com.eyeofender.mygar.BanManager.Entity.PlayerBan;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

    /**
 * Created by Maxim on 07/02/14.
 */
public class BanCommandExecutor  implements CommandExecutor
{
    private JavaPlugin plugin;

    public BanCommandExecutor(BanManager plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        /**
         * args: [player], [period], [reason]
         */
        if(command.getName().equalsIgnoreCase("ban"))
        {
            if(!(commandSender instanceof Player))
                return false;
            if(!(args.length >= 2) && !(args.length <= 3))
                return false;

            Player issuer = (Player)commandSender;

            Player gettingBanned = plugin.getDatabase().find(Player.class).where().ieq("uuid", plugin.getServer().getPlayer(args[1]).getUniqueId().toString()).findUnique();

            PlayerBan ban = new PlayerBan();

            if(gettingBanned.hasBan())
                 ban = gettingBanned.getBan();

            ban.setPlayer(gettingBanned);
            ban.setBanner(issuer);

            if(args[2].equalsIgnoreCase("permanent") || args[2].equalsIgnoreCase("p") || args[2].equalsIgnoreCase("perm")) {
                ban.setPermanent(true);
            } else {
                ban.setExpiresOn(this.parseTimeMessage(args[2]));
            }

            if(args.length == 3)
                ban.setReason(args[3]);


            plugin.getDatabase().save(ban);
            return true;
        }

       return false;

    }
    public Date parseTimeMessage(String time)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());

        String[] times = time.split("^(\\d*[A-z])");
        for(String piece : times)
        {
            String[] args = piece.split("\\d*");
            String tid = args[1].toUpperCase();

            if(tid.equalsIgnoreCase("m") || tid.equalsIgnoreCase("months") || tid.equalsIgnoreCase("month"))
            {
                cal.add(Calendar.DAY_OF_MONTH, Integer.parseInt(args[0]));
            }
            else if(tid.equalsIgnoreCase("min") || tid.equalsIgnoreCase("minutes") || tid.equalsIgnoreCase("minute"))
            {
                cal.add(Calendar.MINUTE, Integer.parseInt(args[0]));
            }
            else if(tid.equalsIgnoreCase("s") || tid.equalsIgnoreCase("sec") || tid.equalsIgnoreCase("seconds") || tid.equalsIgnoreCase("seconds"))
            {
                cal.add(Calendar.SECOND, Integer.parseInt(args[0]));
            }
            else if(tid.equalsIgnoreCase("d") || tid.equalsIgnoreCase("day") || tid.equalsIgnoreCase("days"))
            {
                cal.add(Calendar.DATE, Integer.parseInt(args[0]));
            }
            else if(tid.equalsIgnoreCase("h") || tid.equalsIgnoreCase("hour") || tid.equalsIgnoreCase("hours"))
            {
                cal.add(Calendar.HOUR_OF_DAY, Integer.parseInt(args[0]));
            }
            else if(tid.equalsIgnoreCase("w") || tid.equalsIgnoreCase("week") || tid.equalsIgnoreCase("weeks"))
            {
                cal.add(Calendar.WEEK_OF_YEAR, Integer.parseInt(args[0]));
            }
        }

        return cal.getTime();
    }
}
