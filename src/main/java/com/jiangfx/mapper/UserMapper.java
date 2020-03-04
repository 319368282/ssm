package com.jiangfx.mapper;

import com.jiangfx.entity.User;

import java.util.List;

/**
 * 用户dao层接口
 */
public interface UserMapper {
    //查询所有用户
    List<User> getAllUser();
}
