package me.numin.armorinteraction.configuration;

import me.numin.armorinteraction.ArmorInteraction;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigFile {

    private ArmorInteraction plugin = ArmorInteraction.getInstance();

    private File file;
    private FileConfiguration config;

    ConfigFile(String name) {
        this(new File(name + ".yml"));
    }

    private ConfigFile(File file) {
        this.file = new File(plugin.getDataFolder() + File.separator + file);
        this.config = YamlConfiguration.loadConfiguration(this.file);
        reloadConfig();
    }

    private void createConfig() {
        if (!file.getParentFile().exists()) {
            try {
                file.getParentFile().mkdir();
                plugin.getLogger().info("Generating new directory for " + file.getName());
            } catch (Exception e) {
                plugin.getLogger().info("Failed to generate directory");
                e.printStackTrace();
            }
        }

        if (!file.exists()) {
            try {
                file.createNewFile();
                plugin.getLogger().info("Generating new " + file.getName());
            } catch (Exception e) {
                plugin.getLogger().info("Failed to generate " + file.getName());
                e.printStackTrace();
            }
        }
    }

    FileConfiguration getConfig() {
        return config;
    }

    private void reloadConfig() {
        createConfig();
        try {
            config.load(file);
            plugin.getLogger().info("Loading configuration");
        } catch (Exception e) {
            plugin.getLogger().info("Failed to reload " + file.getName());
            e.printStackTrace();
        }
    }

    public void saveConfig() {
        try {
            config.options().copyDefaults(true);
            config.save(file);
            plugin.getLogger().info("Successfully saved configuration");
        } catch (Exception e) {
            plugin.getLogger().info("Failed to save configuration");
            e.printStackTrace();
        }
    }
}