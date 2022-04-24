package com.chinesecooly.blog.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import java.util.Date;

import com.chinesecooly.mysql.domain.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Administrator
* @description 针对表【article】的数据库操作Mapper
* @createDate 2022-04-20 21:03:06
* @Entity com.chinesecooly.mysql.domain.Article
*/
public interface ArticleMapper extends BaseMapper<Article> {

}




