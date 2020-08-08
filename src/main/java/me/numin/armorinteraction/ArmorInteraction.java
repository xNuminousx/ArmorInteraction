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

package me.numin.armorinteraction;

import me.numin.armorinteraction.configuration.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class ArmorInteraction extends JavaPlugin {

    private static ArmorInteraction plugin;

    @Override
    public void onEnable() {
        plugin = this;

        new ConfigManager();
        getServer().getPluginManager().registerEvents(new CoreListener(), plugin);

    }

    @Override
    public void onDisable() {
    }

    public static ArmorInteraction getPlugin() {
        return plugin;
    }
}
