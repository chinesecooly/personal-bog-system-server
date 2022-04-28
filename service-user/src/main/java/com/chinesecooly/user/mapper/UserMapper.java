package com.chinesecooly.user.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.chinesecooly.mysql.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
* @author Administrator
* @description 针对表【user】的数据库操作Mapper
* @createDate 2022-04-20 20:51:29
* @Entity com.chinesecooly.mysql.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<User> selectByName(@Param("name") String name);
}




