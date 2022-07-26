package com.chinesecooly.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chinesecooly.mysql.domain.UserAvatar;
import com.chinesecooly.user.service.UserAvatarService;
import com.chinesecooly.user.mapper.UserAvatarMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【user_avatar(用户头像表)】的数据库操作Service实现
* @createDate 2022-05-29 12:17:36
*/
@Service
public class UserAvatarServiceImpl extends ServiceImpl<UserAvatarMapper, UserAvatar>
    implements UserAvatarService{

}




