package com.chinesecooly.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chinesecooly.mysql.domain.Tag;
import com.chinesecooly.blog.service.TagService;
import com.chinesecooly.blog.mapper.TagMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【tag】的数据库操作Service实现
* @createDate 2022-04-20 20:48:34
*/
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag>
    implements TagService{

}




