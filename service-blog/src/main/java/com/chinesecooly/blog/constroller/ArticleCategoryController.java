package com.chinesecooly.blog.constroller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chinesecooly.blog.service.ArticleCategoryService;
import com.chinesecooly.common.Code;
import com.chinesecooly.common.Result;
import com.chinesecooly.mysql.domain.ArticleCategory;
import com.chinesecooly.mysql.domain.Category;
import com.chinesecooly.mysql.domain.Tag;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/articleCategory")
public class ArticleCategoryController {
    @Resource
    private ArticleCategoryService articleCategoryService;

    @PostMapping("/saveArticleCategory")
    public Result saveArticleCategory(@RequestParam("articleId")Long articleId, @RequestBody List<ArticleCategory> articleCategory){
        articleCategoryService.removeByArticleId(articleId);
        for (ArticleCategory category : articleCategory) {
            category.setArticleId(articleId);
            articleCategoryService.save(category);
        }
        return Result.newInstance().code(Code.SUCCESS).message("发布成功");
    }

    @GetMapping("/getArticleCategory")
    public Result getArticleCategory(@RequestParam("articleId")Long articleId){
        List<Category> articleCategory = articleCategoryService.getArticleCategory(articleId);
        return Result.newInstance().code(Code.SUCCESS).message("文章标签").data(articleCategory);
    }

    @GetMapping("/getArticleCountByArticleId")
    public Result getArticleCountByArticleId(@RequestParam("categoryId")Long categoryId){
        QueryWrapper<ArticleCategory> articleCategoryQueryWrapper = new QueryWrapper<>();
        articleCategoryQueryWrapper.eq("category_id",categoryId);
        long count = articleCategoryService.count(articleCategoryQueryWrapper);
        return Result.newInstance().data(count);
    }
}
