package com.wangzhi.myblog.service;

import com.wangzhi.pojo.Link;

import java.util.List;

public interface LinkService {
    List<Link> getLinkList();

    Link getLinkById(Integer linkId);

    void updateLink(Link link);

    void insertLink(Link link);
}
