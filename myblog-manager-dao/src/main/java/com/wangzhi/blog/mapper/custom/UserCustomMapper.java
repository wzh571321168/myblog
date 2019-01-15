package com.wangzhi.blog.mapper.custom;


import com.wangzhi.pojo.User;
import com.wangzhi.pojo.custom.UserCustom;

import java.util.List;

public interface UserCustomMapper {
    User getUserByNameOrEmail(String usernameOrEmail);

    UserCustom getUserById(Integer articleUserId);

    List<UserCustom> getUserList();
}
