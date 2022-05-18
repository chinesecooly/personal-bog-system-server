package com.chinesecooly.onlineChat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class WSSApplication {
    public static void main(String[] args) {
        SpringApplication.run(WSSApplication.class,args);
    }
}
