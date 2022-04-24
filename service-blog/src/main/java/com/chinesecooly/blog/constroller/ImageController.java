package com.chinesecooly.blog.constroller;

import com.chinesecooly.blog.service.ArticleService;
import com.chinesecooly.common.Code;
import com.chinesecooly.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@RestController
@CrossOrigin
@RequestMapping("/image")
public class ImageController {

    @PostMapping("/saveImage")
    public Result saveImage( @RequestParam("image") MultipartFile file){
        if (!file.isEmpty()){
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
            String fileName = dateTimeFormatter.format(LocalDateTime.now())+".jpg";
            Path path = Paths.get("service-blog/src/main/resources/imgs/",fileName);
            try {
                Files.createFile(path);
                Files.write(path,file.getBytes(), StandardOpenOption.CREATE);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return Result.newInstance().code(Code.SUCCESS).message("保存成功").data(fileName);
        }else {
            return Result.newInstance().code(Code.FAILED).message("保存失败").data(null);
        }
    }

    @GetMapping("/getImage/{imageName}")
    public void getImage(@PathVariable("imageName") String imageName, HttpServletResponse response){
        Path path = Paths.get("service-blog/src/main/resources/imgs/",imageName);
        try {
            response.getOutputStream().write(Files.readAllBytes(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/removeImage/{imageName}")
    public void removeImage(@PathVariable("imageName") String imageName){
        Path path = Paths.get("service-blog/src/main/resources/imgs/",imageName);
        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
