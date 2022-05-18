package com.chinesecooly.onlineChat;

import com.chinesecooly.onlineChat.message.LoginRequestMessage;
import com.chinesecooly.onlineChat.protocol.MessageCodec;
import com.chinesecooly.onlineChat.protocol.Serializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.net.InetSocketAddress;

@SpringBootTest
@Slf4j
public class WSSTest {
    @Test
    public void client() throws InterruptedException {

    }
}
