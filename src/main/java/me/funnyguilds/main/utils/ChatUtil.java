package me.funnyguilds.main.utils;

import java.util.*;

import org.bukkit.ChatColor;


public final class ChatUtil {
    public static String fixColor(String s) {
        if (s == null)
            return "";
        return ChatColor.translateAlternateColorCodes('&', s.replace(">>", "»").replace("%o", "•"));
    }
}