package com.chinesecooly.user.mapper;

import com.chinesecooly.mysql.domain.RoleAuthority;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
* @author Administrator
* @description 针对表【role_authority(角色权限对照表)】的数据库操作Mapper
* @createDate 2022-04-28 21:44:10
* @Entity com.chinesecooly.mysql.domain.RoleAuthority
*/
public interface RoleAuthorityMapper extends BaseMapper<RoleAuthority> {

    int deleteByAuthorityId(@Param("authorityId") Long authorityId);

    int deleteByRoleId(@Param("roleId") Long roleId);
}




