package me.numin.armorinteraction;

import me.numin.armorinteraction.command.Command;
import me.numin.armorinteraction.configuration.Configuration;
import me.numin.armorinteraction.listener.Handler;
import org.bukkit.plugin.java.JavaPlugin;

import static me.numin.armorinteraction.configuration.Configuration.*;

public final class ArmorInteraction extends JavaPlugin {

    private static ArmorInteraction plugin;

    @Override
    public void onEnable() {
        plugin = this;
        getServer().getPluginManager().registerEvents(new Handler(), this);
        new Command();
        reloadConfig();
    }

    public void reloadConfig() {
        new Configuration();
        double helmet = Math.max(LEATHER_HELMET, Math.max(Math.max(DIAMOND_HELMET, IRON_HELMET), Math.max(GOLDEN_HELMET, CHAINMAIL_HELMET)));
        double chestplate = Math.max(LEATHER_CHESTPLATE, Math.max(Math.max(DIAMOND_CHESTPLATE, IRON_CHESTPLATE), Math.max(GOLDEN_CHESTPLATE, CHAINMAIL_CHESTPLATE)));
        double leggings = Math.max(LEATHER_LEGGINGS, Math.max(Math.max(DIAMOND_LEGGINGS, IRON_LEGGINGS), Math.max(GOLDEN_LEGGINGS, CHAINMAIL_LEGGINGS)));
        double boots = Math.max(LEATHER_BOOTS, Math.max(Math.max(DIAMOND_BOOTS, IRON_BOOTS), Math.max(GOLDEN_BOOTS, CHAINMAIL_BOOTS)));
        MAX_POTENTIAL = helmet + chestplate + leggings + boots;
        getLogger().info("MAX_POTENTIAL: " + MAX_POTENTIAL);
    }

    public static ArmorInteraction getInstance() {
        return plugin;
    }
}
