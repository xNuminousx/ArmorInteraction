package me.numin.armorinteraction;

import me.numin.armorinteraction.configuration.Configuration;

public enum ArmorPower {

    LEATHER_HELMET(Configuration.getLeatherHelmetPower()),
    LEATHER_CHESTPLATE(Configuration.getLeatherChestplatePower()),
    LEATHER_LEGGINGS(Configuration.getLeatherLeggingsPower()),
    LEATHER_BOOTS(Configuration.getLeatherBootsPower()),

    CHAINMAIL_HELMET(Configuration.getChainmailHelmetPower()),
    CHAINMAIL_CHESTPLATE(Configuration.getChainmailChestplatePower()),
    CHAINMAIL_LEGGINGS(Configuration.getChainmailLeggingsPower()),
    CHAINMAIL_BOOTS(Configuration.getChainmailBootsPower()),

    IRON_HELMET(Configuration.getIronHelmetPower()),
    IRON_CHESTPLATE(Configuration.getIronChestplatePower()),
    IRON_LEGGINGS(Configuration.getIronLeggingsPower()),
    IRON_BOOTS(Configuration.getIronBootsPower()),

    DIAMOND_HELMET(Configuration.getDiamondHelmetPower()),
    DIAMOND_CHESTPLATE(Configuration.getDiamondChestplatePower()),
    DIAMOND_LEGGINGS(Configuration.getDiamondLeggingsPower()),
    DIAMOND_BOOTS(Configuration.getDiamondBootsPower());

    private double power;

    ArmorPower(double power) {
        this.power = power;
    }

    public double getPower() {
        return power;
    }
}
