package com.VkDalyToolsBoot.DalyToolsBoot.core.notification.ServiceCommands;

import java.util.HashMap;

public class TokenHandler {
    private  static HashMap<Integer,String> mapOfToken= new HashMap<>();

    public static void addNewToken(Integer peer_id,String token){
        mapOfToken.put(peer_id,token);
    }

    public static String getToken(int peer_id){
        if(mapOfToken.isEmpty()) return null;
        return mapOfToken.get(peer_id);
    }



}
