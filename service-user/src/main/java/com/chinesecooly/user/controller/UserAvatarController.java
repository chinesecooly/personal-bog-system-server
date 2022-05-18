package com.chinesecooly.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chinesecooly.common.Code;
import com.chinesecooly.common.Result;
import com.chinesecooly.mysql.domain.UserAvatar;
import com.chinesecooly.user.service.UserAvatarService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/userAvatar")
public class UserAvatarController {

    @Resource
    private UserAvatarService userAvatarService;

    @PostMapping("/saveAvatar")
    public Result saveAvatar(@RequestBody UserAvatar userAvatar){
        userAvatarService.save(userAvatar);
        return Result.newInstance().code(Code.SUCCESS).message("保存成功");
    }

    @GetMapping("/getAvatarByUserId")
    public  Result getAvatarByUserId(@RequestParam("userId")Long userId){
        UserAvatar avatar = userAvatarService.getOne(new QueryWrapper<UserAvatar>().eq("user_id", userId));
        return Result.newInstance().code(Code.SUCCESS).data(avatar);
    }
}
