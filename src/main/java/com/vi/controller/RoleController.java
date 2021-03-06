package com.vi.controller;

import com.vi.entity.Permission;
import com.vi.entity.Role;
import com.vi.service.PermissionService;
import com.vi.service.RolePermissionService;
import com.vi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/config")
public class RoleController {
    @Autowired
    RoleService roleService;
    @Autowired
    RolePermissionService rolePermissionService;
    @Autowired
    PermissionService permissionService;

    @RequestMapping("/listRole")
    public String list(Model model) {
        List<Role> roles = roleService.list();
        model.addAttribute("roles", roles);

        Map<Role, List<Permission>> role_permissions = new HashMap<>();
        for (Role role : roles) {
            List<Permission> permissions = permissionService.listByRole(role);
            role_permissions.put(role, permissions);
        }
        model.addAttribute("role_permissions",role_permissions);
        return "listRole";
    }

    @RequestMapping("/editRole")
    public String list(Model model, long id) {
        Role role = roleService.get(id);
        model.addAttribute("role", role);

        List<Permission> permissions = permissionService.list();
        model.addAttribute("permissions", permissions);

        List<Permission> currentPermissions = permissionService.listByRole(role);
        model.addAttribute("currentPermissions", currentPermissions);

        return "editRole";
    }

    @RequestMapping("/updateRole")
    public String update(Role role, long[] permissionIds) {
        rolePermissionService.setPermissions(role,permissionIds);
        roleService.update(role);
        return "redirect:listRole";
    }

    @RequestMapping("/addRole")
    public String add(Model model, Role role) {
        System.out.println(role.getName());
        System.out.println(role.getDesc_());
        roleService.add(role);
        return "redirect:listRole";
    }

    @RequestMapping("/deleteRole")
    public String delete(long id) {
        roleService.delete(id);
        rolePermissionService.deleteByRole(id);
        return "redirect:listRole";
    }
}
