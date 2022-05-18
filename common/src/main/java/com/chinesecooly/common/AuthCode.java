package com.chinesecooly.common;

import java.util.Random;

public class AuthCode {
    public static String generateAuthCode(int places){
        String str = "0123456789";
        StringBuilder authCode = new StringBuilder(places);
        for (int i = 0; i < places; i++) {
            //遍历4次，拿到某个字符并且拼接
            char ch = str.charAt(new Random().nextInt(str.length()));
            authCode.append(ch);
        }
        return authCode.toString();
    }
}
