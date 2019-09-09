package com.xiaojian.springbootweb.utils.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @RequestMapping("/index")
    public String showHome() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("当前登陆用户：" + name);
        return "page/index";
    }

    @RequestMapping("/login")
    public String showLogin() {
        System.out.println("返回登录页面");
        return "page/login";
    }

    @RequestMapping("/admin")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String printAdmin() {
        System.out.println("admin权限");
        return "如果你看见这句话，说明你有ROLE_ADMIN角色";
    }

    @RequestMapping("/user")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_USER')")
    public String printUser() {
        System.out.println("user权限");
        return "如果你看见这句话，说明你有ROLE_USER角色";
    }

}
