package com.wangzhi.pojo.custom;

import java.util.ArrayList;
import java.util.List;

public class ArticleDetailVo {
    //文章相关信息
    private ArticleCustom articleCustom;

    //文章的作者相关信息
    private UserCustom userCustom;

    //文章的标签相关信息
    private List<TagCustom> tagCustomList =new ArrayList<>();

    //评论信息
    private List<CommentCustom> commentCustomList;

    public ArticleCustom getArticleCustom() {
        return articleCustom;
    }

    public void setArticleCustom(ArticleCustom articleCustom) {
        this.articleCustom = articleCustom;
    }

    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }

    public List<TagCustom> getTagCustomList() {
        return tagCustomList;
    }

    public void setTagCustomList(List<TagCustom> tagCustomList) {
        this.tagCustomList = tagCustomList;
    }

    public List<CommentCustom> getCommentCustomList() {
        return commentCustomList;
    }

    public void setCommentCustomList(List<CommentCustom> commentCustomList) {
        this.commentCustomList = commentCustomList;
    }
}
