package com.chinesecooly.comment.constroller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chinesecooly.comment.service.CommentService;
import com.chinesecooly.common.Code;
import com.chinesecooly.common.Result;
import com.chinesecooly.mysql.domain.Comment;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    @PostMapping("/publishComment")
    public Result publishComment(@RequestBody Comment comment){
        boolean isSave = commentService.save(comment);
        if (isSave){
            return Result.newInstance().message("发布成功").code(Code.SUCCESS);
        }else {
            return Result.newInstance().message("发布失败").code(Code.FAILED);
        }
    }

    @GetMapping("getCommentByArticleId")
    public Result getCommentByArticleId(@RequestParam("articleId")Long articleId){
        QueryWrapper<Comment> commentQueryWrapper = new QueryWrapper<>();
        commentQueryWrapper.eq("article_id",articleId).isNull("father_id");
        List<Comment> list = commentService.list(commentQueryWrapper);
        Collections.reverse(list);
        return Result.newInstance().data(list).code(Code.SUCCESS);
    }

    @GetMapping("getCommentById")
    public Result getCommentById(@RequestParam("id")Long id){
        Comment comment= commentService.getById(id);
        return Result.newInstance().data(comment).code(Code.SUCCESS);
    }

    @GetMapping("/addLikeCount")
    public Result addLikeCount(@RequestParam("commentId")Long commentId){
        Comment comment = commentService.getById(commentId);
        comment.setLikeCount(comment.getLikeCount()+1);
        commentService.updateById(comment);
        return Result.newInstance().code(Code.SUCCESS);
    }

    @GetMapping("/subLikeCount")
    public Result subLikeCount(@RequestParam("commentId")Long commentId){
        Comment comment = commentService.getById(commentId);
        comment.setLikeCount(comment.getLikeCount()-1);
        commentService.updateById(comment);
        return Result.newInstance().code(Code.SUCCESS);
    }

    @GetMapping("/addReplyCount")
    public Result addReplyCount(@RequestParam("commentId")Long commentId){
        Comment comment = commentService.getById(commentId);
        comment.setReplyCount(comment.getReplyCount()+1);
        commentService.updateById(comment);
        return Result.newInstance().code(Code.SUCCESS);
    }

    @GetMapping("/getReply")
    public Result getReply(@RequestParam("articleId")Long articleId,@RequestParam("fatherId")Long fatherId){
        QueryWrapper<Comment> commentQueryWrapper = new QueryWrapper<>();
        commentQueryWrapper.eq("article_id",articleId).eq("father_id",fatherId);
        List<Comment> list = commentService.list(commentQueryWrapper);
        Collections.reverse(list);
        return Result.newInstance().code(Code.SUCCESS).data(list);
    }
}
