package com.wangzhi.blog.mapper.custom;

import com.wangzhi.pojo.Tag;
import com.wangzhi.pojo.custom.TagCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagCustomMapper {
    List<TagCustom> getTagCustomList(@Param("status") Integer status);

    Integer getArticleCountById(@Param("tagId") Integer tagId);

    void insertTag(@Param("tag") Tag tag);
}
