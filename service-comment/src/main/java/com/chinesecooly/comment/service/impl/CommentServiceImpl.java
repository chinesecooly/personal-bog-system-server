package com.chinesecooly.comment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chinesecooly.mysql.domain.Comment;
import com.chinesecooly.comment.service.CommentService;
import com.chinesecooly.comment.mapper.CommentMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【comment(评论表)】的数据库操作Service实现
* @createDate 2022-05-17 10:31:18
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService{

}




