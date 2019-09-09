package com.xiaojian.springbootweb.utils.security.service;

import com.xiaojian.springbootweb.utils.security.bean.SysUserRole;
import com.xiaojian.springbootweb.utils.security.mapper.SysUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserRoleService {
    @Autowired
    private SysUserRoleMapper userRoleMapper;

    public SysUserRoleService(SysUserRoleMapper userRoleMapper) {
        this.userRoleMapper = userRoleMapper;
    }

    public List<SysUserRole> listByUserId(Integer userId) {
        return userRoleMapper.listByUserId(userId);
    }
}
