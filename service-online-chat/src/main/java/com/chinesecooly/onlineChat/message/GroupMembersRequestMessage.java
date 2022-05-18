package com.chinesecooly.onlineChat.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class GroupMembersRequestMessage extends Message {
    private String groupName;

    @Override
    public int getMessageType() {
        return GroupMembersRequestMessage;
    }
}
