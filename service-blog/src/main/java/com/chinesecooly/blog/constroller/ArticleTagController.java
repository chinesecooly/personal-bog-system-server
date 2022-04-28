package com.chinesecooly.blog.constroller;

import com.chinesecooly.blog.service.ArticleTagService;
import com.chinesecooly.common.Code;
import com.chinesecooly.common.Result;
import com.chinesecooly.mysql.domain.ArticleTag;
import com.chinesecooly.mysql.domain.Tag;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/articleTag")
public class ArticleTagController {
    @Resource
    private ArticleTagService articleTagService;

    @PostMapping("/saveArticleTag")
    public Result saveArticleTag(@RequestParam("articleId")Long articleId,@RequestBody List<ArticleTag> articleTags){
        for (ArticleTag articleTag : articleTags) {
            articleTag.setArticleId(articleId);
            articleTagService.save(articleTag);
        }
        return Result.newInstance().code(Code.SUCCESS).message("发布成功");
    }

    @GetMapping("/getArticleTag")
    public Result getArticleTag(@RequestParam("articleId")Long articleId){
        List<Tag> articleTag = articleTagService.getArticleTag(articleId);
        return Result.newInstance().code(Code.SUCCESS).message("文章标签").data(articleTag);
    }
}
