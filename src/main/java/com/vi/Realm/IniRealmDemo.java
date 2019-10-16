package com.vi.Realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class IniRealmDemo {
    @Test
    public void testini() {
        IniRealm iniRealm = new IniRealm("classpath:shiro.ini");//realm从数据源获取相关数据
        //1.创建SecurityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        //2.设置环境
        defaultSecurityManager.setRealm(iniRealm);
        //3.设置Realm
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        //4.获得主体
        Subject subject = SecurityUtils.getSubject();
        //5.获取用户名密码
        UsernamePasswordToken token = new UsernamePasswordToken("Mark", "12345");
        //6.登录
        subject.login(token);
        //7.检测用户是否有admin角色
        subject.checkRole("admin");
        //8.检测用户是否有user:add,user:delete权限
        subject.checkPermissions("user:add","user:delete");
    }
}

