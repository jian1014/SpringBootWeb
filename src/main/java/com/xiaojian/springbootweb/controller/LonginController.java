package com.xiaojian.springbootweb.controller;

import com.xiaojian.springbootweb.service.LoginService;
import com.xiaojian.springbootweb.service.impl.LoginImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class LonginController {
    //登录业务层
    @Autowired
    private LoginService loginService;

    /**
     * 添加数据
     * @param name 用户名
     * @param password 用户密码
     * @param age 年龄
     * @param sex 性别
     */
    @RequestMapping("/add")
    @ResponseBody
    public String login(String name,String password,int age,String sex){
        try {
            loginService.insertUser(name,password,age,sex);
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
        return "1";
    }

    /**
     * 查询数据
     * @param name 用户名
     * @param age 年龄
     * @return
     */
    public Map query(String name,int age){
        try {
            return loginService.query(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 按照用户名更新数据
     * @param username 用户名
     * @param age 年龄
     * @param sex 性别
     * @return
     */
    public String update(String username,int age,String sex){
        boolean flag = false;
        try {
            flag = loginService.updateUserByName(username,age,sex);
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
        if(flag){
            return "1";
        }
        return "0";
    }

    /**
     * 按照用户名删除
     * @param username 用户名
     * @return
     */
    public String delete(String username){
        boolean flag;
        try {
            flag = loginService.deleteUserByName(username);
            if(flag){
                return "1";
            }
            return "0";
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }
}
