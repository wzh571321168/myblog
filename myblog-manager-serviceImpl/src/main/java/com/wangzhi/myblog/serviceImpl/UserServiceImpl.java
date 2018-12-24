package com.wangzhi.myblog.serviceImpl;

import com.wangzhi.blog.mapper.UserMapper;
import com.wangzhi.blog.mapper.custom.UserCustomMapper;
import com.wangzhi.myblog.service.UserService;
import com.wangzhi.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserCustomMapper userCustomMapper;
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUserByNameOrEmail(String nameOrEmail) {
        return userCustomMapper.getUserByNameOrEmail(nameOrEmail);

    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
}
