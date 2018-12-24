package com.wangzhi.blog.mapper;

import com.wangzhi.pojo.Tag;
import com.wangzhi.pojo.custom.TagCustom;

public interface TagMapper {
    //根据TagId获取标签属性
    TagCustom getTagById(Integer id);
}
