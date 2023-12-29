package com.techsor.workhub.mapper;

import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE username = #{username} AND userpassword = #{userpassword}")
    Integer userLogin(String username, String userpassword );
}
