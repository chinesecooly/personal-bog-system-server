package com.chinesecooly.user.controller;

import com.chinesecooly.common.Code;
import com.chinesecooly.common.Result;
import com.chinesecooly.mysql.domain.Authority;
import com.chinesecooly.user.service.AuthorityService;
import com.chinesecooly.user.service.RoleAuthorityService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.Provider;
import java.util.List;

@RestController
@RequestMapping("/authority")
public class AuthorityController {

    @Resource
    private AuthorityService authorityService;
    @Resource
    private RoleAuthorityService roleAuthorityService;

    @PostMapping("/add")
    public Result addAuthority(@RequestBody Authority authority){
        authority.setAuthKey(authority.getName()+":"+authority.getPath());
        authorityService.save(authority);
        return Result.newInstance().message("添加成功").code(Code.SUCCESS);
    }

    @GetMapping("/all")
    public Result getAllAuthority(){
        List<Authority> list = authorityService.list();
        return Result.newInstance().code(Code.SUCCESS).data(list);
    }

    @PostMapping("/removeAuthority")
    public Result removeAuthority(@RequestBody List<Authority>authorities){
        authorityService.removeByIds(authorities);
        authorities.forEach(authority -> {
            roleAuthorityService.removeByAuthorityId(authority.getId());
        });
        return Result.newInstance().code(Code.SUCCESS).message("删除成功");
    }

    @PostMapping("/updateAuthority")
    public Result updateAuthority(@RequestBody Authority authority){
        authorityService.updateById(authority);
        return Result.newInstance().code(Code.SUCCESS).message("删除成功");
    }
}
