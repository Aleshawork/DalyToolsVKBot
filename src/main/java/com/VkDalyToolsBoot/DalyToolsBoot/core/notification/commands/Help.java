package com.VkDalyToolsBoot.DalyToolsBoot.core.notification.commands;

import com.VkDalyToolsBoot.DalyToolsBoot.core.modules.Command;
import com.VkDalyToolsBoot.DalyToolsBoot.core.vk.VKManager;
import com.vk.api.sdk.objects.messages.Message;

public class Help extends Command {
    public Help(String name) {
        super(name);
    }

    @Override
    public void exec(Message message) {
        new VKManager().sendMessege(String.format("1. %s \n2. %s",
                                                    "start - активация бота",
                                                "help - справка по командам")
                ,message.getPeerId());
    }
}
