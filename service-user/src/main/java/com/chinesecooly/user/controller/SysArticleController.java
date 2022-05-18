package com.chinesecooly.user.controller;

import com.chinesecooly.api.ArticleAPI;
import com.chinesecooly.common.Result;
import com.chinesecooly.mysql.domain.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/sysArticle")
public class SysArticleController {

    @Resource
    private ArticleAPI articleAPI;

    @GetMapping("/sysAll")
    Result sysAll(){
        return articleAPI.sysAll();
    }

    @GetMapping("/sysDraft")
    Result sysDraft(){
        return articleAPI.sysDraft();
    }

    @GetMapping("/sysArticle")
    Result sysArticle(){
        return articleAPI.sysArticle();
    }

    @GetMapping("/sysRecycle")
    Result sysRecycle(){
        return articleAPI.sysRecycle();
    }

    @PreAuthorize("hasAuthority('delete:/sysArticle/sysDeleteById')")
    @GetMapping("/sysDeleteById")
    Result sysRecycle(@RequestParam("id")Long id){
        return articleAPI.sysDelete(id);
    }

    @GetMapping("/sysThoroughDeleteById")
    Result sysThoroughDeleteById(@RequestParam("id")Long id){
        return articleAPI.sysThoroughDeleteById(id);
    }

    @GetMapping("/recoverArticleById")
    Result recoverArticleById(@RequestParam("id")Long id){
        return articleAPI.recoverArticleById(id);
    }

    @GetMapping("/addTag")
    Result addTag(@RequestParam("body") String body){
        return articleAPI.addTag(body);
    }

    @PostMapping("/removeTag")
    Result removeTag(@RequestBody List<Tag> tags){
        return articleAPI.removeTag(tags);
    }

    @PostMapping("/updateTag")
    Result updateTag(@RequestBody Tag tag){
        return articleAPI.updateTag(tag);
    }

}
