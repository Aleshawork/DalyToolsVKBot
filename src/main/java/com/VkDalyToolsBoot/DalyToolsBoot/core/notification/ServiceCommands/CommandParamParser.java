package com.VkDalyToolsBoot.DalyToolsBoot.core.notification.ServiceCommands;

import com.VkDalyToolsBoot.DalyToolsBoot.core.notification.ServiceCommands.ServiceDto.DateDto;
import com.VkDalyToolsBoot.DalyToolsBoot.core.notification.ServiceCommands.ServiceDto.LoginDto;
import com.VkDalyToolsBoot.DalyToolsBoot.core.notification.ServiceCommands.ServiceDto.ServiceDtoObject;

public class CommandParamParser {

    public static ServiceDtoObject parseParam(String stroka){

        // Enter: AlexeyBorisov password
        if(stroka.contains("enter: ")){
            return  new LoginDto(stroka.split(" ")[1],stroka.split(" ")[2]);
        }
        // Date: year.month.day
        else if(stroka.contains("date: ")){
            return  new DateDto(stroka.split(" ")[1],0,"0");
        }
        else {
            System.out.println(String.format("Строка %s не соответствует ни одному шаблону",stroka));
        }
        return null;
    }
}
