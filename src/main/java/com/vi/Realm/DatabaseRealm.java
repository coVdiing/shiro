package com.vi.Realm;

import com.vi.entity.Role;
import com.vi.entity.User;
import com.vi.service.PermissionService;
import com.vi.service.RoleService;
import com.vi.service.UserService;
import com.vi.test.ServiceUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DatabaseRealm extends AuthorizingRealm {
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private UserService userService;

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //能进入到这里，表示账号已经通过认证了
        String username = (String) principals.getPrimaryPrincipal();
        //通过Dao获取角色和权限
//       Set<String> permissions = new Dao().listPermissions(username);
//       Set<String> roles = new Dao().listRoles(username);
        Set<String> roleNames = roleService.listRoleNames(username);
        Set<String> permisionNames = permissionService.listPermissions(username);
        //授权对象
        SimpleAuthorizationInfo sai =  new SimpleAuthorizationInfo();

        //把通过Dao获取到的角色和权限都放进去
        sai.setStringPermissions(permisionNames);
        sai.setRoles(roleNames);
        return sai;

    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取账号密码
        UsernamePasswordToken upt = (UsernamePasswordToken) token;
        String username = token.getPrincipal().toString();
        String password = new String(upt.getPassword());
        String encryptPassword = "";
        //获取数据库中的密码
//        User user = new Dao().getUser(username);
//        System.out.println("进到这里了:databaserealm");
        User user = userService.getByName(username);
        if(user != null) {
            String passwordInDB = user.getPassword();
            String salt = user.getSalt();
            //将传入的密码进行加盐
            encryptPassword = new SimpleHash("md5",password,user.getSalt(),2).toString();
        }

        //如果为空就是账号不存在，如果不相同就是密码错误，但是都抛出AuthenticationException，而不抛出具体错误原因，以防给破解者提供帮助信息
        if (null == user || !encryptPassword.equals(user.getPassword())) {
            throw new AuthenticationException();
        }
        //认证信息里存放账号和密码，getName()是当前Realm的继承方法，通常返回当前类名:DatabaseRealm
        SimpleAuthenticationInfo sai = new SimpleAuthenticationInfo(username,password,getName());
        return sai;
    }
}
