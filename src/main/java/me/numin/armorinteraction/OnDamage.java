package me.numin.armorinteraction;

import com.projectkorra.projectkorra.event.AbilityDamageEntityEvent;
import me.numin.armorinteraction.configuration.Configuration;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

public class OnDamage implements Listener {

    private double maxPotential = ArmorPower.DIAMOND_HELMET.getPower() +
            ArmorPower.DIAMOND_CHESTPLATE.getPower() +
            ArmorPower.DIAMOND_LEGGINGS.getPower() +
            ArmorPower.DIAMOND_BOOTS.getPower();

    @EventHandler
    public void onDamage(AbilityDamageEntityEvent event) {
        double totalPower = 0;
        Entity target = event.getEntity();

        if (!(target instanceof LivingEntity) || event.getAbility() == null)
            return;

        LivingEntity livingTarget = (LivingEntity)target;
        EntityEquipment equipment = livingTarget.getEquipment();

        if (equipment == null)
            return;

        ItemStack helmet = equipment.getHelmet();
        ItemStack chestplate = equipment.getChestplate();
        ItemStack leggings = equipment.getLeggings();
        ItemStack boots = equipment.getBoots();

        ItemStack[] equippedArmor = {helmet, chestplate, leggings, boots};

        for (ItemStack armor : equippedArmor) {
            if (armor == null)
                continue;

            double armorPower = getArmorPower(armor.getType());
            totalPower = totalPower + armorPower;
        }

        double damage = event.getDamage();
        double percentOfDecrease = ((totalPower * 100) / maxPotential) * Configuration.getGlobalStrength();
        double newDamage = damage - ((damage * percentOfDecrease) / 100);

        event.setDamage(newDamage);
    }

    private double getArmorPower(Material armor) {
        if (armor.equals(Material.LEATHER_HELMET)) return ArmorPower.LEATHER_HELMET.getPower();
        else if (armor.equals(Material.LEATHER_CHESTPLATE)) return ArmorPower.LEATHER_CHESTPLATE.getPower();
        else if (armor.equals(Material.LEATHER_LEGGINGS)) return ArmorPower.LEATHER_LEGGINGS.getPower();
        else if (armor.equals(Material.LEATHER_BOOTS)) return ArmorPower.LEATHER_BOOTS.getPower();

        else if (armor.equals(Material.CHAINMAIL_HELMET)) return ArmorPower.CHAINMAIL_HELMET.getPower();
        else if (armor.equals(Material.CHAINMAIL_CHESTPLATE)) return ArmorPower.CHAINMAIL_CHESTPLATE.getPower();
        else if (armor.equals(Material.CHAINMAIL_LEGGINGS)) return ArmorPower.CHAINMAIL_LEGGINGS.getPower();
        else if (armor.equals(Material.CHAINMAIL_BOOTS)) return ArmorPower.CHAINMAIL_BOOTS.getPower();

        else if (armor.equals(Material.IRON_HELMET)) return ArmorPower.IRON_HELMET.getPower();
        else if (armor.equals(Material.IRON_CHESTPLATE)) return ArmorPower.IRON_CHESTPLATE.getPower();
        else if (armor.equals(Material.IRON_LEGGINGS)) return ArmorPower.IRON_LEGGINGS.getPower();
        else if (armor.equals(Material.IRON_BOOTS)) return ArmorPower.IRON_BOOTS.getPower();

        else if (armor.equals(Material.DIAMOND_HELMET)) return ArmorPower.DIAMOND_HELMET.getPower();
        else if (armor.equals(Material.DIAMOND_CHESTPLATE)) return ArmorPower.DIAMOND_CHESTPLATE.getPower();
        else if (armor.equals(Material.DIAMOND_LEGGINGS)) return ArmorPower.DIAMOND_LEGGINGS.getPower();
        else if (armor.equals(Material.DIAMOND_BOOTS)) return ArmorPower.DIAMOND_BOOTS.getPower();

        else return 0;
    }
}
