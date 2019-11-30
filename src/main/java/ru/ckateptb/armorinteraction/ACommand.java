package ru.ckateptb.armorinteraction;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public abstract class ACommand extends Command {

    public ACommand(String... cmd) {
        super(cmd[0], "", "/" + cmd[0], Arrays.asList(cmd));
        try {
            final Field commandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            commandMap.setAccessible(true);
            CommandMap cm = (CommandMap) commandMap.get(Bukkit.getServer());
            cm.register(cmd[0], this);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        return progress(commandSender, strings);
    }

    @Override
    public List<String> tabComplete(CommandSender commandSender, String s, String[] strings) {
        List<String> list = super.tabComplete(commandSender, s, strings);
        return tab(commandSender, strings, list);
    }

    public abstract boolean progress(CommandSender sender, String[] args);

    public abstract List<String> tab(CommandSender sender, String[] args, List<String> list);
}

