package com.VkDalyToolsBoot.DalyToolsBoot.core.modules;

import com.VkDalyToolsBoot.DalyToolsBoot.core.notification.commands.*;

import java.util.HashSet;

public class ComandManager {
    private static HashSet<Command> commands = new HashSet<>();


    static {
        commands.add(new Start("start"));
        commands.add(new Help("help"));
        commands.add(new Unknown("unknown"));
        commands.add(new Information("about_DalyTools"));
        commands.add(new Price("price"));
    }

    public static HashSet<Command> getCommands() {
        return commands;
    }
}
