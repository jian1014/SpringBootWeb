package com.xiaojian.springbootweb.utils.security.service;

import com.xiaojian.springbootweb.utils.security.bean.SysUser;
import com.xiaojian.springbootweb.utils.security.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserService {
    @Autowired
    private SysUserMapper userMapper;

    public SysUser selectById(Integer id) {
        return userMapper.selectById(id);
    }

    public SysUser selectByName(String name) {
        return userMapper.selectByName(name);
    }
}
