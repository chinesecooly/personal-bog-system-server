package com.chinesecooly.user.service;

import com.chinesecooly.mysql.domain.Authority;
import com.chinesecooly.mysql.domain.UserAuthority;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Administrator
* @description 针对表【user_authority(角色权限对照表)】的数据库操作Service
* @createDate 2022-04-28 21:44:21
*/
public interface UserAuthorityService extends IService<UserAuthority> {
    List<Authority> getAllByUserId(Long userId);
}
