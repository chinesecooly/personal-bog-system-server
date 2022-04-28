package com.chinesecooly.user.service.impl;

import com.chinesecooly.mysql.domain.Authority;
import com.chinesecooly.mysql.domain.User;
import com.chinesecooly.user.dto.LoginUser;
import com.chinesecooly.user.mapper.UserMapper;
import com.chinesecooly.user.service.UserAuthorityService;
import com.chinesecooly.user.service.UserRoleService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserAuthorityService userAuthorityService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名查询用户信息
        List<User> users = userMapper.selectByName(username);
        //如果查询不到数据就通过抛出异常来给出提示
        if(users.size()==0){
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        //根据用户查询权限信息 添加到LoginUser中
        List<Authority> authority= userAuthorityService.getAllByUserId(users.get(0).getId());
        List<String> permissions= authority.stream()
                .map(Authority::getKey)
                .collect(Collectors.toList());
        //封装成UserDetails对象返回 
        return new LoginUser(users.get(0),permissions);
    }

}