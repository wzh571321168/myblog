package com.wangzhi.myblog.service;

import com.wangzhi.pojo.PicCategoy;
import com.wangzhi.pojo.custom.PicCategoryCustom;

import java.util.List;

public interface PicCategoryService {
    List<PicCategoy> getPicCategoryList();

    PicCategoy getPicCategoryById(Integer picCategoryId);

    void addPicCategory(PicCategoy picCategoy);

    List<PicCategoryCustom> getPicCategoryCustomList();

    void deleteCategoryById(Integer id);
}
