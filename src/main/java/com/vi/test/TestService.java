package com.vi.test;

import com.vi.dao.Dao;
import com.vi.entity.Permission;
import com.vi.entity.Role;
import com.vi.entity.User;
import com.vi.service.PermissionService;
import com.vi.service.RoleService;
import com.vi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 单元测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestService {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    PermissionService permissionService;



    @Test
    public void testUser(){
        List<Role> roles = roleService.list();
        User user = userService.get(1L);
        List<Role> currentRoles = roleService.listRoles(user);
        System.out.println(roles);
        System.out.println(currentRoles);
    }

    @Test
    public void testRole() {
        Map<Role, List<Permission>> r_p = new HashMap<>();
        List<Role> roles = roleService.list();
        for (Role role : roles) {
            List<Permission> permissions = permissionService.listByRole(role);
            r_p.put(role, permissions);
        }

        for (Role role : roles) {
            System.out.println(r_p.get(role));
        }
    }

    @Test
    public void testPermission() {
        String url = "/listOrder";
        System.out.println(permissionService.needInterceptor("/config/editPermission"));
    }
}
