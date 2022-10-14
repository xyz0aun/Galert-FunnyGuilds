package me.funnyguilds.main.Commands;

import me.funnyguilds.main.Main;
import me.funnyguilds.main.utils.ChatUtil;
import net.dzikoysk.funnyguilds.user.User;
import net.dzikoysk.funnyguilds.user.UserManager;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import panda.std.Option;

public class Galert implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player)sender;
        String message = ChatColor.stripColor(ChatUtil.fixColor(StringUtils.join((Object[])args, " ")));
        if(args.length < 1) {
            p.sendMessage(ChatUtil.fixColor("&7Poprawne uzycie: &c/galert [wiadomosc]"));
        }else {
            UserManager userManager = Main.getInstance().getFunnyGuilds().getUserManager();
            Option<User> userOption = userManager.findByUuid(p.getUniqueId());
            if (userOption.isPresent()) {
                User user = userOption.get();
                if (user.hasGuild()) {
                    if (user.isOwner() || user.isDeputy()) {
                        user.getGuild().get().getOnlineMembers().forEach(members -> {
                            Player ps = Bukkit.getPlayerExact(members.getName());
                            ps.sendTitle(ChatUtil.fixColor("&b&l" + p.getName() + "&f&l:"), ChatUtil.fixColor("&f&l" + message));
                        });
                    } else {
                        p.sendMessage(ChatUtil.fixColor("&cNie jestes zalozycielem gildii!"));
                    }
                } else {
                    p.sendMessage(ChatUtil.fixColor("&cNie posiadasz gildii!"));
                }
            }
        }
        return true;
    }
}