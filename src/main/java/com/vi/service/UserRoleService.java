package com.vi.service;

import com.vi.entity.User;

public interface UserRoleService {
    /**
     * 给用户赋予对应的角色
     * @param user
     * @param roleIds
     */
    void setRoles(User user, long[] roleIds);

    /**
     * 根据用户id删除
     * @param userId
     */
    void deleteByUser(long userId);

    void deleteByRole(long roleId);
}
