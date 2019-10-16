package com.vi.filter;

import com.vi.service.PermissionService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.Set;

public class URLPathMatchingFilter extends PathMatchingFilter {
    @Autowired
    PermissionService permissionService;
    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        String requestURI = getPathWithinApplication(request);
        System.out.println(requestURI);
        //判断是否登录
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            //如果没有登录，跳转到登录页面
            WebUtils.issueRedirect(request, response, "/login");
            return false;
        }
        //如果已经登录，判断是否是在Permission表中维护的路径
       if(!permissionService.needInterceptor(requestURI)) {
           //如果不是的话，允许访问
           return true;
       } else {
           //判断登录用户的角色是否拥有该路径的权限
           boolean hasPermission = false;
           String username = subject.getPrincipal().toString();
           Set<String> urls = permissionService.listPermissionURLs(username);
           for (String url : urls) {
             if(url.equals(requestURI)){
                 hasPermission = true;
                 break;
             }
           }
           if(hasPermission) {
               return true;
           } else {
               //权限不足
               UnauthorizedException ex = new UnauthorizedException("当前用户没有权限访问路径:" + requestURI);
               subject.getSession().setAttribute("ex",ex);
               WebUtils.issueRedirect(request,response,"/unauthorized");
               return false;
           }
       }
    }
}
