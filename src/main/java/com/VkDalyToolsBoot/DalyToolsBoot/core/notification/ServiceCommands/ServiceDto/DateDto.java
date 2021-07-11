package com.VkDalyToolsBoot.DalyToolsBoot.core.notification.ServiceCommands.ServiceDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DateDto extends ServiceDtoObject{
    private String date;
    private int priority;
    private String task;



    public DateDto() {
    }
}
