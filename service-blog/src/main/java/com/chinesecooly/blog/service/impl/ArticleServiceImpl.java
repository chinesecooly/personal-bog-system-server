package com.chinesecooly.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chinesecooly.blog.mapper.ArticleCategoryMapper;
import com.chinesecooly.mysql.domain.Article;
import com.chinesecooly.blog.service.ArticleService;
import com.chinesecooly.blog.mapper.ArticleMapper;
import com.chinesecooly.mysql.domain.ArticleCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @description 针对表【article】的数据库操作Service实现
 * @createDate 2022-04-20 21:03:06
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Resource
    private ArticleCategoryMapper articleCategoryMapper;

    @Transactional
    @Override
    public void addReadCount(Long articleId) {
        Article article = baseMapper.selectById(articleId);
        article.setReadCount(article.getReadCount() + 1);
        baseMapper.updateById(article);
    }

    @Transactional
    @Override
    public void addLikeCount(Long articleId) {
        Article article = baseMapper.selectById(articleId);
        article.setLikeCount(article.getLikeCount() + 1);
        baseMapper.updateById(article);
    }

    @Transactional
    @Override
    public void addLFavoriteCount(Long articleId) {
        Article article = baseMapper.selectById(articleId);
        article.setFavoriteCount(article.getFavoriteCount() + 1);
        baseMapper.updateById(article);
    }

    @Transactional
    @Override
    public void addCommentCount(Long articleId) {
        Article article = baseMapper.selectById(articleId);
        article.setCommentCount(article.getCommentCount() + 1);
        baseMapper.updateById(article);
    }

    @Transactional
    @Override
    public void subLikeCount(Long articleId) {
        Article article = baseMapper.selectById(articleId);
        article.setLikeCount(article.getLikeCount() - 1);
        baseMapper.updateById(article);
    }

    @Transactional
    @Override
    public void subLFavoriteCount(Long articleId) {
        Article article = baseMapper.selectById(articleId);
        article.setFavoriteCount(article.getFavoriteCount() - 1);
        baseMapper.updateById(article);
    }

    @Transactional
    @Override
    public void subCommentCount(Long articleId) {
        Article article = baseMapper.selectById(articleId);
        article.setCommentCount(article.getCommentCount() - 1);
        baseMapper.updateById(article);
    }

    @Override
    public Long getPageCount(Long pageNumber, Long pageSize, Long categoryId) {
        Page<Article> articlePage = new Page<>(pageNumber, pageSize);
        if (categoryId == -1) {
            baseMapper.selectPage(articlePage, null);
        } else {
            List<ArticleCategory> articleCategories = articleCategoryMapper.selectArticleIdByCategoryId(categoryId);
            QueryWrapper<Article> articleQueryWrapper = new QueryWrapper<>();
            if (articleCategories.size()==0){
                return 0L;
            }
            articleQueryWrapper.in(
                    "id",
                    articleCategories.stream()
                            .map(ArticleCategory::getArticleId)
                            .collect(Collectors.toList()));
            baseMapper.selectPage(articlePage, articleQueryWrapper);
        }
        return articlePage.getPages();
    }

    @Override
    public List<Article> getPage(Long pageNumber, Long pageSize, Long categoryId) {
        Page<Article> articlePage = new Page<>(pageNumber, pageSize);
        if (categoryId == -1) {
            baseMapper.selectPage(articlePage, null);
        } else {
            List<ArticleCategory> articleCategories = articleCategoryMapper.selectArticleIdByCategoryId(categoryId);
            QueryWrapper<Article> articleQueryWrapper = new QueryWrapper<>();
            if (articleCategories.size()==0){
                return new ArrayList<>();
            }
            articleQueryWrapper.in(
                    "id",
                    articleCategories.stream()
                            .map(ArticleCategory::getArticleId)
                            .collect(Collectors.toList()));
            baseMapper.selectPage(articlePage, articleQueryWrapper);
        }
        return articlePage.getRecords();
    }
}




