package com.xiaojian.springbootweb.service;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface LoginService {
    public boolean insertUser(String name ,String password,int age,String sex) throws Exception;

    public Map query(String username) throws Exception;

    boolean updateUserByName(String username, int age,String sex)throws Exception;

    boolean  deleteUserByName(String username)throws Exception;
}
