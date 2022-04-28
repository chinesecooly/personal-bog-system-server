package com.chinesecooly.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chinesecooly.mysql.domain.Authority;
import com.chinesecooly.mysql.domain.UserAuthority;
import com.chinesecooly.user.service.UserAuthorityService;
import com.chinesecooly.user.mapper.UserAuthorityMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【user_authority(角色权限对照表)】的数据库操作Service实现
* @createDate 2022-04-28 21:44:21
*/
@Service
public class UserAuthorityServiceImpl extends ServiceImpl<UserAuthorityMapper, UserAuthority> implements UserAuthorityService{
    @Override
    public List<Authority> getAllByUserId(Long userId) {
        return baseMapper.selectAllByUserId(userId);
    }
}




