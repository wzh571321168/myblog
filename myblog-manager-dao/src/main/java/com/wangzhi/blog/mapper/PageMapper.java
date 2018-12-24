package com.wangzhi.blog.mapper;

import com.wangzhi.pojo.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PageMapper {
    //获取全部页面列表
    List<Page> getPageList();

    Page getPageByKey(@Param("status") Integer status, @Param("key")String key);

    Page getPageById(@Param("pageId") Integer pageId);

    void editPage(Page page);

    void insertPage(Page page);
}
