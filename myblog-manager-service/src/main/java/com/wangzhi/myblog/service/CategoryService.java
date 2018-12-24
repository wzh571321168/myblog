package com.wangzhi.myblog.service;

import com.wangzhi.pojo.Category;
import com.wangzhi.pojo.custom.CategoryCustom;

import java.util.List;

public interface CategoryService {
    void insertSubmit(Category category);

    List<CategoryCustom> getCategoryList(Integer status);

    CategoryCustom getCategoryCustmById(Integer id);

    void deleteCategory(Integer id);

    //void getCategoryCustomList(Integer status);
}
