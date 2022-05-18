package com.chinesecooly.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chinesecooly.common.Code;
import com.chinesecooly.common.Result;
import com.chinesecooly.mysql.domain.*;
import com.chinesecooly.user.service.*;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private UserRoleService userRoleService;
    @Resource
    private RoleService roleService;
    @Resource
    private RoleAuthorityService roleAuthorityService;
    @Resource
    private AuthorityService authorityService;
    @Resource
    private UserAvatarService userAvatarService;

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
    public Result getUserByName(@RequestParam("name")String name){
        User user = userService.getOne(new QueryWrapper<User>().eq("name", name));
        if (user!=null){
            UserRole userRole = userRoleService.getOne(new QueryWrapper<UserRole>().eq("user_id",user.getId()));
            if (userRole!=null){
                Role role = roleService.getById(userRole.getRoleId());
                user.setRole(role);
            }
        }
        return Result.newInstance().code(Code.SUCCESS).data(user);
    }

    @GetMapping("/getUserById")
    public Result getUserById(@RequestParam("id")String id){
        User user = userService.getById(id);
        return Result.newInstance().code(Code.SUCCESS).data(user);
    }

    @GetMapping("/allUser")
    public Result getAllUser(){
        List<User> list = userService.list();
        QueryWrapper<UserRole> userRoleQueryWrapper = new QueryWrapper<>();
        QueryWrapper<RoleAuthority> roleAuthorityQueryWrapper = new QueryWrapper<>();
        list.forEach(user -> {
            userRoleQueryWrapper.eq("user_id",user.getId());
            UserRole userRole = userRoleService.getOne(userRoleQueryWrapper);
            userRoleQueryWrapper.clear();
            user.setUserRole(userRole);
            user.setRole(roleService.getById(userRole.getRoleId()));
            roleAuthorityQueryWrapper.eq("role_id",user.getUserRole().getRoleId());
            List<RoleAuthority> roleAuthorities = roleAuthorityService.list(roleAuthorityQueryWrapper);
            roleAuthorityQueryWrapper.clear();
            user.setUserAuthorities(new ArrayList<>());
            roleAuthorities.forEach(roleAuthority -> {
                user.getUserAuthorities().add(authorityService.getById(roleAuthority.getAuthorityId()));
            });
        });
        return Result.newInstance().code(Code.SUCCESS).data(list);
    }

    @PostMapping("/addUserRole")
    public Result addUserRole(@RequestParam Long userId, @RequestBody Role role) {
        UserRole userRole = new UserRole();
        userRole.setRoleId(role.getId());
        userRole.setUserId(userId);
        userRoleService.save(userRole);
        return Result.newInstance().code(Code.SUCCESS).message("修改成功");
    }

    @PostMapping("/removeUser")
    public Result removeUser(@RequestBody List<User>users){
        userService.removeByIds(users);
        users.forEach(user -> {
            userRoleService.removeByUserId(user.getId());
            userAvatarService.remove(new QueryWrapper<UserAvatar>().eq("user_id",user.getId()));
        });
        return Result.newInstance().code(Code.SUCCESS).message("删除成功");
    }

    @PostMapping("/updateUser")
    public Result updateUser(@RequestBody User user){
        userService.updateById(user);
        userRoleService.removeByUserId(user.getId());
        userRoleService.save(new UserRole(user.getId(),user.getRole().getId()));
        return Result.newInstance().code(Code.SUCCESS).message("修改成功");
    }
}