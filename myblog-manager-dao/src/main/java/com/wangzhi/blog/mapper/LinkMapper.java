package com.wangzhi.blog.mapper;

import com.wangzhi.pojo.Link;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LinkMapper {
    List<Link> getLinkList();

    Link getLinkById(@Param("linkId") Integer linkId);

    void updateLink(Link link);

    void insertLink(Link link);
}
