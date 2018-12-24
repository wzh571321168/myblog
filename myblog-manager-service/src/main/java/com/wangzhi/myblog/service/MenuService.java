package com.wangzhi.myblog.service;

import com.wangzhi.pojo.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> getMenuList(Integer status);
}
