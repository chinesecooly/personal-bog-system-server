package com.chinesecooly.onlineChat.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString(callSuper = true)
public class PingMessage extends Message{
    @Override
    public int getMessageType() {
        return PingMessage;
    }
}
