package com.chinesecooly.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chinesecooly.mysql.domain.Role;
import com.chinesecooly.user.service.RoleService;
import com.chinesecooly.user.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【role(角色表)】的数据库操作Service实现
* @createDate 2022-04-28 21:44:00
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




