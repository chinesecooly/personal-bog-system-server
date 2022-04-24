package com.chinesecooly.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chinesecooly.mysql.domain.ArticleTag;
import com.chinesecooly.blog.service.ArticleTagService;
import com.chinesecooly.blog.mapper.ArticleTagMapper;
import com.chinesecooly.mysql.domain.Tag;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【article_tag】的数据库操作Service实现
* @createDate 2022-04-20 20:49:04
*/
@Service
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagMapper, ArticleTag>  implements ArticleTagService{

    @Override
    public List<Tag> getArticleTag(Long articleId) {
        return baseMapper.selectArticleTag(articleId);
    }
}




