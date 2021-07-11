package com.VkDalyToolsBoot.DalyToolsBoot.core.notification.ServiceCommands.ServiceDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class JwtAuthDto {

    private String username;
    private String accessToken;
    private String refreshToken;

    public JwtAuthDto() {
    }
}
