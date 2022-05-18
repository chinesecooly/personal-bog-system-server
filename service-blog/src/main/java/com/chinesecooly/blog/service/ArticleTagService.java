package com.chinesecooly.blog.service;

import com.chinesecooly.mysql.domain.ArticleTag;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chinesecooly.mysql.domain.Tag;

import java.util.List;

/**
* @author Administrator
* @description 针对表【article_tag】的数据库操作Service
* @createDate 2022-04-20 20:49:04
*/
public interface ArticleTagService extends IService<ArticleTag> {
    List<Tag> getArticleTag(Long articleId);
    int removeByArticleId(Long articleId);
}
