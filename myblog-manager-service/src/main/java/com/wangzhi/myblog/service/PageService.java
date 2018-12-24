package com.wangzhi.myblog.service;

import com.wangzhi.pojo.Page;

import java.util.List;

public interface PageService {
    //获取全部页面列表
    List<Page> getPageList();

    Page getPageByKey(Integer status, String key);

    Page getPageById(Integer pageId);

    void editPage(Page page);

    void insertPage(Page page);
}
