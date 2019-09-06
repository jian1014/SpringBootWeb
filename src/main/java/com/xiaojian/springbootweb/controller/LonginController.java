package com.xiaojian.springbootweb.controller;

import com.xiaojian.springbootweb.service.LoginService;
import com.xiaojian.springbootweb.utils.MD5;
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
     * 登录页面
     * @return
     */
    @RequestMapping("/loginView")
    public String loginView(){
        return "/page/login";
    }

    /**
     * 登录
     * @param name 用户名
     * @param password 密码
     * @return
     */
    @RequestMapping("login")
    public String login(String name,String password){
        try {
            //通过name查询数据库获取密码
            Map map = loginService.query(name);
            String pas = map == null ? "":map.get("password").toString();
            //对传来的密码进行加密然后进行比对,相同返回主页，如果不同返回登录页
            if(MD5.Md5Util(password).equals(pas)){
                return "page/index";
            }
            return "page/login";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 添加数据s
     * @param name 用户名
     * @param password 用户密码
     * @param age 年龄
     * @param sex 性别
     */
    @RequestMapping("/add")
    @ResponseBody
    public String login(String name,String password,int age,String sex){
        try {
            loginService.insertUser(name, MD5.Md5Util(password),age,sex);
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
    @RequestMapping("/query")
    @ResponseBody
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
     * @param name 用户名
     * @param age 年龄
     * @param sex 性别
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public String update(String name,int age,String sex){
        boolean flag = false;
        try {
            flag = loginService.updateUserByName(name,age,sex);
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
     * @param name 用户名
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(String name){
        boolean flag;
        try {
            flag = loginService.deleteUserByName(name);
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
