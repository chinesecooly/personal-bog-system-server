package com.chinesecooly.user.controller;

import com.chinesecooly.common.Result;
import com.chinesecooly.mysql.domain.User;
import com.chinesecooly.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        return userService.login(user);
    }

    @GetMapping("/logout")
    public Result logout(){
        return userService.logout();
    }
}