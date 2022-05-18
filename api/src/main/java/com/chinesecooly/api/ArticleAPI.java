package com.chinesecooly.api;

import com.chinesecooly.common.Result;
import com.chinesecooly.mysql.domain.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient("service-blog")
public interface ArticleAPI {
    @GetMapping("/article/sysAll")
    Result sysAll();

    @GetMapping("/article/sysDraft")
    Result sysDraft();

    @GetMapping("/article/sysArticle")
    Result sysArticle();

    @GetMapping("/article/sysRecycle")
    Result sysRecycle();

    @GetMapping("/article/sysDeleteById")
    Result sysDelete(@RequestParam("id")Long id);

    @GetMapping("/article/sysThoroughDeleteById")
    Result sysThoroughDeleteById(@RequestParam("id")Long id);

    @GetMapping("/article/recoverArticleById")
    Result recoverArticleById(@RequestParam("id")Long id);

    @GetMapping("/tag/addTag")
    Result addTag(@RequestParam("body") String body);

    @PostMapping("/tag/removeTag")
    Result removeTag(@RequestBody List<Tag> tags);

    @PostMapping("/tag/updateTag")
    Result updateTag(@RequestBody Tag tag);
}
