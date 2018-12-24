package com.wangzhi.myblog.service;


import com.wangzhi.pojo.User;

public interface UserService {
    User getUserByNameOrEmail(String nameOrEmail);
    void updateUser(User user);
}
