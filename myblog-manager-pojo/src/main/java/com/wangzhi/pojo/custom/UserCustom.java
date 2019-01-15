package com.wangzhi.pojo.custom;

import com.wangzhi.pojo.User;

public class UserCustom extends User {
    private Integer articleCount;

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }
}
