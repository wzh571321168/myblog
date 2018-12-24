package com.wangzhi.pojo.custom;

import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.List;

public class PictureCustomVo {
    private PictureCustom pictureCustom;
    private PageInfo pageInfo;


    public PictureCustom getPictureCustom() {
        return pictureCustom;
    }

    public void setPictureCustom(PictureCustom pictureCustom) {
        this.pictureCustom = pictureCustom;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }
}
