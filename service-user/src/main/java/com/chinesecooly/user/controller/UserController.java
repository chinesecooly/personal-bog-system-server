package com.chinesecooly.user.controller;

import com.chinesecooly.common.Code;
import com.chinesecooly.common.Result;
import com.chinesecooly.mysql.domain.User;
import com.chinesecooly.user.service.UserService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

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

    @PostMapping("/register")
    public Result register(@RequestBody User user){
        return userService.register(user);
    }

    @GetMapping("/validUsername")
    public Result validUsername(@RequestParam("username")String username){
        return userService.validUsername(username);
    }

    @PostMapping("/generateAuthCode")
    public Result generateAuthCode(@RequestBody User user){
        return userService.generateAuthCode(user);
    }

    @GetMapping("/verifyAuthCode")
    public Result verifyAuthCode(@RequestParam("username")String username,@RequestParam("authCode")String authCode){
        return userService.verifyAuthCode(username,authCode);
    }

    @GetMapping("/getUserByName")
    public Result getSUerByName(@RequestParam("name")String name){
        List<User> users= userService.getByName(name);
        return Result.newInstance().code(Code.SUCCESS).data(users.get(0));
    }

    @GetMapping("/getUserById")
    public Result getUserById(@RequestParam("id")String id){
        User user = userService.getById(id);
        return Result.newInstance().code(Code.SUCCESS).data(user);
    }

    @GetMapping("/allUser")
    public Result getAllUser(){
        List<User> list = userService.list();
        return Result.newInstance().code(Code.SUCCESS).data(list);
    }
}