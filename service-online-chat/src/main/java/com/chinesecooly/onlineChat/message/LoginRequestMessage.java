package com.chinesecooly.onlineChat.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString(callSuper = true)
@NoArgsConstructor
public class LoginRequestMessage extends Message {

    private String username;

    @Override
    public int getMessageType() {
        return LoginRequestMessage;
    }
}
