package com.chinesecooly.message.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chinesecooly.mysql.domain.Message;
import com.chinesecooly.message.service.MessageService;
import com.chinesecooly.message.mapper.MessageMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【message(留言表)】的数据库操作Service实现
* @createDate 2022-05-17 10:50:29
*/
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message>
    implements MessageService{

}




