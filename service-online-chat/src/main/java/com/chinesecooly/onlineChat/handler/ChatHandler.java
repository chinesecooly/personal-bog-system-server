package com.chinesecooly.onlineChat.handler;

import com.chinesecooly.onlineChat.message.ChatRequestMessage;
import com.chinesecooly.onlineChat.message.ChatResponseMessage;
import com.chinesecooly.onlineChat.message.Message;
import com.chinesecooly.onlineChat.session.SessionFactory;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@ChannelHandler.Sharable
public class ChatHandler extends SimpleChannelInboundHandler<ChatRequestMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ChatRequestMessage msg) throws Exception {
        String to = msg.getTo();
        Channel channel = SessionFactory.getSession().getChannel(to);
        ChatResponseMessage chatResponseMessage = new ChatResponseMessage(true, "发送成功");
        chatResponseMessage.setFrom(msg.getFrom());
        chatResponseMessage.setContent(msg.getContent());
        if (channel!=null){
            channel.writeAndFlush(chatResponseMessage);
        }else {

        }
    }
}
