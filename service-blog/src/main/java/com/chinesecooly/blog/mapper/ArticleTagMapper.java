package com.chinesecooly.blog.mapper;
import org.apache.ibatis.annotations.Param;

import com.chinesecooly.mysql.domain.ArticleTag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chinesecooly.mysql.domain.Tag;

import java.util.List;

/**
* @author Administrator
* @description 针对表【article_tag】的数据库操作Mapper
* @createDate 2022-04-20 20:49:04
* @Entity com.chinesecooly.mysql.domain.ArticleTag
*/
public interface ArticleTagMapper extends BaseMapper<ArticleTag> {
    List<Tag> selectArticleTag(Long articleId);
    int deleteByArticleId(@Param("articleId") Long articleId);
}




