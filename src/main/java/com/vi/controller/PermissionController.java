package com.vi.controller;

import com.vi.entity.Permission;
import com.vi.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/config")
public class PermissionController  {
    @Autowired
    PermissionService permissionService;

    @RequestMapping("/listPermission")
    public String list(Model model) {
        List<Permission> permissions = new ArrayList<>();
        permissions = permissionService.list();
        model.addAttribute("permissions", permissions);
        return "listPermission";
    }

    @RequestMapping("/editPermission")
    public String edit(Model model, long id) {
        Permission permission = permissionService.get(id);
        model.addAttribute("permission", permission);
        return "editPermission";
    }

    @RequestMapping("/updatePermission")
    public String update(Permission permission) {
        permissionService.update(permission);
        return "redirect:listPermission";
    }

    @RequestMapping("/addPermission")
    public String list(Permission permission) {
        System.out.println(permission.getName());
        System.out.println(permission.getDesc_());
        permissionService.add(permission);
        return "redirect:listPermission";
    }

    @RequestMapping("/deletePermission")
    public String list(long id) {
        permissionService.delete(id);
        return "redirect:listPermission";
    }
}
