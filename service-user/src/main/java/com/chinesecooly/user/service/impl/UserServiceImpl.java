package com.chinesecooly.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chinesecooly.common.Code;
import com.chinesecooly.common.JwtUtil;
import com.chinesecooly.common.Result;
import com.chinesecooly.mysql.domain.User;
import com.chinesecooly.redis.util.RedisUtil;
import com.chinesecooly.user.dto.LoginUser;
import com.chinesecooly.user.service.UserService;
import com.chinesecooly.user.mapper.UserMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
* @author Administrator
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-04-20 20:51:29
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>  implements UserService{

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private RedisUtil redisUtil;

    @Override
    public List<User> getByName(String name) {
        return baseMapper.selectByName(name);
    }

    @Override
    public Result login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getName(),user.getPwd());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("用户名或密码错误");
        }
        //使用userid生成token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        //authenticate存入redis
        redisUtil.setObject("login:"+userId,loginUser);
        //把token响应给前端
        HashMap<String,String> map = new HashMap<>();
        map.put("token",jwt);
        return Result.newInstance().code(Code.SUCCESS).message("登陆成功").data(map);
    }

    @Override
    public Result logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Long userid = loginUser.getUser().getId();
        redisUtil.deleteObject("login:"+userid);
        return Result.newInstance().code(Code.SUCCESS).message("退出成功");
    }
}




