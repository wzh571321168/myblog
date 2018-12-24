package com.wangzhi.myblog.serviceImpl;

import com.wangzhi.blog.mapper.MenuMapper;
import com.wangzhi.myblog.service.MenuService;
import com.wangzhi.pojo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Override
    public List<Menu> getMenuList(Integer status) {
        return menuMapper.getMenuList(status);
    }
}
