package com.chinesecooly.onlineChat.session;

import com.chinesecooly.onlineChat.session.impl.GroupSessionMemoryImpl;
import org.springframework.stereotype.Component;

public abstract class GroupSessionFactory {

    private static GroupSession session = new GroupSessionMemoryImpl();

    public static GroupSession getGroupSession() {
        return session;
    }
}