package com.chinesecooly.blog.constroller;

import com.chinesecooly.blog.service.CategoryService;
import com.chinesecooly.common.Code;
import com.chinesecooly.common.Result;
import com.chinesecooly.mysql.domain.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    @GetMapping("/idAndBody")
    public Result getIdAndBody(){
        List<Category> list =categoryService.getIdAndBody();
        return Result.newInstance().code(Code.SUCCESS).message("所有分类").data(list);
    }
}
