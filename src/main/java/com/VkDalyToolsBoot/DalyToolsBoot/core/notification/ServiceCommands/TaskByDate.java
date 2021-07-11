package com.VkDalyToolsBoot.DalyToolsBoot.core.notification.ServiceCommands;

import com.VkDalyToolsBoot.DalyToolsBoot.core.modules.Command;
import com.VkDalyToolsBoot.DalyToolsBoot.core.vk.VKManager;
import com.vk.api.sdk.objects.messages.Message;

public class TaskByDate extends Command {
    public TaskByDate(String name) {
        super(name);
    }

    @Override
    public void exec(Message message) {
        new VKManager().getTaskByDate("http://localhost:8081/api/person/task/getall"
                ,message.getPeerId());
    }
}
