package com.chinesecooly.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chinesecooly.mysql.domain.Authority;
import com.chinesecooly.user.service.AuthorityService;
import com.chinesecooly.user.mapper.AuthorityMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【authority(权限表)】的数据库操作Service实现
* @createDate 2022-04-28 21:43:14
*/
@Service
public class AuthorityServiceImpl extends ServiceImpl<AuthorityMapper, Authority>
    implements AuthorityService{

}




