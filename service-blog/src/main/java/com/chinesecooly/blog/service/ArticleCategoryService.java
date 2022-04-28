package com.chinesecooly.blog.service;

import com.chinesecooly.mysql.domain.ArticleCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chinesecooly.mysql.domain.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Administrator
* @description 针对表【article_category】的数据库操作Service
* @createDate 2022-04-20 20:49:14
*/
public interface ArticleCategoryService extends IService<ArticleCategory> {
    List<Category> getArticleCategory(Long articleId);
    List<ArticleCategory> selectArticleIdByCategoryId(Long categoryId);
}
