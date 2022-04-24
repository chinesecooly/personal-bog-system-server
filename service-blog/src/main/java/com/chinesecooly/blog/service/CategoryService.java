package com.chinesecooly.blog.service;

import com.chinesecooly.mysql.domain.Category;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Administrator
* @description 针对表【category】的数据库操作Service
* @createDate 2022-04-20 20:48:56
*/
public interface CategoryService extends IService<Category> {
    List<Category> getIdAndBody();
}
