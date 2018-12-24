package com.wangzhi.blog.mapper;

import com.wangzhi.pojo.PicCategoy;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PicCategoryMapper {
    List<PicCategoy> getPicCategoryList();

    PicCategoy getPicCategoryById(Integer picCategoryId);

    void addPicCategory(PicCategoy picCategoy);

    void deleteCategoryById(@Param("id") Integer id);
}
