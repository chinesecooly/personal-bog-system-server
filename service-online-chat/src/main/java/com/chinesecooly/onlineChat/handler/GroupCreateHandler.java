package com.chinesecooly.onlineChat.handler;

import com.chinesecooly.onlineChat.message.GroupCreateRequestMessage;
import com.chinesecooly.onlineChat.message.GroupCreateResponseMessage;
import com.chinesecooly.onlineChat.message.Message;
import com.chinesecooly.onlineChat.session.Group;
import com.chinesecooly.onlineChat.session.GroupSessionFactory;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@ChannelHandler.Sharable
@Component
public class GroupCreateHandler extends SimpleChannelInboundHandler<GroupCreateRequestMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupCreateRequestMessage msg) throws Exception {
        Group group = GroupSessionFactory.getGroupSession().createGroup(msg.getGroupName(), msg.getMembers());
        GroupCreateResponseMessage groupCreateResponseMessage;
        if (Objects.nonNull(group)){
            groupCreateResponseMessage = new GroupCreateResponseMessage(true, "您已被拉入"+msg.getGroupName()+"群");
            List<Channel> membersChannel = GroupSessionFactory.getGroupSession().getMembersChannel(msg.getGroupName());
            for (Channel channel : membersChannel) {
                channel.writeAndFlush(groupCreateResponseMessage);
            }
            groupCreateResponseMessage = new GroupCreateResponseMessage(true, "创建成功");
        }else {
            groupCreateResponseMessage = new GroupCreateResponseMessage(false, "群聊已存在");
        }
        ctx.writeAndFlush(groupCreateResponseMessage);
    }
}
