package com.chinesecooly.user;

import com.chinesecooly.mysql.domain.User;
import com.chinesecooly.redis.util.RedisUtil;
import com.chinesecooly.user.mapper.UserMapper;
import com.chinesecooly.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

@SpringBootTest
public class UerApplicationTest {

    @Autowired
    private UserService userService;

    @Resource
    private RedisUtil redisUtil;

    @Test
    public void pwdEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("1234");
        System.out.println(encode);
    }

    @Test
    public void selectTest(){
        System.out.println(redisUtil);
    }
}
