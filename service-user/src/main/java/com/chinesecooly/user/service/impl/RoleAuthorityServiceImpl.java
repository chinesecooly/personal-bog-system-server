package com.chinesecooly.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chinesecooly.mysql.domain.RoleAuthority;
import com.chinesecooly.user.service.RoleAuthorityService;
import com.chinesecooly.user.mapper.RoleAuthorityMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【role_authority(角色权限对照表)】的数据库操作Service实现
* @createDate 2022-04-28 21:44:10
*/
@Service
public class RoleAuthorityServiceImpl extends ServiceImpl<RoleAuthorityMapper, RoleAuthority>
    implements RoleAuthorityService{

}




