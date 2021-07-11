package com.VkDalyToolsBoot.DalyToolsBoot.core.vk;

import com.VkDalyToolsBoot.DalyToolsBoot.core.notification.ServiceCommands.CommandParamParser;
import com.VkDalyToolsBoot.DalyToolsBoot.core.notification.ServiceCommands.ServiceCommandExecuter;
import com.VkDalyToolsBoot.DalyToolsBoot.core.notification.ServiceCommands.ServiceDto.AllTaskDto;
import com.VkDalyToolsBoot.DalyToolsBoot.core.notification.ServiceCommands.ServiceDto.JwtAuthDto;
import com.VkDalyToolsBoot.DalyToolsBoot.core.notification.ServiceCommands.TokenHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.*;
import com.vk.api.sdk.objects.users.responses.GetResponse;
import com.vk.api.sdk.queries.messages.MessagesSendQuery;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.security.KeyStore;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
public class VKManager {
    public static VKCore vkCore;
    private Logger logger = LoggerFactory.getLogger(VKManager.class);
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    static {

        try {
            vkCore = new VKCore();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendInformation(String messege,int peerId,String media){
        if(messege!=null){
            logger.info("Messege is null ...");
        }
        try{
            vkCore.getVk().messages()
                    .send(vkCore.getActor())
                    .peerId(peerId)
                    .attachment(media) // медиа находится на странице сообщества
                    .message(messege)
                    .randomId((int) new Date().getTime())
                    .execute();

        } catch (ApiException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    public void sendMessege(String messege,int peerId){

        if(messege==null){
            logger.info("Message is null ...");
        }

        try{

            // добавляем клавиатуру, которая отправляется при каждом messege
            vkCore.getVk().messages().send(vkCore.getActor()).peerId(peerId).message(messege).randomId((int) new Date().getTime()).keyboard(new Keyboard().setButtons(
                     List.of( List.of(
                             new KeyboardButton().setColor(KeyboardButtonColor.PRIMARY)
                                .setAction(new KeyboardButtonAction().setLabel("help").setType(TemplateActionTypeNames.TEXT)),
                             new KeyboardButton().setColor(KeyboardButtonColor.DEFAULT)
                                     .setAction(new KeyboardButtonAction().setLabel("about_DalyTools").setType(TemplateActionTypeNames.TEXT)),
                             new KeyboardButton().setColor(KeyboardButtonColor.POSITIVE)
                                     .setAction(new KeyboardButtonAction().setLabel("price").setType(TemplateActionTypeNames.TEXT)),
                             new KeyboardButton().setColor(KeyboardButtonColor.POSITIVE)
                                     .setAction(new KeyboardButtonAction().setLabel("login").setType(TemplateActionTypeNames.TEXT))

            )))).execute();
        } catch (ApiException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }

    }

    public void loginInService(String url,int peerId){

            try{

            Content content = Request.Post(url)
                    .bodyString(
                             gson.toJson(ServiceCommandExecuter.getLoginParam(vkCore,peerId))
                            ,ContentType.APPLICATION_JSON)
                                    .setHeader("Content-Type","application/json;charset=UTF-8")
                                    .execute().returnContent();


                JwtAuthDto jwtAuthDto = gson.fromJson(content.asString(),JwtAuthDto.class);
                TokenHandler.addNewToken(peerId,jwtAuthDto.getAccessToken());
                System.out.println(String.format("Get access token : %s  peer_id: %d",jwtAuthDto.getAccessToken(),peerId));

                vkCore.getVk().messages().send(vkCore.getActor()).peerId(peerId).message("Добро подаловать в личный аккаунт ").randomId((int) new Date().getTime()).keyboard(new Keyboard().setOneTime(false).setButtons(
                        List.of( List.of(
                                new KeyboardButton().setColor(KeyboardButtonColor.DEFAULT)
                                        .setAction(new KeyboardButtonAction().setLabel("addTask").setType(TemplateActionTypeNames.TEXT)),
                                new KeyboardButton().setColor(KeyboardButtonColor.DEFAULT)
                                        .setAction(new KeyboardButtonAction().setLabel("findTaskByDate").setType(TemplateActionTypeNames.TEXT)),
                                new KeyboardButton().setColor(KeyboardButtonColor.DEFAULT)
                                        .setAction(new KeyboardButtonAction().setLabel("findTaskByPeriod").setType(TemplateActionTypeNames.TEXT))

                        )))).execute();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ApiException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }

    }

    public void getTaskByDate(String url,int peerId){

        try{
            String accessToken = TokenHandler.getToken(peerId);
            System.out.println("Bearer "+accessToken);
            Content content = Request.Post(url)
                    .bodyString(
                            gson.toJson(ServiceCommandExecuter.getDateParam(vkCore,peerId))
                            ,ContentType.APPLICATION_JSON)
                    .setHeader("Authorization","Bearer "+accessToken)
                    .setHeader("Content-Type","application/json;charset=cp1251")
                    .execute().returnContent();


            System.out.println(content.toString());
            StringBuffer stringBuffer = new StringBuffer();
            AllTaskDto allTaskDto = gson.fromJson(content.asString(),AllTaskDto.class);
            for(Map.Entry entry : allTaskDto.getMapOfTask().entrySet()){
                stringBuffer.append(entry.getKey()+". "+entry.getValue()+"\n");
            }
            String allTask = stringBuffer.toString();
            System.out.println(String.format("Get allTask: %s",allTask));

            vkCore.getVk().messages().send(vkCore.getActor()).peerId(peerId).message(allTask).randomId((int) new Date().getTime()).keyboard(new Keyboard().setButtons(
                    List.of( List.of(
                            new KeyboardButton().setColor(KeyboardButtonColor.DEFAULT)
                                    .setAction(new KeyboardButtonAction().setLabel("addTask").setType(TemplateActionTypeNames.TEXT)),
                            new KeyboardButton().setColor(KeyboardButtonColor.DEFAULT)
                                    .setAction(new KeyboardButtonAction().setLabel("findTaskByDate").setType(TemplateActionTypeNames.TEXT)),
                            new KeyboardButton().setColor(KeyboardButtonColor.DEFAULT)
                                    .setAction(new KeyboardButtonAction().setLabel("findTaskByPeriod").setType(TemplateActionTypeNames.TEXT))

                    )))).execute();


        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ApiException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }

    }


    public MessagesSendQuery getSendQuery(){
        return vkCore.getVk().messages().send(vkCore.getActor());
    }


    public static GetResponse getUserInfo(int id){
        try {
            return vkCore.getVk().users()
                    .get(vkCore.getActor())
                    .userIds(String.valueOf(id))
                    .execute()
                    .get(0);
        } catch (ApiException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return null;
    }



}
