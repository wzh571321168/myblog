package com.wangzhi.myblog.serviceImpl;

import com.wangzhi.blog.mapper.PageMapper;
import com.wangzhi.myblog.service.PageService;
import com.wangzhi.pojo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PageServiceImpl implements PageService {
    @Autowired
    private PageMapper pageMapper;
    @Override
    public List<Page> getPageList() {
        return  pageMapper.getPageList();
    }

    @Override
    public Page getPageByKey(Integer status, String key) {
        return pageMapper.getPageByKey(status,key);
    }

    @Override
    public Page getPageById(Integer pageId) {
        return pageMapper.getPageById(pageId);
    }

    @Override
    public void editPage(Page page) {
        pageMapper.editPage(page);
    }

    @Override
    public void insertPage(Page page) {
        pageMapper.insertPage(page);
    }
}
