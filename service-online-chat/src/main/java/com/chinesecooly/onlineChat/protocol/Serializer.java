package com.chinesecooly.onlineChat.protocol;

import com.chinesecooly.common.JSONUtil;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * 用于扩展序列化、反序列化算法
 */
public interface Serializer {

    // 反序列化方法
    <T> T deserialize(Class<T> clazz, String json);

    // 序列化方法
    <T> String serialize(T object);

    enum serializeAlgorithm implements Serializer {
        json{
            @Override
            public <T> T deserialize(Class<T> clazz,String json) {
                try {
                    return JSONUtil.fromJSON(json,clazz);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            @Override
            public <T> String serialize(T object) {
                try {
                    return JSONUtil.toJSON(object);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }
}