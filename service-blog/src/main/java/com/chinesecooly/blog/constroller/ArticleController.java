package com.chinesecooly.blog.constroller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chinesecooly.blog.service.ArticleService;
import com.chinesecooly.common.Code;
import com.chinesecooly.common.Result;
import com.chinesecooly.mysql.domain.Article;
import com.chinesecooly.mysql.vo.ArticleBody;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/article")
@CrossOrigin
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @GetMapping("/page")
    public Result getPage(@RequestParam("pageNumber") Long pageNumber, @RequestParam("pageSize") Long pageSize){
        Page<Article> articlePage = new Page<>(pageNumber,pageSize);
        Page<Article> page = articleService.page(articlePage);
        List<Article> records = page.getRecords();
        return Result.newInstance().code(Code.SUCCESS).message("查询成功").data(records);
    }

    @GetMapping("/pageCount")
    public Result getPageCount(@RequestParam("pageNumber") Long pageNumber, @RequestParam("pageSize") Long pageSize){
        Page<Article> articlePage = new Page<>(pageNumber,pageSize);
        Page<Article> page = articleService.page(articlePage);
        return Result.newInstance().code(Code.SUCCESS).message("查询成功").data(page.getPages());
    }

    @PostMapping("/saveMd")
    public Result saveMd(@RequestBody ArticleBody articleBody){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
//        String fileName = dateTimeFormatter.format(LocalDateTime.now())+".md";
        String fileName = dateTimeFormatter.format(LocalDateTime.now());
        Path path = Paths.get("service-blog/src/main/resources/articles/",fileName);
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(path,StandardOpenOption.CREATE));
            objectOutputStream.writeObject(articleBody);
            return Result.newInstance().code(Code.SUCCESS).message("文章保存成功").data(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try {
//            Files.write(path,articleBody.getArticleBody().getBytes(), StandardOpenOption.CREATE);
//            return Result.newInstance().code(Code.SUCCESS).message("文章保存成功").data(fileName);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return null;
    }

    @GetMapping("/saveArticle")
    public Result saveArticle(Article article){
        boolean save = articleService.save(article);
        if (save){
            return Result.newInstance().code(Code.SUCCESS).message("发布成功").data(article.getId().toString());
        }else {
            return Result.newInstance().code(Code.FAILED).message("发布失败");
        }
    }

    @GetMapping("/articleInfo")
    public Result getArticleInfoById(@RequestParam("articleId")Long articleId){
        Article article = articleService.getById(articleId);
        return Result.newInstance().code(Code.SUCCESS).message("获取文章信息").data(article);
    }

    @GetMapping("/articleBody")
    public void getArticleBody(@RequestParam("articleId")Long articleId, HttpServletResponse response){
        Article article = articleService.getById(articleId);
        Path path = Paths.get("service-blog/src/main/resources/articles/",article.getUrl());
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(path, StandardOpenOption.READ));
            ArticleBody articleBody = (ArticleBody)objectInputStream.readObject();
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(articleBody.getArticleBody().getBytes());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
//        try {
//            byte[] bytes = Files.readAllBytes(path);
//            ServletOutputStream outputStream = response.getOutputStream();
//            outputStream.write(bytes);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @GetMapping("/addReadCount")
    public void addReadCount(@RequestParam("articleId")Long articleId){
        articleService.addReadCount(articleId);
    }

    @GetMapping("/addLikeCount")
    void addLikeCount(@RequestParam("articleId")Long articleId){
        articleService.addLikeCount(articleId);
    }

    @GetMapping("/addFavoriteCount")
    void addLFavoriteCount(@RequestParam("articleId")Long articleId){
        articleService.addLFavoriteCount(articleId);
    }

    @GetMapping("/addCommentCount")
    void addCommentCount(@RequestParam("articleId")Long articleId){
        articleService.addCommentCount(articleId);
    }

    @GetMapping("/subLikeCount")
    void subLikeCount(@RequestParam("articleId")Long articleId){
        articleService.subLikeCount(articleId);
    }

    @GetMapping("/subFavoriteCount")
    void subLFavoriteCount(@RequestParam("articleId")Long articleId){
        articleService.subLFavoriteCount(articleId);
    }

    @GetMapping("/subCommentCount")
    void subCommentCount(@RequestParam("articleId")Long articleId){
        articleService.subCommentCount(articleId);
    }

}
