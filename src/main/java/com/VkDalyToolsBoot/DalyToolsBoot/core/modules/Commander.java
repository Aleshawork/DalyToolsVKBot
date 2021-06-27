package com.VkDalyToolsBoot.DalyToolsBoot.core.modules;

import com.vk.api.sdk.objects.messages.Message;

public class Commander {

    public static void execute(Message message) {
        CommandDefinition.getCommand(ComandManager.getCommands(),message).exec(message);
    }
}
