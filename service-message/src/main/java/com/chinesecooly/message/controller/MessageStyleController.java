package com.chinesecooly.message.controller;

import com.chinesecooly.common.Code;
import com.chinesecooly.common.Result;
import com.chinesecooly.message.service.MessageStyleService;
import com.chinesecooly.mysql.domain.Message;
import com.chinesecooly.mysql.domain.MessageStyle;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/messageStyle")
public class MessageStyleController {

    @Resource
    private MessageStyleService messageStyleService;

    @PostMapping("/saveMessageStyle")
    public Result saveMessageStyle(@RequestBody MessageStyle messageStyle){
        messageStyleService.save(messageStyle);
        return Result.newInstance().code(Code.SUCCESS);
    }
}
