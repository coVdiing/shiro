package com.vi.Realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

public class testAuthentication {
    SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

    @Before
    public void addUser() {
        //在password后可以添加角色参数，该参数是一个可变参数
        simpleAccountRealm.addAccount("Mark","12345","admin","user");
    }

    @Test
    public void authentication(){
        //1.创建SecurityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        //2.设置环境
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        //3.设置Realm
        defaultSecurityManager.setRealm(simpleAccountRealm);
        //4.获取主体
        Subject subject = SecurityUtils.getSubject();
        //5.获取用户名密码
        UsernamePasswordToken token = new UsernamePasswordToken("Mark", "12345");
        //6.认证
        try {
            subject.login(token);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("isAuthentication:"+subject.isAuthenticated());

        subject.checkRoles("admin1","user");
    }
}
