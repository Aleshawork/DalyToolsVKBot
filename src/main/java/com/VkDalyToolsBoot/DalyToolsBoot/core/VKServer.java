package com.VkDalyToolsBoot.DalyToolsBoot.core;

import com.VkDalyToolsBoot.DalyToolsBoot.core.vk.Messenger;
import com.VkDalyToolsBoot.DalyToolsBoot.core.vk.VKCore;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Slf4j
public class VKServer {

    private Logger logger = LoggerFactory.getLogger(VKServer.class);

    public static VKCore vkCore;
    static {
        vkCore = new VKCore();
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Server start...");


        while (true) {
            Thread.sleep(300);

            try {
                Message message = vkCore.getMessage();
                if (message != null) {
                    ExecutorService exec = Executors.newCachedThreadPool();
                    exec.execute(new Messenger(message));
                }
            } catch (ClientException | ApiException e) {
                System.out.println("Возникли проблемы");
                final int RECONNECT_TIME = 10000;
                System.out.println("Повторное соединение через " + RECONNECT_TIME / 1000 + " секунд");
                try {
                    Thread.sleep(RECONNECT_TIME);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }

            }
        }


    }

}
