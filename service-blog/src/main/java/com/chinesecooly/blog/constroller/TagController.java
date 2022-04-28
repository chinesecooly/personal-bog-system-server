package com.chinesecooly.blog.constroller;

import com.chinesecooly.blog.service.TagService;
import com.chinesecooly.common.Code;
import com.chinesecooly.common.Result;
import com.chinesecooly.mysql.domain.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {
    @Resource
    private TagService tagService;

    @GetMapping("/all")
    public Result getAll(){
        List<Tag> list = tagService.list();
        return Result.newInstance().code(Code.SUCCESS).message("所有文章标签").data(list);
    }
}
