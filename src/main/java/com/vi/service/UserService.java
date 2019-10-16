package com.vi.service;

import com.vi.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 根据用户名获取密码
     * @param name
     * @return
     */
    String getPassword(String name);

    /**
     * 根据用户名查找user
     * @param name
     * @return
     */
    User getByName(String name);

    List<User> list();

    void delete(Long id);

    void add(User user);

    User get(Long id);

    void update(User user);
}
