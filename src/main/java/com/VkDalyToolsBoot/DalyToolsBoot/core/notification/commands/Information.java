package com.VkDalyToolsBoot.DalyToolsBoot.core.notification.commands;

import com.VkDalyToolsBoot.DalyToolsBoot.core.modules.Command;
import com.VkDalyToolsBoot.DalyToolsBoot.core.notification.EnumMediaType;
import com.VkDalyToolsBoot.DalyToolsBoot.core.notification.MediaHendler;
import com.VkDalyToolsBoot.DalyToolsBoot.core.vk.VKManager;
import com.vk.api.sdk.objects.messages.Message;

public class Information extends Command {
    private final String INFORMATION_MESSEGE = " Добро пожаловать в сервис заметок DalyTolls \n"+
                            "Сервис позволяет удобно создавать и редактировать заметки ." +
                            "Обязательно воспользуйтесь нашим сервисом !";

    public Information(String name) {
        super(name);
    }

    @Override
    public void exec(Message message) {
        new VKManager().sendInformation(INFORMATION_MESSEGE
                ,message.getPeerId()
                , MediaHendler.getMediaContent(EnumMediaType.INFORMATION_PAGE));

    }
}
