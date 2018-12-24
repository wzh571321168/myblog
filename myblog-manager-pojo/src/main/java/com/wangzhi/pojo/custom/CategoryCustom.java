package com.wangzhi.pojo.custom;

import com.wangzhi.pojo.Category;

public class CategoryCustom extends Category {
    //分类对应的文章数
    private Integer articleCount;

    //分类的父分类名称
    private String categoryPname;

    public String getCategoryPname() {
        return categoryPname;
    }

    public void setCategoryPname(String categoryPname) {
        this.categoryPname = categoryPname;
    }

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }
}
