package com.wangzhi.pojo.custom;

import com.github.pagehelper.PageInfo;
import com.wangzhi.pojo.Article;

import java.util.ArrayList;
import java.util.List;

public class ArticleCustomVo {
    //文章信息
    private ArticleCustom articleCustom;
    //文章所带标签
    private List<TagCustom> tagCustomList=new ArrayList<>() ;
    //分页信息
    private PageInfo page;

    public PageInfo getPage() {
        return page;
    }

    public void setPage(PageInfo page) {
        this.page = page;
    }

    public ArticleCustom getArticleCustom() {
        return articleCustom;
    }

    public void setArticleCustom(ArticleCustom articleCustom) {
        this.articleCustom = articleCustom;
    }

    public List<TagCustom> getTagCustomList() {
        return tagCustomList;
    }

    public void setTagCustomList(List<TagCustom> tagCustomList) {
        this.tagCustomList = tagCustomList;
    }
}
