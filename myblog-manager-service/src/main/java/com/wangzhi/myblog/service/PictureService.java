package com.wangzhi.myblog.service;

import com.wangzhi.pojo.Picture;
import com.wangzhi.pojo.custom.PictureCustom;
import com.wangzhi.pojo.custom.PictureCustomVo;

import java.util.List;

public interface PictureService {
    void insertPicture(Picture picture);

    List<PictureCustomVo> getPictureCustomList(Integer status, Integer pageNow, Integer pageSize);

    List<PictureCustom> getPictureCustomListByCategoryId(Integer status,Integer picCategoryId);

    List<Picture> getPictureList();
}
