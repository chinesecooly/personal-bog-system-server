package com.chinesecooly.message.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chinesecooly.mysql.domain.MessageStyle;
import com.chinesecooly.message.service.MessageStyleService;
import com.chinesecooly.message.mapper.MessageStyleMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【message_style】的数据库操作Service实现
* @createDate 2022-05-18 11:18:41
*/
@Service
public class MessageStyleServiceImpl extends ServiceImpl<MessageStyleMapper, MessageStyle>
    implements MessageStyleService{

}




