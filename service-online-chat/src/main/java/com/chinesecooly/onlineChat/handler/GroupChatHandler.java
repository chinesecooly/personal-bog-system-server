package com.chinesecooly.onlineChat.handler;

import com.chinesecooly.onlineChat.message.GroupChatRequestMessage;
import com.chinesecooly.onlineChat.message.GroupChatResponseMessage;
import com.chinesecooly.onlineChat.session.GroupSessionFactory;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@ChannelHandler.Sharable
@Component
public class GroupChatHandler extends SimpleChannelInboundHandler<GroupChatRequestMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupChatRequestMessage msg) throws Exception {
        List<Channel> membersChannel = GroupSessionFactory.getGroupSession().getMembersChannel(msg.getGroupName());
        GroupChatResponseMessage groupChatResponseMessage = new GroupChatResponseMessage(msg.getFrom(), msg.getContent());
        for (Channel channel : membersChannel) {
            channel.writeAndFlush(groupChatResponseMessage);
        }
    }
}
