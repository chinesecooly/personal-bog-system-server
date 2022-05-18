package com.chinesecooly.comment.mapper;

import com.chinesecooly.mysql.domain.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【comment(评论表)】的数据库操作Mapper
* @createDate 2022-05-17 10:31:18
* @Entity com.chinesecooly.mysql.domain.Comment
*/
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

}




