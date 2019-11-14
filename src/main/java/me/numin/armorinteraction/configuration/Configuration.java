package me.numin.armorinteraction.configuration;

import me.numin.armorinteraction.ArmorInteraction;

import org.bukkit.configuration.file.FileConfiguration;

public class Configuration {

    private ConfigFile configFile;
    private static ArmorInteraction plugin = ArmorInteraction.getInstance();

    public Configuration() {
        this.configFile = new ConfigFile("config");
        loadConfig();
    }

    private FileConfiguration getConfig() {
        return configFile.getConfig();
    }

    public void loadConfig() {
        FileConfiguration config = plugin.getConfig();

        config.addDefault("Note", "Diamond armor is used as a base for this algorithm. " +
                "It adds up the total of diamond armor power and uses that as the max potential power. " +
                "By default, the max potential power of someone's armor is 16 (with full diamond armor). " +
                "Be sure when you add up the totals of all your armor, diamond has the most.");

        config.addDefault("Note 2", "The GlobalStrength variable is a means of having control over the armors" +
                " strength all at once. For example, by setting the GlobalStrength to 1 someone with full diamond armor will" +
                " not take any damage from a bending ability. It's set to 0.6 by default so only 60 percent of the damage" +
                " reduction actually takes place. This value should not be more than 1 or less than 0 since it's on a percentage" +
                " calculation where 1 = 100%, 0.5 = 50%, and 0 = 0%.");

        config.addDefault("ArmorPower.GlobalStrength", 0.6);

        config.addDefault("ArmorPower.Leather.Helmet", 1);
        config.addDefault("ArmorPower.Leather.Chestplate", 1);
        config.addDefault("ArmorPower.Leather.Leggings", 1);
        config.addDefault("ArmorPower.Leather.Boots", 1);

        config.addDefault("ArmorPower.Chainmail.Helmet", 2);
        config.addDefault("ArmorPower.Chainmail.Chestplate", 2);
        config.addDefault("ArmorPower.Chainmail.Leggings", 2);
        config.addDefault("ArmorPower.Chainmail.Boots", 2);

        config.addDefault("ArmorPower.Iron.Helmet", 3);
        config.addDefault("ArmorPower.Iron.Chestplate", 3);
        config.addDefault("ArmorPower.Iron.Leggings", 3);
        config.addDefault("ArmorPower.Iron.Boots", 3);

        config.addDefault("ArmorPower.Diamond.Helmet", 4);
        config.addDefault("ArmorPower.Diamond.Chestplate", 4);
        config.addDefault("ArmorPower.Diamond.Leggings", 4);
        config.addDefault("ArmorPower.Diamond.Boots", 4);

        config.options().copyDefaults(true);
        plugin.saveConfig();
    }

    public static double getGlobalStrength() {return plugin.getConfig().getDouble("ArmorPower.GlobalStrength");}

    public static double getLeatherHelmetPower() {return plugin.getConfig().getDouble("ArmorPower.Leather.Helmet");}
    public static double getLeatherChestplatePower() {return plugin.getConfig().getDouble("ArmorPower.Leather.Chestplate");}
    public static double getLeatherLeggingsPower() {return plugin.getConfig().getDouble("ArmorPower.Leather.Leggings");}
    public static double getLeatherBootsPower() {return plugin.getConfig().getDouble("ArmorPower.Leather.Boots");}

    public static double getChainmailHelmetPower() {return plugin.getConfig().getDouble("ArmorPower.Chainmail.Helmet");}
    public static double getChainmailChestplatePower() {return plugin.getConfig().getDouble("ArmorPower.Chainmail.Chestplate");}
    public static double getChainmailLeggingsPower() {return plugin.getConfig().getDouble("ArmorPower.Chainmail.Leggings");}
    public static double getChainmailBootsPower() {return plugin.getConfig().getDouble("ArmorPower.Chainmail.Boots");}

    public static double getIronHelmetPower() {return plugin.getConfig().getDouble("ArmorPower.Iron.Helmet");}
    public static double getIronChestplatePower() {return plugin.getConfig().getDouble("ArmorPower.Iron.Chestplate");}
    public static double getIronLeggingsPower() {return plugin.getConfig().getDouble("ArmorPower.Iron.Leggings");}
    public static double getIronBootsPower() {return plugin.getConfig().getDouble("ArmorPower.Iron.Boots");}

    public static double getDiamondHelmetPower() {return plugin.getConfig().getDouble("ArmorPower.Diamond.Helmet");}
    public static double getDiamondChestplatePower() {return plugin.getConfig().getDouble("ArmorPower.Diamond.Chestplate");}
    public static double getDiamondLeggingsPower() {return plugin.getConfig().getDouble("ArmorPower.Diamond.Leggings");}
    public static double getDiamondBootsPower() {return plugin.getConfig().getDouble("ArmorPower.Diamond.Boots");}
}
