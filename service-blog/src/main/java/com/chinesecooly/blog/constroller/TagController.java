package com.chinesecooly.blog.constroller;

import com.chinesecooly.blog.service.ArticleTagService;
import com.chinesecooly.blog.service.TagService;
import com.chinesecooly.common.Code;
import com.chinesecooly.common.Result;
import com.chinesecooly.mysql.domain.Tag;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Resource
    private TagService tagService;
    @Resource
    private ArticleTagService articleTagService;

    @GetMapping("/all")
    public Result getAll(){
        List<Tag> list = tagService.list();
        return Result.newInstance().code(Code.SUCCESS).message("所有文章标签").data(list);
    }

    @GetMapping("/addTag")
    public Result addTag(@RequestParam("body") String body){
        Tag tag = new Tag();
        tag.setBody(body);
        try {
            boolean save = tagService.save(tag);
            if (save){
                return Result.newInstance().code(Code.SUCCESS).message("添加成功");
            }else {
                return Result.newInstance().code(Code.SUCCESS).message("添加失败");
            }
        } catch (Exception e) {
            return Result.newInstance().code(Code.FAILED).message("标签已存在");
        }
    }

    @PostMapping("removeTag")
    private Result removeTag(@RequestBody List<Tag> tags){
        tagService.removeByIds(tags);
        tags.forEach(tag -> {
            articleTagService.removeByTagId(tag.getId());
        });
        return Result.newInstance().message("删除成功").code(Code.SUCCESS);
    }

    @PostMapping("updateTag")
    private Result updateTag(@RequestBody Tag tag){
        boolean b = tagService.updateById(tag);
        if (b){
            return Result.newInstance().code(Code.SUCCESS).message("修改成功");
        }else {
            return Result.newInstance().code(Code.FAILED).message("修改失败");
        }
    }

}
