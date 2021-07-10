package com.VkDalyToolsBoot.DalyToolsBoot.core.notification.commands;

import com.VkDalyToolsBoot.DalyToolsBoot.core.modules.Command;
import com.VkDalyToolsBoot.DalyToolsBoot.core.notification.EnumMediaType;
import com.VkDalyToolsBoot.DalyToolsBoot.core.notification.MediaHendler;
import com.VkDalyToolsBoot.DalyToolsBoot.core.vk.VKManager;
import com.vk.api.sdk.objects.messages.Message;

public class Price extends Command {
    private final String PRICE_MESSEGE = " Предлагаем вам промокод, который предоставит вам месяц бесплатного доступа к нашему сервису";
    public Price(String name) {
        super(name);
    }

    @Override
    public void exec(Message message) {
        new VKManager().sendInformation(PRICE_MESSEGE,
                message.getPeerId(),
                MediaHendler.getMediaContent(EnumMediaType.PRICE_PAGE));
    }
}
