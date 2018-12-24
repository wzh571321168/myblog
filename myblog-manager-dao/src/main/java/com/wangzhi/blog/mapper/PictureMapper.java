package com.wangzhi.blog.mapper;

import com.wangzhi.pojo.Picture;
import com.wangzhi.pojo.custom.PictureCustom;

import java.util.List;

public interface PictureMapper {
    void insertPicture(Picture picture);

    List<Picture> getPictureList(Integer status);

    List<Picture> getNewPictureList();
}
