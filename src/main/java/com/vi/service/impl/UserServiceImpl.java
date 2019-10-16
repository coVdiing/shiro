package com.vi.service.impl;

import com.vi.entity.User;
import com.vi.entity.UserExample;
import com.vi.mapper.RoleMapper;
import com.vi.mapper.UserMapper;
import com.vi.service.UserRoleService;
import com.vi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserRoleService userRoleService;

    @Override
    public String getPassword(String name) {
        User user = getByName(name);
        if (user == null) {
            return null;
        }
        return user.getPassword();
    }

    @Override
    public User getByName(String name) {
        UserExample example = new UserExample();
        example.createCriteria().andNameEqualTo(name);
       List<User> users =  userMapper.selectByExample(example);
        if (users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }

    @Override
    public List<User> list() {
        UserExample example = new UserExample();
        example.setOrderByClause("id desc");
        return userMapper.selectByExample(example);
    }

    @Override
    public void delete(Long id) {
        userMapper.deleteByPrimaryKey(id);
        userRoleService.deleteByUser(id);
    }

    @Override
    public void add(User user) {
        userMapper.insert(user);
    }

    @Override
    public User get(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }
}
