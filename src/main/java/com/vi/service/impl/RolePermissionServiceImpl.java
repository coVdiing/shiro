package com.vi.service.impl;

import com.vi.entity.Role;
import com.vi.entity.RolePermission;
import com.vi.entity.RolePermissionExample;
import com.vi.mapper.RolePermissionMapper;
import com.vi.service.PermissionService;
import com.vi.service.RolePermissionService;
import com.vi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RolePermissionServiceImpl implements RolePermissionService {
    @Autowired
    RoleService roleService;
    @Autowired
    PermissionService permissionService;
    @Autowired
    RolePermissionMapper rolePermissionMapper;

    @Override
    public void setPermissions(Role role, long[] permissonIds) {
        //删除当前角色的所有权限
        RolePermissionExample rolePermissionExample = new RolePermissionExample();
        rolePermissionExample.createCriteria().andRidEqualTo(role.getId());
        List<RolePermission> list = rolePermissionMapper.selectByExample(rolePermissionExample);
        for (RolePermission rolePermission : list) {
            rolePermissionMapper.deleteByPrimaryKey(rolePermission.getId());
        }
        //设置新的权限关系
        if (permissonIds != null) {
            for (long id : permissonIds) {
                RolePermission rolePermission = new RolePermission();
                rolePermission.setRid(role.getId());
                rolePermission.setPid(id);
                rolePermissionMapper.insert(rolePermission);
            }
        }
    }

    @Override
    public void deleteByRole(long roleId) {
        RolePermissionExample rolePermissionExample = new RolePermissionExample();
        rolePermissionExample.createCriteria().andRidEqualTo(roleId);
        List<RolePermission> rolePermissions = rolePermissionMapper.selectByExample(rolePermissionExample);
        for (RolePermission rolePermission : rolePermissions) {
            rolePermissionMapper.deleteByPrimaryKey(rolePermission.getId());
        }
    }

    @Override
    public void deleteByPermission(long permissionId) {
        RolePermissionExample rolePermissionExample = new RolePermissionExample();
        rolePermissionExample.createCriteria().andPidEqualTo(permissionId);
        List<RolePermission> rolePermissions = rolePermissionMapper.selectByExample(rolePermissionExample);
        for (RolePermission rolePermission : rolePermissions) {
            rolePermissionMapper.deleteByPrimaryKey(rolePermission.getId());
        }
    }
}
