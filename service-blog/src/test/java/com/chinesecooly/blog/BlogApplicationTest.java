package com.chinesecooly.blog;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chinesecooly.blog.service.ArticleService;
import com.chinesecooly.blog.service.CategoryService;
import com.chinesecooly.blog.service.TagService;
import com.chinesecooly.mysql.domain.Article;
import com.chinesecooly.mysql.domain.Category;
import com.chinesecooly.mysql.domain.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;

import javax.xml.bind.SchemaOutputResolver;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Objects;

@SpringBootTest
public class BlogApplicationTest {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TagService tagService;

    @Test
    public void addArticle(){
//        for (int i = 0; i < 10; i++) {
//            Article article = new Article();
//            article.setUrl("url"+"-"+i);
//            article.setTitle("title"+"-"+i);
//            article.setDescription("description"+"-"+i);
//            articleService.save(article);
//        }
    }

    @Test
    public void page(){
        Page<Article> articlePage = new Page<>(2,4);
        Page<Article> page = articleService.page(articlePage);
        List<Article> records = page.getRecords();
        System.out.println(records.size());
        System.out.println(page.getPages());
    }

    @Test
    public void addCategory(){
        for (int i = 0; i < 5; i++) {
            Category category = new Category();
            category.setBody("category-"+i);
            categoryService.save(category);
        }
    }

    @Test
    public void addTag(){
        for (int i = 0; i < 5; i++) {
            Tag tag = new Tag();
            tag.setBody("tag-"+i);
            tagService.save(tag);
        }
    }
}
