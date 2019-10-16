package com.vi.Realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;

public class TestShiro {
    public static void main(String[] args) {
////        new Dao().addUser("li4","abcde");
//        User user = new User();
//        user.setName("zhang3");
//        user.setPassword("12345");
//        if(login(user)) {
//            System.out.println("登录成功!");
//        } else {
//            System.out.println("登录失败!");
//        }
    }

//    private static boolean hasRole(User user, String role) {
//        Subject subject = getSubject();
//        return subject.hasRole(role);
//    }
//
//    private static boolean isPermitted(User user, String permit) {
//        Subject subject = getSubject();
//        return subject.isPermitted(permit);
//    }
//
//    private static Subject getSubject() {
//        DatabaseRealm dr = new DatabaseRealm();
//        //准备SecurityManager
//        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
//        defaultSecurityManager.setRealm(dr);
//        //将安全管理者放入全局对象
//        SecurityUtils.setSecurityManager(defaultSecurityManager);
//        //全局对象通过安全管理者生成Subject对象
//        Subject subject = SecurityUtils.getSubject();
//
//        return subject;
//    }
//
//    private static boolean login(User user) {
//        Subject subject= getSubject();
//        //如果已经登录过了，退出
//        if(subject.isAuthenticated())
//            subject.logout();
//
//        //封装用户的数据
//        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getPassword());
//        try {
//            //将用户的数据token 最终传递到Realm中进行对比
//            subject.login(token);
//        } catch (AuthenticationException e) {
//            //验证错误
//            return false;
//        }
//
//        return subject.isAuthenticated();
//    }

}

