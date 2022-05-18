package com.chinesecooly.user.controller;

import com.chinesecooly.api.MessageAPI;
import com.chinesecooly.common.Result;
import com.chinesecooly.mysql.domain.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/sysMessage")
public class SysMessageController {

    @Resource
    private MessageAPI messageApi;

    @PostMapping("/deleteMessage")
    Result removeMessage(@RequestBody List<Message> messages){
        return messageApi.removeMessage(messages);
    }
}
