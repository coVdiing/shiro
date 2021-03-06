package com.vi.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.misc.Request;

/**
 * 专门用于显示页面的控制器
 */
@Controller
@RequestMapping("")
public class PageController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }


    @RequestMapping("/deleteProduct")
    public String deleteProduct() {
        return "deleteProduct";
    }

    @RequestMapping("/listProduct")
    public String listProduct() {
        return "listProduct";
    }


    @RequestMapping("/deleteOrder")
    public String deleteOrder() {
        return "deleteOrder";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping("/unauthorized")
    public String noperms() {
        return "unauthorized";
    }
}
