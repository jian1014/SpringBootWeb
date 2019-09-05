package com.xiaojian.springbootweb.service.impl;

import com.xiaojian.springbootweb.mapper.UserMapper;
import com.xiaojian.springbootweb.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service()
public class LoginImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean insertUser(String name ,String password,int age,String sex){
        return userMapper.insertUsers(name,password,age,sex);
    }

    @Override
    public Map query(String username) {
        return userMapper.findUserByName(username);
    }

    @Override
    public boolean updateUserByName(String username, int age, String sex) {
        return userMapper.updateUserByName(username,age,sex);
    }

    @Override
    public boolean deleteUserByName(String username) {
        return userMapper.deleteUserByName(username);
    }

}
