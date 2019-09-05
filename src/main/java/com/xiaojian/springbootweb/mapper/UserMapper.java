package com.xiaojian.springbootweb.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface UserMapper {
    @Select("select * from user where username = #{username}")
    Map<String,Object> findUserByUserid(@Param("username") String username);

    @Insert("insert into user (username,password,age,sex) values (#{username},#{password},#{age},#{sex})")
    boolean insertUsers (@Param("username") String username, @Param("password") String password,@Param("age") Integer age
            ,@Param("sex") String sex);
}
