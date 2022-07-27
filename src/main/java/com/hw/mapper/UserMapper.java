package com.hw.mapper;

import com.hw.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

public interface UserMapper {

    @Select("select * from tb_user")
    User[] selectAll();

    User selectUser(@Param("username")String username, @Param("password")String password);

    User selectByUsername(@Param("username")String username);

    int add(@Param("username")String username, @Param("password")String password);
}
