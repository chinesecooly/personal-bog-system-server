package com.chinesecooly.user.mapper;
import org.apache.ibatis.annotations.Param;

import com.chinesecooly.mysql.domain.Authority;
import com.chinesecooly.mysql.domain.UserAuthority;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author Administrator
* @description 针对表【user_authority(角色权限对照表)】的数据库操作Mapper
* @createDate 2022-04-28 21:44:21
* @Entity com.chinesecooly.mysql.domain.UserAuthority
*/
public interface UserAuthorityMapper extends BaseMapper<UserAuthority> {
    List<Authority> selectAllByUserId(@Param("userId") Long userId);
}




