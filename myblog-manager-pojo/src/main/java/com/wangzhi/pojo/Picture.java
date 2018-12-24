package com.wangzhi.pojo;

import java.util.Date;

public class Picture {
    private Integer picId;
    private String picName;
    private Integer picCategoryId;
    private String picDescription;
    private String picUrl;
    private Date picUploadTime;
    private Integer picStatus;

    public Integer getPicId() {
        return picId;
    }

    public void setPicId(Integer picId) {
        this.picId = picId;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public Integer getPicCategoryId() {
        return picCategoryId;
    }

    public void setPicCategoryId(Integer picCategoryId) {
        this.picCategoryId = picCategoryId;
    }

    public String getPicDescription() {
        return picDescription;
    }

    public void setPicDescription(String picDescription) {
        this.picDescription = picDescription;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Date getPicUploadTime() {
        return picUploadTime;
    }

    public void setPicUploadTime(Date picUploadTime) {
        this.picUploadTime = picUploadTime;
    }

    public Integer getPicStatus() {
        return picStatus;
    }

    public void setPicStatus(Integer picStatus) {
        this.picStatus = picStatus;
    }
}
