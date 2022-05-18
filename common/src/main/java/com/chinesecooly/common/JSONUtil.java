package com.chinesecooly.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

public class JSONUtil {

    private static ObjectMapper MAPPER = new ObjectMapper();

    static {
        //对象的所有字段全部列入
        MAPPER.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        //取消默认转换timestamps形式
        MAPPER.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //忽略空Bean转json的错误
        MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        //所有的日期格式都统一样式
        MAPPER.setDateFormat(new SimpleDateFormat());
        //忽略 在json字符串中存在，但是在java对象中不存在对应属性的情况。防止错误
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private JSONUtil() {
    }

    public static String toJSON(Object object) throws JsonProcessingException {
        if (object == null) {
            return null;
        } else {
            return object instanceof String ? (String) object : MAPPER.writeValueAsString(object);
        }
    }


    /**
     * Object TO Json String 字符串输出(输出空字符)
     *
     * @param object 对象
     * @return Json格式字符串
     */
    public static String toJSONEmpty(Object object) throws JsonProcessingException {
        if (object == null) {
            return null;
        } else {
            MAPPER.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
                @Override
                public void serialize(Object param, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
                    //设置返回null转为 空字符串""
                    jsonGenerator.writeString("");
                }
            });
            return MAPPER.writeValueAsString(object);
        }
    }


    /**
     * Json 转为 Jave Bean
     *
     * @param text  json字符串
     * @param clazz 对象类型class
     * @param <T>   对象类型
     * @return 对象类型
     */
    public static <T> T fromJSON(String text, Class<T> clazz) throws JsonProcessingException {
        if (StringUtils.isEmpty(text) || clazz == null) {
            return null;
        } else {
            return MAPPER.readValue(text, clazz);
        }
    }


    /**
     * Json 转为 Map
     *
     * @param text json
     * @param <K>  key
     * @param <V>  value
     * @return map
     */
    public static <K, V> Map<K, V> toMap(String text) throws JsonProcessingException {
        if (StringUtils.isEmpty(text)) {
            return null;
        } else {
            return toObject(text, new TypeReference<Map<K, V>>() {
            });
        }
    }


    /**
     * Json 转 List, Class 集合中泛型的类型，非集合本身
     *
     * @param text json
     * @param <T>  对象类型
     * @return List
     */
    public static <T> List<T> toList(String text) throws JsonProcessingException {
        if (StringUtils.isEmpty(text)) {
            return null;
        } else {
            return toObject(text, new TypeReference<List<T>>() {
            });
        }
    }

    /**
     * Json 转 Object
     */
    /**
     * @param text          json
     * @param typeReference TypeReference
     * @param <T>           类型
     * @return T
     */
    public static <T> T toObject(String text, TypeReference<T> typeReference) throws JsonProcessingException {
        if (StringUtils.isEmpty(text) || typeReference == null) {
            return null;
        } else {
            return (T) (typeReference.getType().equals(String.class) ? text : MAPPER.readValue(text, typeReference));
        }
    }

}
