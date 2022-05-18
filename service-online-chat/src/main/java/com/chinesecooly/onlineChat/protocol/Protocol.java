package com.chinesecooly.onlineChat.protocol;
import com.chinesecooly.onlineChat.message.Message;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Data
public class Protocol {

    @Value("${wss.protocol.magic-number}")
    private String magicNumber;

    @Value("${wss.protocol.version}")
    private String version;

    @Value("${wss.protocol.serialize-algorithm}")
    private String serializeAlgorithm;

}
