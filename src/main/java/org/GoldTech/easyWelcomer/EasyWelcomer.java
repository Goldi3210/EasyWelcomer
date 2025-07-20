package org.GoldTech.easyWelcomer;

import org.bukkit.plugin.java.JavaPlugin;

public class EasyWelcomer extends JavaPlugin {

    private static EasyWelcomer instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getCommand("ewreload").setExecutor(new ReloadCommand());
    }

    public static EasyWelcomer getInstance() {
        return instance;
    }
}
