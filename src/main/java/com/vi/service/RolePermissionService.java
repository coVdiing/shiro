package com.vi.service;

import com.vi.entity.Role;

public interface RolePermissionService {
    /**
     * 给角色赋予对应的权限
     * @param role
     * @param permissonIds
     */
    void setPermissions(Role role, long[] permissonIds);

    void deleteByRole(long roleId);

    void deleteByPermission(long permissionId);
}
