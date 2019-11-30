package me.numin.armorinteraction.command;

import me.numin.armorinteraction.ArmorInteraction;
import org.bukkit.command.CommandSender;
import ru.ckateptb.armorinteraction.ACommand;

import java.util.Collections;
import java.util.List;

public class Command extends ACommand {

    private String permission;

    public Command() {
        super("ArmorInteraction", "ai", "BendingArmorInteraction", "bai");
        this.permission = ArmorInteraction.getInstance().getName() + ".reload";
    }

    @Override
    public boolean progress(CommandSender sender, String[] args) {
        if (!sender.hasPermission(permission))
            return false;
        if (args.length == 1 && args[0].equalsIgnoreCase("reload"))
            ArmorInteraction.getInstance().reloadConfig();
        //TODO [HELP, INFO, VERSION]
        return true;
    }

    @Override
    public List<String> tab(CommandSender sender, String[] args, List<String> list) {
        return sender.hasPermission(permission) ? Collections.singletonList("reload") : Collections.emptyList();
    }
}
