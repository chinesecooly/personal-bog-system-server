package com.chinesecooly.onlineChat.protocol;

import com.chinesecooly.common.JSONUtil;
import com.chinesecooly.onlineChat.message.LoginRequestMessage;
import com.chinesecooly.onlineChat.message.LoginResponseMessage;
import com.chinesecooly.onlineChat.message.Message;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.handler.codec.MessageToMessageCodec;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Slf4j
@ChannelHandler.Sharable
@Component
public class MessageCodec extends MessageToMessageCodec<TextWebSocketFrame, Message> {

    @Resource
    private Protocol protocol;

    @Override
    protected void encode(ChannelHandlerContext ctx, Message message, List<Object> list) throws Exception {
        list.add(new TextWebSocketFrame(Serializer.serializeAlgorithm.valueOf(protocol.getSerializeAlgorithm()).serialize(message)));
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame textWebSocketFrame, List<Object> list) throws Exception {
        Integer messageType = (Integer)Objects.requireNonNull(JSONUtil.toMap(textWebSocketFrame.text())).get("messageType");
        Message message = Serializer.serializeAlgorithm.valueOf(protocol.getSerializeAlgorithm()).deserialize(Message.getMessageClass(messageType), textWebSocketFrame.text());
        list.add(message);
    }
}

