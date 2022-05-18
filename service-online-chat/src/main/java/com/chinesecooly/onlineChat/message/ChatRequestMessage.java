package com.chinesecooly.onlineChat.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ChatRequestMessage extends Message {
    private String content;
    private String to;
    private String from;

    @Override
    public int getMessageType() {
        return ChatRequestMessage;
    }
}
