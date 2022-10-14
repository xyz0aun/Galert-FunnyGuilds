package me.funnyguilds.main;


import me.funnyguilds.main.Commands.Galert;
import net.dzikoysk.funnyguilds.FunnyGuilds;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private static Main instance;
    private FunnyGuilds funnyGuilds;



    public void onEnable() {
        instance = this;
        funnyGuilds = FunnyGuilds.getInstance();
        this.saveDefaultConfig();
        getCommand("galert").setExecutor(new Galert());

    }

    public static Main getInstance(){
        return instance;
    }

    public FunnyGuilds getFunnyGuilds(){
        return this.funnyGuilds;
    }
}