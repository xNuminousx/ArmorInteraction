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

package main.java.me.numin.armorinteraction;

import com.projectkorra.projectkorra.event.AbilityDamageEntityEvent;
import com.projectkorra.projectkorra.event.BendingReloadEvent;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

public class CoreListener implements Listener {

	private final double maxPotential = ArmorInteraction.getPlugin().getConfig().getDouble("MaxPotential");
	private final double globalStrength = ArmorInteraction.getPlugin().getConfig().getDouble("GlobalStrength");

	@EventHandler
	public void onBendingDamage(final AbilityDamageEntityEvent event) {
		final Entity target = event.getEntity();
		if (event.getAbility() == null || !(target instanceof LivingEntity) || ((LivingEntity) target).getEquipment() == null) return;

		final LivingEntity livingTarget = (LivingEntity) target;
		final EntityEquipment equipment = livingTarget.getEquipment();

		double totalPower = 0;
		for (final ItemStack armor : equipment.getArmorContents()) {
			if (armor == null) continue;

			if (ArmorInteraction.getPlugin().getConfig().contains("ArmorTypes."+armor.getType().name())) {
				totalPower += ArmorInteraction.getPlugin().getConfig().getInt("ArmorTypes."+armor.getType().name());
			}
		}

		final double modifier = totalPower > maxPotential ? 1 : (totalPower / maxPotential);
		final double newDamage = event.getDamage() - (event.getDamage() * modifier * globalStrength);
		event.setDamage(newDamage);
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onPKReload(final BendingReloadEvent event) {
		ArmorInteraction.getPlugin().reloadConfig();
	}
}
