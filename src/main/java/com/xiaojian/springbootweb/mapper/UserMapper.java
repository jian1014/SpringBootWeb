package com.xiaojian.springbootweb.mapper;

import org.apache.ibatis.annotations.*;

import java.util.Map;

@Mapper
public interface UserMapper {
    /**
     * 通过用户名查询数据
     * @param username 用户名
     * @return 用户名是唯一的所以返回map
     */
    @Select("select * from user where username = #{username}")
    Map<String,Object> findUserByName(@Param("username") String username);

    /**
     * 添加数据
     * @param username 用户名
     * @param password 密码
     * @param age 年龄
     * @param sex 性别
     * @return 成功返回1true，失败返回false
     */
    @Insert("insert into user (username,password,age,sex) values (#{username},#{password},#{age},#{sex})")
    boolean insertUsers (@Param("username") String username, @Param("password") String password,@Param("age") Integer age
            ,@Param("sex") String sex);

    /**
     * 按照用户名更新数据
     * @param username 用户名
     * @param age 年龄
     * @param sex 性别
     * @return
     */
    @Update("update user set username=#{username},age=#{age},sex=#{sex} where username = #{username}")
    boolean updateUserByName(@Param("username") String username,@Param("age") Integer age,@Param("sex") String sex);

    /**
     * 按照用户名删除数据
     * @param username 用户名
     * @return
     */
    @Delete("delete from user where username=#{username}")
    boolean deleteUserByName(@Param("username") String username);
}
