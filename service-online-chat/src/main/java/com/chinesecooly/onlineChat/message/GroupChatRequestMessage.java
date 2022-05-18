package com.chinesecooly.onlineChat.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class GroupChatRequestMessage extends Message {
    private String content;
    private String groupName;
    private String from;

    @Override
    public int getMessageType() {
        return GroupChatRequestMessage;
    }
}
