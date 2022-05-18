package com.chinesecooly.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chinesecooly.common.Code;
import com.chinesecooly.common.Result;
import com.chinesecooly.mysql.domain.Role;
import com.chinesecooly.mysql.domain.RoleAuthority;
import com.chinesecooly.user.service.AuthorityService;
import com.chinesecooly.user.service.RoleAuthorityService;
import com.chinesecooly.user.service.RoleService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;
    @Resource
    private RoleAuthorityService roleAuthorityService;
    @Resource
    private AuthorityService authorityService;

    @PostMapping("/add")
    public Result addAuthority(@RequestBody Role role){
        roleService.save(role);
        role.getAuthorities().forEach((authority -> {
            roleAuthorityService.save(new RoleAuthority(role.getId(),authority.getId()));
        }));
        return Result.newInstance().message("添加成功").code(Code.SUCCESS);
    }

    @GetMapping("/all")
    public Result getAllRole(){
        List<Role> list = roleService.list();
        QueryWrapper<RoleAuthority> roleAuthorityQueryWrapper = new QueryWrapper<>();
        list.forEach(role -> {
            roleAuthorityQueryWrapper.eq("role_id",role.getId());
            List<RoleAuthority> roleAuthorities = roleAuthorityService.list(roleAuthorityQueryWrapper);
            roleAuthorityQueryWrapper.clear();
            if (roleAuthorities!=null&&!roleAuthorities.isEmpty()){
                role.setAuthorities(new ArrayList<>());
                roleAuthorities.forEach(roleAuthority -> {
                    role.getAuthorities().add(authorityService.getById(roleAuthority.getAuthorityId()));
                });
            }
        });
        return Result.newInstance().code(Code.SUCCESS).data(list);
    }

    @PostMapping("/removeRole")
    public Result removeRole(@RequestBody List<Role>roles){
        roleService.removeByIds(roles);
        roles.forEach(role -> {
            roleAuthorityService.removeByRoleId(role.getId());
        });
        return Result.newInstance().code(Code.SUCCESS).message("删除成功");
    }

    @PostMapping("/updateRole")
    public Result updateRole(@RequestBody Role role){
        roleService.updateById(role);
        roleAuthorityService.removeByRoleId(role.getId());
        role.getAuthorities().forEach(authority -> {
            roleAuthorityService.save(new RoleAuthority(role.getId(),authority.getId()));
        });
        return Result.newInstance().code(Code.SUCCESS).message("修改成功");
    }

    @GetMapping("/getRoleById")
    public Result getRoleById(@RequestParam("id")Long id){
        Role role = roleService.getById(id);
        return Result.newInstance().code(Code.SUCCESS).data(role);
    }
}
