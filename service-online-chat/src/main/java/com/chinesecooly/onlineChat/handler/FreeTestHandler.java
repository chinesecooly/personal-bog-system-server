package com.chinesecooly.onlineChat.handler;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import org.springframework.stereotype.Component;

@Component
@ChannelHandler.Sharable
public class FreeTestHandler extends ChannelDuplexHandler {
    //响应特殊事件
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent){
            IdleStateEvent idleStateEvent=(IdleStateEvent) evt;
            if (idleStateEvent.state()== IdleState.READER_IDLE){

            }else if (idleStateEvent.state()==IdleState.WRITER_IDLE){

            }else {

            }
        }
    }
}
