package com.wangzhi.blog.mapper.custom;

import com.wangzhi.pojo.custom.CategoryCustom;

import java.util.List;

public interface CategoryCustomMapper {
    List<CategoryCustom> getCategoryCustomList();
    CategoryCustom getCategoryCustmById(Integer id);
}
