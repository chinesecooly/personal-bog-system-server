package com.chinesecooly.user.service;

import com.chinesecooly.mysql.domain.UserRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Administrator
* @description 针对表【user_role(角色权限对照表)】的数据库操作Service
* @createDate 2022-04-28 21:44:28
*/
public interface UserRoleService extends IService<UserRole> {

    void removeByUserId(Long id);

}
