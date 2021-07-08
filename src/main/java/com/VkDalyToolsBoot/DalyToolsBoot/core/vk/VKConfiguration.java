package com.VkDalyToolsBoot.DalyToolsBoot.core.vk.Configuration;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class VKConfiguration {

    @Bean
    public HttpTransportClient getHttpTransportClient(){
        return  HttpTransportClient.getInstance();
    }


    @Bean
    public VkApiClient getVkApiClient(HttpTransportClient transportClient){
        //TransportClient transportClient = HttpTransportClient.getInstance();

        return new VkApiClient(transportClient);
    }


}
