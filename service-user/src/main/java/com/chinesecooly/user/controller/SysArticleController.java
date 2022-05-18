package com.chinesecooly.user.controller;

import com.chinesecooly.api.ArticleAPI;
import com.chinesecooly.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

}
