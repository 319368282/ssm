package com.jiangfx.service.impl;

import com.jiangfx.entity.User;
import com.jiangfx.mapper.UserMapper;
import com.jiangfx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务层接口实现类
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<User> list() {
        return userMapper.getAllUser();
    }
}
