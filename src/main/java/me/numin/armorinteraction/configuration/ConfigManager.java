/*
 *   Copyright 2019 Numin <https://github.com/xNuminousx>
 *   Copyright 2020 Moros <https://github.com/PrimordialMoros>
 *
 * 	  This file is part of ArmorInteraction.
 *
 *    ArmorInteraction is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    ArmorInteraction is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with ArmorInteraction.  If not, see <https://www.gnu.org/licenses/>.
 */

package main.java.me.numin.armorinteraction.configuration;

import main.java.me.numin.armorinteraction.ArmorInteraction;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {

	public ConfigManager() {
		loadConfig();
	}

	public void loadConfig() {
		FileConfiguration config = ArmorInteraction.getPlugin().getConfig();

		config.addDefault("Note", "MaxPotential is used as a base for the algorithm. " +
			"It adds up the total of the highest armor power and uses that as the max potential power. " +
			"Be sure when you add up the totals of all pieces in an armor set." +
			"To check: Helmet + Chestplate + Leggings + Boots = Total Armor Power. " +
			"Example (Netherite armor): Helmet + Chestplate + Leggings + Boots = 20");

		config.addDefault("Note 2", "The GlobalStrength variable is a means of having control over the armors" +
			" strength all at once. For example, by setting the GlobalStrength to 1 someone with full diamond armor will" +
			" not take any damage from a bending ability. It's set to 0.6 by default so only 60 percent of the damage" +
			" reduction actually takes place. This value should not be more than 1 or less than 0 since it's on a percentage" +
			" calculation where 1 = 100%, 0.5 = 50%, and 0 = 0%.");

		config.addDefault("MaxPotential", 20);
		config.addDefault("GlobalStrength", 0.6);

		config.addDefault("ArmorTypes.LEATHER_HELMET", 1);
		config.addDefault("ArmorTypes.LEATHER_CHESTPLATE", 3);
		config.addDefault("ArmorTypes.LEATHER_LEGGINGS", 2);
		config.addDefault("ArmorTypes.LEATHER_BOOTS", 1);

		config.addDefault("ArmorTypes.GOLD_HELMET", 2);
		config.addDefault("ArmorTypes.GOLD_CHESTPLATE", 5);
		config.addDefault("ArmorTypes.GOLD_LEGGINGS", 3);
		config.addDefault("ArmorTypes.GOLD_BOOTS", 1);

		config.addDefault("ArmorTypes.CHAINMAIL_HELMET", 2);
		config.addDefault("ArmorTypes.CHAINMAIL_CHESTPLATE", 5);
		config.addDefault("ArmorTypes.CHAINMAIL_LEGGINGS", 4);
		config.addDefault("ArmorTypes.CHAINMAIL_BOOTS", 1);

		config.addDefault("ArmorTypes.IRON_HELMET", 2);
		config.addDefault("ArmorTypes.IRON_CHESTPLATE", 6);
		config.addDefault("ArmorTypes.IRON_LEGGINGS", 5);
		config.addDefault("ArmorTypes.IRON_BOOTS", 2);

		config.addDefault("ArmorTypes.DIAMOND_HELMET", 3);
		config.addDefault("ArmorTypes.DIAMOND_CHESTPLATE", 8);
		config.addDefault("ArmorTypes.DIAMOND_LEGGINGS", 6);
		config.addDefault("ArmorTypes.DIAMOND_BOOTS", 3);

		config.addDefault("ArmorTypes.NETHERITE_HELMET", 3);
		config.addDefault("ArmorTypes.NETHERITE_CHESTPLATE", 8);
		config.addDefault("ArmorTypes.NETHERITE_LEGGINGS", 6);
		config.addDefault("ArmorTypes.NETHERITE_BOOTS", 3);

		config.options().copyDefaults(true);
		ArmorInteraction.getPlugin().saveConfig();
	}
}
