package com.vi.controller;

import com.sun.xml.internal.ws.resources.UtilMessages;
import com.vi.entity.Role;
import com.vi.entity.User;
import com.vi.service.RoleService;
import com.vi.service.UserRoleService;
import com.vi.service.UserService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/config")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    UserRoleService userRoleService;

    @RequestMapping("/listUser")
    public String list(Model model) {
        List<User> users = userService.list();
        model.addAttribute("users", users);
        Map<User, List<Role>> user_roles = new HashMap<>();
        for (User user : users) {
            List<Role> roles = roleService.listRoles(user);
            user_roles.put(user, roles);
        }
        model.addAttribute("user_roles", user_roles);
        return "listUser";
    }

    @RequestMapping("/editUser")
    public String edit(Model model, long id) {
        List<Role> roles = roleService.list();
        model.addAttribute("roles", roles);
        User user = userService.get(id);
        model.addAttribute("user", user);
        List<Role> currentRoles = roleService.listRoles(user);
        model.addAttribute("currentRoles", currentRoles);
        return "editUser";
    }

    @RequestMapping("/deleteUser")
    public String delete(Model model, long id) {
        userService.delete(id);
        return "redirect:listUser";
    }

    @RequestMapping("/updateUser")
    public String update(User user, long[] roleIds) {
        userRoleService.setRoles(user, roleIds);
        String password = user.getPassword();
        //如果数据里没有密码就不用更新
        if (password != null) {//给输入的密码加盐加密
            String salt = new SecureRandomNumberGenerator().nextBytes().toString();
            int times = 2;
            String method = "md5";
            String encryptPassword = new SimpleHash(method, password, salt, times).toString();
            user.setPassword(encryptPassword);
            user.setSalt(salt);
        }
        userService.update(user);
        return "redirect:listUser";
    }


    @RequestMapping("/addUser")
    public String add(Model model, String name, String password) {
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        String encryptPassword = new SimpleHash("md5", password, salt, 2).toString();
        User user = new User();
        user.setPassword(encryptPassword);
        user.setName(name);
        user.setSalt(salt);
        userService.add(user);
        model.addAttribute("user", user);
        return "redirect:listUser";
    }
}
