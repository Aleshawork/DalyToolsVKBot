package com.VkDalyToolsBoot.DalyToolsBoot.core.notification.ServiceCommands.ServiceDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginDto extends ServiceDtoObject {
    private String username;
    private String password;

    public LoginDto() {
    }
}
