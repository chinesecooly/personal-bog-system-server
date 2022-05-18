package com.chinesecooly.onlineChat.initializer;

import com.chinesecooly.onlineChat.handler.*;
import com.chinesecooly.onlineChat.message.LoginRequestMessage;
import com.chinesecooly.onlineChat.message.LoginResponseMessage;
import com.chinesecooly.onlineChat.protocol.MessageCodec;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.codec.http.websocketx.extensions.compression.WebSocketServerCompressionHandler;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Slf4j
public class WSSChannelInitializer extends ChannelInitializer<NioSocketChannel> {

    @Resource
    private MessageCodec messageCodec;
    @Resource
    private LoginHandler loginHandler;
    @Resource
    private ChatHandler chatHandler;
    @Resource
    private GroupCreateHandler groupCreateHandler;
    @Resource
    private GroupChatHandler groupChatHandler;
    @Resource
    private GroupJoinHandler groupJoinHandler;
    @Resource
    private GroupMembersHandler groupMembersHandler;
    @Resource
    private GroupQuitHandler groupQuitHandler;
    @Resource
    private QuitHandler quitHandler;
    @Resource
    private FreeTestHandler freeTestHandler;

    @Override
    protected void initChannel(NioSocketChannel ch) throws Exception {
        ch.pipeline().addLast(new HttpServerCodec())
                .addLast(new HttpObjectAggregator(65536))
                .addLast(new WebSocketServerCompressionHandler())
                .addLast(new WebSocketServerProtocolHandler("/ws"))
                .addLast(new IdleStateHandler(5,5,10))
                .addLast(messageCodec)
                .addLast(freeTestHandler)
                .addLast(loginHandler)
                .addLast(chatHandler)
                .addLast(groupCreateHandler)
                .addLast(groupCreateHandler)
                .addLast(groupChatHandler)
                .addLast(groupJoinHandler)
                .addLast(groupMembersHandler)
                .addLast(groupQuitHandler)
                .addLast(quitHandler);
    }
}
