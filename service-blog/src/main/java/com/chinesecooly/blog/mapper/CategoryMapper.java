package com.chinesecooly.blog.mapper;
import java.util.List;

import com.chinesecooly.mysql.domain.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Administrator
* @description 针对表【category】的数据库操作Mapper
* @createDate 2022-04-20 20:48:56
* @Entity com.chinesecooly.mysql.domain.Category
*/
public interface CategoryMapper extends BaseMapper<Category> {
    List<Category> selectIdAndBody();
}




