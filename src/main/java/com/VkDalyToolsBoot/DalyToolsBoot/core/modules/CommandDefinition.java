package com.VkDalyToolsBoot.DalyToolsBoot.core.modules;

import com.VkDalyToolsBoot.DalyToolsBoot.core.commands.Unknown;
import com.vk.api.sdk.objects.messages.Message;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

@Slf4j
public class CommandDefinition {

    private static Logger logger = LoggerFactory.getLogger(CommandDefinition.class);

    public static Command getCommand(Collection<Command> comands, Message message){
        String body = message.getText(); // getBody()
        logger.info(String.format("Get new command: %s",body));
        for( Command com :comands){
            if(com.name.equals(body.split(" ")[0])){
                System.out.println(body.split(" ")[0]);
                return com;
            }
        }

        return  new Unknown("unknown");
    }
}
