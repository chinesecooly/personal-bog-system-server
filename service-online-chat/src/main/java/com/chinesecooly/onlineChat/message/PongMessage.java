package com.chinesecooly.onlineChat.message;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class PongMessage extends AbstractResponseMessage{
    @Override
    public int getMessageType() {
        return PongMessage;
    }
}
