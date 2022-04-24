package com.chinesecooly.blog.service;

import com.chinesecooly.mysql.domain.Article;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Administrator
* @description 针对表【article】的数据库操作Service
* @createDate 2022-04-20 21:03:06
*/
public interface ArticleService extends IService<Article> {
    void addReadCount(Long articleId);
    void addLikeCount(Long articleId);
    void addLFavoriteCount(Long articleId);
    void addCommentCount(Long articleId);
    void subLikeCount(Long articleId);
    void subLFavoriteCount(Long articleId);
    void subCommentCount(Long articleId);
}
