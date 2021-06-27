package com.VkDalyToolsBoot.DalyToolsBoot.core.vk;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.users.UserXtrCounters;
import com.vk.api.sdk.queries.messages.MessagesSendQuery;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class VKManager {
    public static VKCore vkCore;
    private Logger logger = LoggerFactory.getLogger(VKManager.class);

    static {

        try {
            vkCore = new VKCore();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMessege(String messege,int peerId){

        if(messege==null){
            logger.info("message is null ...");
        }

        try{
            vkCore.getVk().messages().send(vkCore.getActor()).peerId(peerId).message(messege).execute();
        } catch (ApiException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }

    }


    public MessagesSendQuery getSendQuery(){
        return vkCore.getVk().messages().send(vkCore.getActor());
    }


    public static UserXtrCounters getUserInfo(int id){
        try {
            return vkCore.getVk().users()
                    .get(vkCore.getActor())
                    .userIds(String.valueOf(id))
                    .execute()
                    .get(0);
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }
        return null;
    }



}
