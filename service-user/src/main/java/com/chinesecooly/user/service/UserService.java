package com.chinesecooly.user.service;

import com.chinesecooly.common.Result;
import com.chinesecooly.mysql.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Administrator
* @description 针对表【user】的数据库操作Service
* @createDate 2022-04-20 20:51:29
*/
public interface UserService extends IService<User> {
    List<User> getByName(String name);
    Result login(User user);
    Result logout();
    Result register(User user);
    Result validUsername(String username);
    Result generateAuthCode(User user);
    Result verifyAuthCode(String username,String authCode);
}
