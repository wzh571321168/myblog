package com.wangzhi.pojo.custom;

import com.github.pagehelper.PageInfo;

public class CommentCustomVo {
    private CommentCustom commentCustom;
    private ArticleCustom articleCustom;
    private PageInfo pageInfo;

    public CommentCustom getCommentCustom() {
        return commentCustom;
    }

    public void setCommentCustom(CommentCustom commentCustom) {
        this.commentCustom = commentCustom;
    }

    public ArticleCustom getArticleCustom() {
        return articleCustom;
    }

    public void setArticleCustom(ArticleCustom articleCustom) {
        this.articleCustom = articleCustom;
    }


    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }
}
