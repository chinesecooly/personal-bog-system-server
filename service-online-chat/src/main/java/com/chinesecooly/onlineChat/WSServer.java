package com.chinesecooly.onlineChat;

import com.chinesecooly.onlineChat.initializer.WSSChannelInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.net.InetSocketAddress;

@Component
@Slf4j
public class WSServer implements ApplicationRunner {

    @Value("${wss.host}")
    private String host;
    @Value("${wss.port}")
    private int port;
    @Value("${wss.client-options.connect-timeout-millis}")
    private int connectTimeoutMillis=5000;
    @Value("${wss.server-options.so-backlog}")
    private int soBacklog=1024;
    @Value("${wss.client-options.tcp-node-lay}")
    private boolean tcpNodeLay=true;

    @Resource
    private ServerBootstrap server;
    @Resource(name = "worker")
    private NioEventLoopGroup worker;
    @Resource(name = "master")
    private NioEventLoopGroup master;
    @Resource
    private WSSChannelInitializer wssChannelInitializer;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        server
                .group(master,worker)
                .channel(NioServerSocketChannel.class)
                .childHandler(wssChannelInitializer)
                .option(ChannelOption.SO_BACKLOG,soBacklog)
                .childOption(ChannelOption.CONNECT_TIMEOUT_MILLIS,connectTimeoutMillis)
                .childOption(ChannelOption.TCP_NODELAY,tcpNodeLay)
                .bind(new InetSocketAddress(host,port));
    }
}
