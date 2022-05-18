package com.chinesecooly.onlineChat.config;


import com.chinesecooly.onlineChat.WSServer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.nio.NioEventLoopGroup;
import org.springframework.boot.context.event.ApplicationContextInitializedEvent;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Configuration
public class WSSConfig  {
    @Bean
    public ServerBootstrap serverBootstrap(){
        return new ServerBootstrap();
    }

    @Bean("master")
    public NioEventLoopGroup masterNioEventLoopGroup(){
        return new NioEventLoopGroup();
    }

    @Bean("worker")
    public NioEventLoopGroup workerNioEventLoopGroup(){
        return new NioEventLoopGroup();
    }
}
