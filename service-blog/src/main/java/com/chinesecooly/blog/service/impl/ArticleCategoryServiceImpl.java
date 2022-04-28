package com.chinesecooly.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chinesecooly.mysql.domain.ArticleCategory;
import com.chinesecooly.blog.service.ArticleCategoryService;
import com.chinesecooly.blog.mapper.ArticleCategoryMapper;
import com.chinesecooly.mysql.domain.Category;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【article_category】的数据库操作Service实现
* @createDate 2022-04-20 20:49:14
*/
@Service
public class ArticleCategoryServiceImpl extends ServiceImpl<ArticleCategoryMapper, ArticleCategory> implements ArticleCategoryService{

    @Override
    public List<Category> getArticleCategory(Long articleId) {
        return baseMapper.selectArticleCategory(articleId);
    }

    @Override
    public List<ArticleCategory> selectArticleIdByCategoryId(Long categoryId) {
        return baseMapper.selectArticleIdByCategoryId(categoryId);
    }

}




