package com.wangzhi.myblog.serviceImpl;

import com.wangzhi.blog.mapper.ArticleMapper;
import com.wangzhi.blog.mapper.custom.UserCustomMapper;
import com.wangzhi.myblog.service.AdminUserService;
import com.wangzhi.pojo.custom.UserCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private UserCustomMapper userCustomMapper;
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public List<UserCustom> getUserList() {
        List<UserCustom> userList = userCustomMapper.getUserList();
        for(int i=0;i<userList.size();i++){
            userList.get(i).setArticleCount(articleMapper.countArticleByUserId(userList.get(i).getUserId()));
        }
        return userList;
    }
}
