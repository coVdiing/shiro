package com.vi.service;

import com.vi.entity.Permission;
import com.vi.entity.Role;

import java.util.List;
import java.util.Set;

public interface PermissionService {
    /**
     * 根据用户名查找权限名
     * @param username
     * @return
     */
    Set<String> listPermissions(String username);

    /**
     * 查询角色对应的权限
     * @param role
     * @return
     */
    List<Permission> listByRole(Role role);

    List<Permission> list();

    void add(Permission permission);

    void delete(Long id);

    Permission get(Long id);

    void update(Permission permission);

    boolean needInterceptor(String requestURI);

    /**
     * 根据用户名查询用户对应的权限路径
     * @param username
     * @return
     */
    Set<String> listPermissionURLs(String username);
}
