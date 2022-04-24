package com.chinesecooly.blog.mapper;

import com.chinesecooly.mysql.domain.ArticleCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chinesecooly.mysql.domain.Category;
import com.chinesecooly.mysql.domain.Tag;

import java.util.List;

/**
* @author Administrator
* @description 针对表【article_category】的数据库操作Mapper
* @createDate 2022-04-20 20:49:14
* @Entity com.chinesecooly.mysql.domain.ArticleCategory
*/
public interface ArticleCategoryMapper extends BaseMapper<ArticleCategory> {
    List<Category> selectArticleCategory(Long articleId);
}




