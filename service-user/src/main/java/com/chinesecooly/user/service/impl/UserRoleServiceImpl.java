package com.chinesecooly.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chinesecooly.mysql.domain.UserRole;
import com.chinesecooly.user.service.UserRoleService;
import com.chinesecooly.user.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【user_role(角色权限对照表)】的数据库操作Service实现
* @createDate 2022-04-28 21:44:28
*/
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole>
    implements UserRoleService{

}




