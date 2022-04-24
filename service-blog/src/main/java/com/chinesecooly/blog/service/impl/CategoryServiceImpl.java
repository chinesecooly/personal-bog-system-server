package com.chinesecooly.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chinesecooly.mysql.domain.Category;
import com.chinesecooly.blog.service.CategoryService;
import com.chinesecooly.blog.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【category】的数据库操作Service实现
* @createDate 2022-04-20 20:48:56
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService{

    @Override
    public List<Category> getIdAndBody() {
        return baseMapper.selectIdAndBody();
    }
}




