package com.chinesecooly.api;

import com.chinesecooly.common.Result;
import com.chinesecooly.mysql.domain.Message;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
@FeignClient("service-message")
public interface MessageAPI {

    @PostMapping("/message/deleteMessage")
    Result removeMessage(@RequestBody List<Message> messages);

}
