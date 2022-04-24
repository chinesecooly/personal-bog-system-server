package com.chinesecooly.comment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chinesecooly.mysql.domain.Comment;
import com.chinesecooly.comment.service.CommentService;
import com.chinesecooly.comment.mapper.CommentMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【comment】的数据库操作Service实现
* @createDate 2022-04-18 11:43:03
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService{

}




