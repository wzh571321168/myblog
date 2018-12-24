package com.wangzhi.pojo.custom;

import com.wangzhi.pojo.Article;


public class ArticleCustom extends Article{
    private String articleChildCategoryName;
    private String articleParentCategoryName;

    public String getArticleChildCategoryName() {
        return articleChildCategoryName;
    }

    public void setArticleChildCategoryName(String articleChildCategoryName) {
        this.articleChildCategoryName = articleChildCategoryName;
    }

    public String getArticleParentCategoryName() {
        return articleParentCategoryName;
    }

    public void setArticleParentCategoryName(String articleParentCategoryName) {
        this.articleParentCategoryName = articleParentCategoryName;
    }
}
