package com.wangzhi.blog.mapper.custom;

import com.wangzhi.pojo.custom.PictureCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PictureCustomMapper {
    List<PictureCustom> getPictureCustomList(@Param("status") Integer status);

    List<PictureCustom> getPictureCustomListByCategoryId(@Param("status")Integer status, @Param("picCategoryId")Integer picCategoryId);
}
