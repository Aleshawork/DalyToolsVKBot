package com.VkDalyToolsBoot.DalyToolsBoot.core.notification.ServiceCommands.ServiceDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.HashMap;

@Data
@AllArgsConstructor
public class AllTaskDto {
    private String date;
    private HashMap<Integer,String> mapOfTask;

    public AllTaskDto() {
    }
}
