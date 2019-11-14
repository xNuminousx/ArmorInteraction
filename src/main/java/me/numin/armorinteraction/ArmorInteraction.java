package me.numin.armorinteraction;

import me.numin.armorinteraction.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

public final class ArmorInteraction extends JavaPlugin {

    private static ArmorInteraction plugin;

    @Override
    public void onEnable() {
        plugin = this;

        new Configuration();
        this.getServer().getPluginManager().registerEvents(new OnDamage(), plugin);

        plugin.getLogger().info("Successfully enabled " + plugin.getDescription().getName());
    }

    @Override
    public void onDisable() {
        plugin.getLogger().info("Successfully enabled " + plugin.getDescription().getName());
    }

    public static ArmorInteraction getInstance() {
        return plugin;
    }
}
