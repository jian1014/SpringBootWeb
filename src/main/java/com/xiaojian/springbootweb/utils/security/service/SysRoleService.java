package com.xiaojian.springbootweb.utils.security.service;

import com.xiaojian.springbootweb.utils.security.bean.SysRole;
import com.xiaojian.springbootweb.utils.security.mapper.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRoleService {
    @Autowired
    private SysRoleMapper roleMapper;

    public SysRole selectById(Integer id){
        return roleMapper.selectById(id);
    }
}
