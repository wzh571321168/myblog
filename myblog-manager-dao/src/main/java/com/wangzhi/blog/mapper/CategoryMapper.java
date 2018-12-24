package com.wangzhi.blog.mapper;

import com.wangzhi.pojo.Category;
import com.wangzhi.pojo.custom.CategoryCustom;
import org.apache.ibatis.annotations.Param;

public interface CategoryMapper {
    void insertCategory(Category category);


    void deleteCategory(@Param("id") Integer id);
}
