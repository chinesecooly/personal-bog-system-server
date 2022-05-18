package com.chinesecooly.onlineChat.handler;

import com.chinesecooly.onlineChat.message.LoginRequestMessage;
import com.chinesecooly.onlineChat.message.LoginResponseMessage;
import com.chinesecooly.onlineChat.session.SessionFactory;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

@Component
@ChannelHandler.Sharable
public class LoginHandler extends SimpleChannelInboundHandler<LoginRequestMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestMessage msg) throws Exception {
        LoginResponseMessage loginResponseMessage=new LoginResponseMessage(true, "您已上线");
        SessionFactory.getSession().bind(ctx.channel(),msg.getUsername());
        ctx.writeAndFlush(loginResponseMessage);
    }
}
