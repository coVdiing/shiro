package com.vi.service;

import com.vi.entity.Role;
import com.vi.entity.User;

import java.util.List;
import java.util.Set;

public interface RoleService {
    /**
     * 根据用户名查找角色名
     * @param username
     * @return
     */
    public Set<String> listRoleNames(String username);

    /**
     * 根据用户名查找角色
     * @param username
     * @return
     */
    public List<Role> listRoles(String username);

    /**
     * 根据用户查找角色
     * @param user
     * @return
     */
    public List<Role> listRoles(User user);

    public List<Role> list();

    public void add(Role role);

    public void delete(Long id);

    public Role get(Long id);

    public void update(Role role);
}
