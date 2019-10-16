package com.vi.service.impl;

import com.vi.entity.*;
import com.vi.mapper.RoleMapper;
import com.vi.mapper.UserRoleMapper;
import com.vi.service.RoleService;
import com.vi.service.UserService;
import org.apache.shiro.crypto.hash.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    UserRoleMapper userRoleMapper;
    @Autowired
    UserService userService;

    @Override
    public Set<String> listRoleNames(String username) {
        Set<String> result = new HashSet<>();
        List<Role> roles = listRoles(username);
        for (Role role : roles) {
            result.add(role.getName());
        }
        return result;
    }

    @Override
    public List<Role> listRoles(String username) {
        List<Role> roles = new ArrayList<>();
        User user = userService.getByName(username);
        if(user==null)
            return roles;
        roles = listRoles(user);
        return roles;
    }

    @Override
    public List<Role> listRoles(User user) {
        List<Role> roles = new ArrayList<>();
        UserRoleExample userRoleExample = new UserRoleExample();
        userRoleExample.createCriteria().andUidEqualTo(user.getId());
        List<UserRole> userRoles = userRoleMapper.selectByExample(userRoleExample);
        for (UserRole userRole : userRoles) {
            roles.add(roleMapper.selectByPrimaryKey(userRole.getRid()));

        }
        return roles;
    }

    @Override
    public List<Role> list() {
        RoleExample example = new RoleExample();
        example.setOrderByClause("id desc");
        return roleMapper.selectByExample(example);
    }

    @Override
    public void add(Role role) {
        roleMapper.insert(role);
    }

    @Override
    public void delete(Long id) {
        roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Role get(Long id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Role role) {
        roleMapper.updateByPrimaryKeySelective(role);
    }
}
