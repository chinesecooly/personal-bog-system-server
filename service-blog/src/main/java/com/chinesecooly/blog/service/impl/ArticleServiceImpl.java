package com.chinesecooly.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chinesecooly.mysql.domain.Article;
import com.chinesecooly.blog.service.ArticleService;
import com.chinesecooly.blog.mapper.ArticleMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author Administrator
* @description 针对表【article】的数据库操作Service实现
* @createDate 2022-04-20 21:03:06
*/
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService{

    @Transactional
    @Override
    public void addReadCount(Long articleId) {
        Article article = baseMapper.selectById(articleId);
        article.setReadCount(article.getReadCount()+1);
        baseMapper.updateById(article);
    }

    @Transactional
    @Override
    public void addLikeCount(Long articleId) {
        Article article = baseMapper.selectById(articleId);
        article.setLikeCount(article.getLikeCount()+1);
        baseMapper.updateById(article);
    }

    @Transactional
    @Override
    public void addLFavoriteCount(Long articleId) {
        Article article = baseMapper.selectById(articleId);
        article.setFavoriteCount(article.getFavoriteCount()+1);
        baseMapper.updateById(article);
    }

    @Transactional
    @Override
    public void addCommentCount(Long articleId) {
        Article article = baseMapper.selectById(articleId);
        article.setCommentCount(article.getCommentCount()+1);
        baseMapper.updateById(article);
    }

    @Transactional
    @Override
    public void subLikeCount(Long articleId) {
        Article article = baseMapper.selectById(articleId);
        article.setLikeCount(article.getLikeCount()-1);
        baseMapper.updateById(article);
    }

    @Transactional
    @Override
    public void subLFavoriteCount(Long articleId) {
        Article article = baseMapper.selectById(articleId);
        article.setFavoriteCount(article.getFavoriteCount()-1);
        baseMapper.updateById(article);
    }

    @Transactional
    @Override
    public void subCommentCount(Long articleId) {
        Article article = baseMapper.selectById(articleId);
        article.setCommentCount(article.getCommentCount()-1);
        baseMapper.updateById(article);
    }
}




