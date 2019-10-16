package com.vi.Realm;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;


public class JdbcRealmDemo {
    DruidDataSource dataSource = new DruidDataSource();

    {
        dataSource.setUrl("jdbc:mysql://localhost:3306/shiro");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
    }

    @Test
    public void testJdbcRealm() {
        JdbcRealm jdbcRealm = new JdbcRealm();
        String sql = "SELECT password FROM user WHERE name = ?";
        String roleSQL = "SELECT r.name FROM user u" +
                " LEFT JOIN user_role u_r ON u.id = u_r.uid" +
                " LEFT JOIN role r ON u_r.rid = r.id WHERE u.name = ?";
        String permissionSQL = "SELECT p.name FROM user u" +
                " LEFT JOIN user_role u_r ON u_r.uid = u.id" +
                " LEFT JOIN role r ON u_r.rid = r.id" +
                " LEFT JOIN role_permission r_p ON r.id = r_p.rid" +
                " LEFT JOIN permission p ON r_p.pid = p.id WHERE r.name = ?";
        //设置数据源
        jdbcRealm.setDataSource(dataSource);
        //调用自定义的查询语句,进行认证查询
        jdbcRealm.setAuthenticationQuery(sql);
        //角色查询
//        jdbcRealm.setUserRolesQuery(roleSQL);
        //开启权限查询
        jdbcRealm.setPermissionsLookupEnabled(true);
        jdbcRealm.setPermissionsQuery(permissionSQL);

        //1.创建SecurityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        //2.设置环境
        defaultSecurityManager.setRealm(jdbcRealm);
        //3.设置Realm
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        //4.获取主体
        Subject subject = SecurityUtils.getSubject();
        //5.获取用户名密码
        UsernamePasswordToken token = new UsernamePasswordToken("zhang3", "12345");
        //6.认证
        subject.login(token);
        System.out.println(subject.isAuthenticated());
        //查询角色
//       subject.checkRole("productManager");
        //查询权限
        subject.checkPermission("addProduct");
    }
}
