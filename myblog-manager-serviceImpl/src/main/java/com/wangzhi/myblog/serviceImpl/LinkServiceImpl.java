package com.wangzhi.myblog.serviceImpl;

import com.wangzhi.blog.mapper.LinkMapper;
import com.wangzhi.myblog.service.LinkService;
import com.wangzhi.pojo.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LinkServiceImpl implements LinkService {
    @Autowired
    private LinkMapper linkMapper;
    @Override
    public List<Link> getLinkList() {
        return linkMapper.getLinkList();
    }

    @Override
    public Link getLinkById(Integer linkId) {
        return linkMapper.getLinkById(linkId);
    }

    @Override
    public void updateLink(Link link) {
        linkMapper.updateLink(link);
    }

    @Override
    public void insertLink(Link link) {
        linkMapper.insertLink(link);
    }
}
