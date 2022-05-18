package com.chinesecooly.user.controller;

import com.chinesecooly.common.Result;
import com.chinesecooly.mysql.domain.UserRole;
import com.chinesecooly.user.service.UserRoleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/userRole")
public class UserRoleController {

    @Resource
    private UserRoleService userRoleService;

    @PostMapping("/add")
    public Result addUserRole(@RequestBody UserRole userRole) {
        return null;
    }

}
