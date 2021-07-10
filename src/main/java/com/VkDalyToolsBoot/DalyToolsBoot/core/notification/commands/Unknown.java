package com.VkDalyToolsBoot.DalyToolsBoot.core.notification.commands;

import com.VkDalyToolsBoot.DalyToolsBoot.core.modules.Command;
import com.VkDalyToolsBoot.DalyToolsBoot.core.vk.VKManager;
import com.vk.api.sdk.objects.messages.Message;

public class Unknown extends Command {
    private final String UNKNOWN_MESSEGE = "Данная команда не существует, повторите попытку";
    public Unknown(String name) {
        super(name);
    }

    @Override
    public void exec(Message message) {
        new VKManager().sendMessege( UNKNOWN_MESSEGE
                , message.getPeerId());
    }
}
