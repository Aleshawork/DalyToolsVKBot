package com.VkDalyToolsBoot.DalyToolsBoot.core;

import com.VkDalyToolsBoot.DalyToolsBoot.core.VKServer;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(App.class, args);
        try {
            VKServer.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
