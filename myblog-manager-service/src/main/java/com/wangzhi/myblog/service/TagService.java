package com.wangzhi.myblog.service;

import com.wangzhi.pojo.Tag;
import com.wangzhi.pojo.custom.TagCustom;

import java.util.List;

public interface TagService {
    List<TagCustom> getTagList(Integer status);

    List<TagCustom> getTagCustomList();

    void insertTag(Tag tag);
}
