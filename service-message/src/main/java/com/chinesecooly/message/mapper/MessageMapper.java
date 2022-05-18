package com.chinesecooly.message.mapper;

import com.chinesecooly.mysql.domain.Message;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【message(留言表)】的数据库操作Mapper
* @createDate 2022-05-17 10:50:29
* @Entity com.chinesecooly.mysql.domain.Message
*/
@Mapper
public interface MessageMapper extends BaseMapper<Message> {

}




