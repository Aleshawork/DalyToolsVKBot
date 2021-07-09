package com.VkDalyToolsBoot.DalyToolsBoot.core.commands;

import com.VkDalyToolsBoot.DalyToolsBoot.core.modules.Command;
import com.VkDalyToolsBoot.DalyToolsBoot.core.vk.VKManager;
import com.vk.api.sdk.objects.messages.Message;

public class Start extends Command {
    public Start(String name) {
        super(name);
    }

    @Override
    public void exec(Message message) {
        new VKManager().sendMessege("Вас приветствует бот DalyTools !!!!",message.getPeerId()); // getUserId()

    }
}
