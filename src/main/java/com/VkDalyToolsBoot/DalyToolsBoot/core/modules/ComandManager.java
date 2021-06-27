package com.VkDalyToolsBoot.DalyToolsBoot.core.modules;

import com.VkDalyToolsBoot.DalyToolsBoot.core.commands.Help;
import com.VkDalyToolsBoot.DalyToolsBoot.core.commands.Start;
import com.VkDalyToolsBoot.DalyToolsBoot.core.commands.Unknown;

import java.util.HashSet;

public class ComandManager {
    private static HashSet<Command> commands = new HashSet<>();


    static {
        commands.add(new Start("start"));
        commands.add(new Help("help"));
        commands.add(new Unknown("unknown"));
    }

    public static HashSet<Command> getCommands() {
        return commands;
    }
}
