package com.wangzhi.blog.mapper.custom;

import com.wangzhi.pojo.Article;
import com.wangzhi.pojo.custom.ArticleCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleCustomMapper {
    //根据类目获取文章总数
    Integer getArticleByCategoryId(@Param("status") Integer status, @Param("categoryId") Integer categoryId);
    //获取文章和分类名称列表
    List<ArticleCustom> getArticleCustomList(Integer status);
    //根据文章id获取文章信息
    ArticleCustom getArticleCustomById(Integer articleId);
    //获取访问量较多的文章
    List<Article> getArticleByViewCount(@Param("status")Integer status, @Param("limit")Integer limit);
    //获取下一篇文章
    Article getAfterArticle(@Param("status")Integer status, @Param("articleId")Integer articleId);
    //获取上一篇文章
    Article getPreViousArticle(@Param("status")Integer status,@Param("articleId") Integer articleId);
    //根据文章id获取文章
    Article getArticleById(@Param("status")Integer status, @Param("articleId")Integer articleId);
    //根据分类父id和子id获取文章列表
    List<Article> getArticleListWithSameCategory(@Param("status")Integer status, @Param("articleParentCategoryId")Integer articleParentCategoryId, @Param("articleChildCategoryId")Integer articleChildCategoryId);
    //根据分类的id获取文章列表
    List<ArticleCustom> getArticleCustomListById(@Param("status")Integer status, @Param("id")Integer id);
}
