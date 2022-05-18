package com.chinesecooly.message.controller;

import com.chinesecooly.common.Code;
import com.chinesecooly.common.Result;
import com.chinesecooly.message.service.MessageService;
import com.chinesecooly.message.service.MessageStyleService;
import com.chinesecooly.mysql.domain.Message;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Resource
    private MessageService messageService;

    @PostMapping("/saveMessage")
    public Result saveMessage(@RequestBody Message message){
        messageService.save(message);
        return Result.newInstance().code(Code.SUCCESS).message("发布成功").data(message.getId());
    }

    @GetMapping("/getMessage")
    public Result getMessage(){
        List<Message> list = messageService.list();
        return Result.newInstance().code(Code.SUCCESS).data(list);
    }

}
