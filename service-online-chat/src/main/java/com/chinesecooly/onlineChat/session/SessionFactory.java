package com.chinesecooly.onlineChat.session;

import com.chinesecooly.onlineChat.session.impl.SessionMemoryImpl;
import org.springframework.stereotype.Component;

public abstract class SessionFactory {

    private static Session session = new SessionMemoryImpl();

    public static Session getSession() {
        return session;
    }
}