package com.wangzhi.pojo;

import java.io.Serializable;

public class Category{
    private String categoryName;
    private Integer categoryPid;
    private String categoryDescription;
    private String categoryIcon;
    private Integer categoryId;
    private Integer categoryOrder;
    private Integer categoryStatus;

    public Integer getCategoryStatus() {
        return categoryStatus;
    }

    public void setCategoryStatus(Integer categoryStatus) {
        this.categoryStatus = categoryStatus;
    }

    public Integer getCategoryOrder() {
        return categoryOrder;
    }

    public void setCategoryOrder(Integer categoryOrder) {
        this.categoryOrder = categoryOrder;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryPid(Integer categoryPid) {
        this.categoryPid = categoryPid;
    }

    public String getCategoryIcon() {
        return categoryIcon;
    }

    public void setCategoryIcon(String categoryIcon) {
        this.categoryIcon = categoryIcon==null?null:categoryIcon.trim();
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription==null?null:categoryDescription.trim();
    }

    public Integer getCategoryPid() {
        return categoryPid;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName==null?null:categoryName.trim();
    }
}
