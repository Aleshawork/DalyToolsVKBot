package com.VkDalyToolsBoot.DalyToolsBoot.core.notification.ServiceCommands;

import com.VkDalyToolsBoot.DalyToolsBoot.core.notification.ServiceCommands.ServiceDto.LoginDto;
import com.VkDalyToolsBoot.DalyToolsBoot.core.modules.Command;
import com.VkDalyToolsBoot.DalyToolsBoot.core.vk.VKManager;
import com.vk.api.sdk.objects.messages.Message;

public class Login extends Command {

    public Login(String name) {
        super(name);
    }

    @Override
    public void exec(Message message) {

        new VKManager().loginInService("http://localhost:8081/api/auth/login"
                , message.getPeerId());
    }
}
