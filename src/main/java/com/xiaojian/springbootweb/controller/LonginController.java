package com.xiaojian.springbootweb.controller;

import com.xiaojian.springbootweb.service.LoginService;
import com.xiaojian.springbootweb.service.impl.LoginImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LonginController {
    //登录业务层
    @Autowired
    private LoginService loginService;

    @RequestMapping("/")
    @ResponseBody
    public void login(String name,String password,int age,String sex){
        loginService.insertUser(name,password,age,sex);
        System.out.println("1111");
    }
}
