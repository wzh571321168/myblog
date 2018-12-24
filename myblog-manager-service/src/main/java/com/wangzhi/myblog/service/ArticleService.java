package com.wangzhi.myblog.service;

import com.wangzhi.pojo.Article;
import com.wangzhi.pojo.custom.ArticleCustom;
import com.wangzhi.pojo.custom.ArticleCustomVo;
import com.wangzhi.pojo.custom.ArticleDetailVo;

import java.util.List;
import java.util.Map;

public interface ArticleService {
    //文章分页显示
    List<ArticleCustomVo> getArticleListByPage(Integer status, Integer pageNow, Integer pageSize);
    //获取文章详情
    ArticleDetailVo getArticleDetailVoById(Integer articleId);
    //获取访问量多的文章
    List<Article> getArticleByViewCount(Integer status, Integer limit);
    //获取下一篇文章
    Article getAfterArticle(Integer status, Integer articleId);
    //获取上一篇文章
    Article getPreviousArticle(Integer status, Integer articleId);
    //根据文章id获取文章
    Article getArticleById(Integer status, Integer articleId);
    //根据夫id和子id获取文章
    List<Article> articleListWithSameCategory(Integer status, Integer articleParentCategoryId, Integer articleChildCategoryId);
    //添加文章
    void insertArticle(Article article);
    //根据分类的id获取文章列表
    List<ArticleCustomVo> getArticleCustomVoListById(Integer status, Integer pageNow, Integer pageSize, Integer id);

    void deleteArticleById(Integer id);

    void deleteArticleByIds(Integer[] id);

    void updateArticle(Article article);

    Map<String,Object> importArticle();

    Integer countArticleWithCategory(Integer id);
}
