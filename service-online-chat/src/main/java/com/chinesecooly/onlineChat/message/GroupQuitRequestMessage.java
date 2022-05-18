package com.chinesecooly.onlineChat.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class GroupQuitRequestMessage extends Message {
    private String groupName;

    private String username;


    @Override
    public int getMessageType() {
        return GroupQuitRequestMessage;
    }
}
