package me.numin.armorinteraction.configuration;

import me.numin.armorinteraction.ArmorInteraction;
import ru.ckateptb.armorinteraction.Configurable;

@Configurable.ConfigFile(header = "Diamond armor is used as a base for this algorithm." +
        "\n# It adds up the total of diamond armor power and uses that as the max potential power." +
        "\n# Be sure when you add up the totals of all your armor, diamond has the most." +
        "\n# To check: helmet + chestplate + leggings + boots = Total Armor Power." +
        "\n# Example (Diamond armor): helmet + chestplate + leggings + boots = 16\n# " +
        "\n# The GlobalStrength variable is a means of having control over the armors strength all at once." +
        "\n# For example, by setting the GlobalStrength to 1 someone with full diamond armor will not take any damage from a bending ability." +
        "\n# It's set to 0.6 by default so only 60 percent of the damage reduction actually takes place." +
        "\n# This value should not be more than 1 or less than 0 since it's on a percentage calculation where 1 = 100%, 0.5 = 50%, and 0 = 0%.\n")
public class Configuration extends Configurable {

    @ConfigField(name = "strength.multiplier")
    public static double GLOBAL_STRENGTH = 0.6;
    @ConfigField(name = "leather.helmet")
    public static double LEATHER_HELMET = 1;
    @ConfigField(name = "leather.chestplate")
    public static double LEATHER_CHESTPLATE = 1;
    @ConfigField(name = "leather.leggings")
    public static double LEATHER_LEGGINGS = 1;
    @ConfigField(name = "leather.boots")
    public static double LEATHER_BOOTS = 1;
    @ConfigField(name = "chainmail.helmet")
    public static double CHAINMAIL_HELMET = 2;
    @ConfigField(name = "chainmail.chestplate")
    public static double CHAINMAIL_CHESTPLATE = 2;
    @ConfigField(name = "chainmail.leggings")
    public static double CHAINMAIL_LEGGINGS = 2;
    @ConfigField(name = "chainmail.boots")
    public static double CHAINMAIL_BOOTS = 2;
    @ConfigField(name = "golden.helmet")
    public static double GOLDEN_HELMET = 2;
    @ConfigField(name = "golden.chestplate")
    public static double GOLDEN_CHESTPLATE = 2;
    @ConfigField(name = "golden.leggings")
    public static double GOLDEN_LEGGINGS = 2;
    @ConfigField(name = "golden.boots")
    public static double GOLDEN_BOOTS = 2;
    @ConfigField(name = "iron.helmet")
    public static double IRON_HELMET = 3;
    @ConfigField(name = "iron.chestplate")
    public static double IRON_CHESTPLATE = 3;
    @ConfigField(name = "iron.leggings")
    public static double IRON_LEGGINGS = 3;
    @ConfigField(name = "iron.boots")
    public static double IRON_BOOTS = 3;
    @ConfigField(name = "diamond.helmet")
    public static double DIAMOND_HELMET = 4;
    @ConfigField(name = "diamond.chestplate")
    public static double DIAMOND_CHESTPLATE = 4;
    @ConfigField(name = "diamond.leggings")
    public static double DIAMOND_LEGGINGS = 4;
    @ConfigField(name = "diamond.boots")
    public static double DIAMOND_BOOTS = 4;
    public static double MAX_POTENTIAL;

    public Configuration() {
        super(ArmorInteraction.getInstance().getDataFolder() + "/config.yml");
    }
}
