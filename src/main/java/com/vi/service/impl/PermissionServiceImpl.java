package com.vi.service.impl;

import com.vi.entity.*;
import com.vi.mapper.PermissionMapper;
import com.vi.mapper.RolePermissionMapper;
import com.vi.service.PermissionService;
import com.vi.service.RoleService;
import com.vi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    PermissionMapper permissionMapper;
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    RolePermissionMapper rolePermissionMapper;

    @Override
    public Set<String> listPermissions(String username) {
        Set<String> result = new HashSet<>();
        List<Role> roles = roleService.listRoles(username);
        List<RolePermission> rolePermissions = new ArrayList<>();
        for (Role role : roles) {
            RolePermissionExample example = new RolePermissionExample();
            example.createCriteria().andRidEqualTo(role.getId());
            List<RolePermission> list = rolePermissionMapper.selectByExample(example);
            rolePermissions.addAll(list);
        }
        for (RolePermission rolePermission : rolePermissions) {
            Permission p = permissionMapper.selectByPrimaryKey(rolePermission.getPid());
            result.add(p.getName());
        }
        return result;
    }

    @Override
    public List<Permission> listByRole(Role role) {
        List<Permission> result = new ArrayList<>();
        RolePermissionExample example = new RolePermissionExample();
        example.createCriteria().andRidEqualTo(role.getId());
        List<RolePermission> rolePermissions = rolePermissionMapper.selectByExample(example);
        for (RolePermission rolePermission : rolePermissions) {
            result.add(permissionMapper.selectByPrimaryKey(rolePermission.getPid()));
        }
        return result;
    }

    @Override
    public List<Permission> list() {
        PermissionExample example = new PermissionExample();
        example.setOrderByClause("id desc");
        return permissionMapper.selectByExample(example);
    }

    @Override
    public void add(Permission permission) {
        permissionMapper.insert(permission);
    }

    @Override
    public void delete(Long id) {
        permissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Permission get(Long id) {
        return permissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Permission permission) {
        permissionMapper.updateByPrimaryKeySelective(permission);
    }

    @Override
    public boolean needInterceptor(String requestURI) {
        List<Permission> permissions = list();
        System.out.println("requestURI:"+requestURI);
        for (Permission permission : permissions) {
            String url = permission.getUrl();
            System.out.println(url);
            if(url.equals(requestURI))
                return true;
        }
        return false;
    }

    @Override
    public Set<String> listPermissionURLs(String username) {
        List<Role> roles = roleService.listRoles(username);
        Set<String> urls = new HashSet<>();
        List<RolePermission> rolePermissions = new ArrayList<>();
        for (Role role : roles) {
            RolePermissionExample example = new RolePermissionExample();
            example.createCriteria().andRidEqualTo(role.getId());
            List<RolePermission> temp = rolePermissionMapper.selectByExample(example);
            rolePermissions.addAll(temp);
        }
        for (RolePermission rolePermission : rolePermissions) {
            Permission permission = permissionMapper.selectByPrimaryKey(rolePermission.getPid());
            urls.add(permission.getUrl());
        }
        return urls;
    }
}
