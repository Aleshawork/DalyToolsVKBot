package com.VkDalyToolsBoot.DalyToolsBoot.core.notification.ServiceCommands;

import com.VkDalyToolsBoot.DalyToolsBoot.core.notification.ServiceCommands.ServiceDto.ServiceDtoObject;
import com.VkDalyToolsBoot.DalyToolsBoot.core.vk.VKCore;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;

import java.util.Date;

public class ServiceCommandExecuter {

    private final static String LOGIN_MESSAGE ="Для входа введите login и password от вашего аккаунта\n\n"+
            "Вводимая строка должна соответстваовать шаблону:\n\nenter: login password";
    private final static   String DATA_MESSAGE = "Введите дату\n\nВводимая дата должна соответстваовать шаблону:\n\ndate: year-month-day";


    public static ServiceDtoObject getLoginParam(VKCore vkCore, int peerId){


        try {
            while(true) {
                vkCore.getVk().messages()
                        .send(vkCore.getActor())
                        .peerId(peerId)
                        .message(LOGIN_MESSAGE)
                        .randomId((int) new Date().getTime())
                        .execute();
                Message message = null;


                while (message == null) {
                    Thread.sleep(100);
                    message = vkCore.getMessage();

                }

                String str_message = message.getText();
                System.out.println(str_message);

                ServiceDtoObject serviceDtoObject=CommandParamParser.parseParam(str_message);
                if(serviceDtoObject!=null) return serviceDtoObject;

            }

        } catch (ApiException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public static  ServiceDtoObject getDateParam(VKCore vkCore, int peerId){
        try{
            while(true){
                vkCore.getVk().messages()
                        .send(vkCore.getActor())
                        .peerId(peerId)
                        .message(DATA_MESSAGE)
                        .randomId((int) new Date().getTime())
                        .execute();
                Message message = null;

                while (message == null) {
                    Thread.sleep(100);
                    message = vkCore.getMessage();
                }
                String str_message = message.getText();
                System.out.println(str_message);

                ServiceDtoObject serviceDtoObject=CommandParamParser.parseParam(str_message);
                if(serviceDtoObject!=null) return serviceDtoObject;
            }
        } catch (ApiException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
