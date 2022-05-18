package com.chinesecooly.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chinesecooly.common.*;
import com.chinesecooly.mysql.domain.RoleAuthority;
import com.chinesecooly.mysql.domain.User;
import com.chinesecooly.mysql.domain.UserRole;
import com.chinesecooly.redis.util.RedisUtil;
import com.chinesecooly.user.dto.LoginUser;
import com.chinesecooly.user.mapper.RoleAuthorityMapper;
import com.chinesecooly.user.mapper.UserRoleMapper;
import com.chinesecooly.user.service.UserService;
import com.chinesecooly.user.mapper.UserMapper;
import org.apache.commons.mail.EmailException;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2022-04-20 20:51:29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserRoleMapper userRoleMapper;
    @Resource
    private RoleAuthorityMapper roleAuthorityMapper;

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getByName(String name) {
        return baseMapper.selectByName(name);
    }

    @Override
    public Result login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getName(), user.getPwd());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        redisUtil.setObject("login:" + userId, loginUser,1,TimeUnit.DAYS);
        return Result.newInstance().code(Code.SUCCESS).message("登陆成功").data(jwt);
    }

    @Override
    public Result logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Long userid = loginUser.getUser().getId();
        redisUtil.deleteObject("login:" + userid);
        return Result.newInstance().code(Code.SUCCESS).message("退出成功");
    }

    @Override
    public Result validUsername(String username) {
        List<User> users = userMapper.selectByName(username);
        if (users.size() != 0) {
            return Result.newInstance().code(Code.FAILED).message("用户名已存在！");
        } else {
            return Result.newInstance().code(Code.SUCCESS);
        }
    }

    @Override
    public Result generateAuthCode(User user) {
        String authCode = AuthCode.generateAuthCode(5);
        redisUtil.setObject(user.getName(), authCode, 60, TimeUnit.SECONDS);
        try {
            EmailUtil.sendEmail(user.getEmail(), authCode);
            return Result.newInstance().code(Code.SUCCESS);
        } catch (EmailException e) {
            e.printStackTrace();
        }
        return Result.newInstance().code(Code.FAILED).message("获取验证码失败");
    }

    @Override
    public Result register(User user) {
        user.setPwd(passwordEncoder.encode(user.getPwd()));
        userMapper.insert(user);
        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setRoleId(1527923289131892738L);
        userRoleMapper.insert(userRole);
        return Result.newInstance().code(Code.SUCCESS).message("注册成功").data(user.getId());
    }

    @Override
    public Result verifyAuthCode(String username, String authCode) {
        String redisAuthCode = redisUtil.getObject(username);
        if (Objects.isNull(redisAuthCode)) {
            return Result.newInstance().code(Code.FAILED).message("验证码已过期，请重新获取");
        } else if (!redisAuthCode.equals(authCode)) {
            return Result.newInstance().code(Code.FAILED).message("验证码错误请重新输入");
        } else {
            return Result.newInstance().code(Code.SUCCESS);
        }
    }
}




