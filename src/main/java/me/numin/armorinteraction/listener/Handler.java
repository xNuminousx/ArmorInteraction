package me.numin.armorinteraction.listener;

import com.projectkorra.projectkorra.event.AbilityDamageEntityEvent;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.EntityEquipment;

import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import static me.numin.armorinteraction.configuration.Configuration.*;

public class Handler implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onDamage(AbilityDamageEntityEvent event) {
        if (event.getAbility() == null) return;
        Entity target = event.getEntity();
        if (!(target instanceof LivingEntity)) return;
        AtomicReference<Double> totalPower = new AtomicReference<>((double) 0);
        LivingEntity livingTarget = (LivingEntity) target;
        EntityEquipment equipment = livingTarget.getEquipment();
        if (equipment == null) return;
        Arrays.asList(equipment.getHelmet(), equipment.getChestplate(), equipment.getLeggings(), equipment.getBoots()).forEach(stack -> Optional.ofNullable(stack).ifPresent(itemStack -> totalPower.updateAndGet(v -> v + getPower(itemStack.getType()))));
        double damage = event.getDamage();
        double percentOfDecrease = ((totalPower.get() * 100) / MAX_POTENTIAL) * GLOBAL_STRENGTH;
        double newDamage = damage - ((damage * percentOfDecrease) / 100);
        event.setDamage(newDamage);
    }

    private double getPower(Material armor) {
        switch (armor) {
            case LEATHER_HELMET:
                return LEATHER_HELMET;
            case LEATHER_CHESTPLATE:
                return LEATHER_CHESTPLATE;
            case LEATHER_LEGGINGS:
                return LEATHER_LEGGINGS;
            case LEATHER_BOOTS:
                return LEATHER_BOOTS;
            case CHAINMAIL_HELMET:
                return CHAINMAIL_HELMET;
            case CHAINMAIL_CHESTPLATE:
                return CHAINMAIL_CHESTPLATE;
            case CHAINMAIL_LEGGINGS:
                return CHAINMAIL_LEGGINGS;
            case CHAINMAIL_BOOTS:
                return CHAINMAIL_BOOTS;
            case IRON_HELMET:
                return IRON_HELMET;
            case IRON_CHESTPLATE:
                return IRON_CHESTPLATE;
            case IRON_LEGGINGS:
                return IRON_LEGGINGS;
            case IRON_BOOTS:
                return IRON_BOOTS;
            case DIAMOND_HELMET:
                return DIAMOND_HELMET;
            case DIAMOND_CHESTPLATE:
                return DIAMOND_CHESTPLATE;
            case DIAMOND_LEGGINGS:
                return DIAMOND_LEGGINGS;
            case DIAMOND_BOOTS:
                return DIAMOND_BOOTS;
            case GOLDEN_HELMET:
                return GOLDEN_HELMET;
            case GOLDEN_CHESTPLATE:
                return GOLDEN_CHESTPLATE;
            case GOLDEN_LEGGINGS:
                return GOLDEN_LEGGINGS;
            case GOLDEN_BOOTS:
                return GOLDEN_BOOTS;
            default:
                return 0;
        }
    }
}
