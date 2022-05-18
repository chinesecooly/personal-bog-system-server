package com.chinesecooly.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chinesecooly.mysql.domain.Authority;
import com.chinesecooly.mysql.domain.RoleAuthority;
import com.chinesecooly.mysql.domain.User;
import com.chinesecooly.mysql.domain.UserRole;
import com.chinesecooly.user.dto.LoginUser;
import com.chinesecooly.user.mapper.UserMapper;
import com.chinesecooly.user.service.AuthorityService;
import com.chinesecooly.user.service.RoleAuthorityService;
import com.chinesecooly.user.service.UserRoleService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserRoleService userRoleService;
    @Resource
    private RoleAuthorityService roleAuthorityService;
    @Resource
    private AuthorityService authorityService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        //根据用户名查询用户信息
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("name", username));
        //如果查询不到数据就通过抛出异常来给出提示
        if (user == null) {
            throw new UsernameNotFoundException("用米不存在");
        }
        //根据用户查询权限信息 添加到LoginUser中
        UserRole userRole = userRoleService.getOne(new QueryWrapper<UserRole>().eq("user_id", user.getId()));
        if (userRole != null) {
            List<RoleAuthority> roleAuthorities = roleAuthorityService.list(new QueryWrapper<RoleAuthority>().eq("role_id", userRole.getRoleId()));
            if (!roleAuthorities.isEmpty()) {
                user.setUserAuthorities(new ArrayList<>());
                roleAuthorities.forEach(roleAuthority -> {
                    user.getUserAuthorities().add(authorityService.getById(roleAuthority.getAuthorityId()));
                });
                List<String> permissions = user.getUserAuthorities().stream()
                        .map(Authority::getAuthKey)
                        .collect(Collectors.toList());
                //封装成UserDetails对象返回
                return new LoginUser(user, permissions);
            }

        }
        return new LoginUser(user, new ArrayList<>());

    }
}