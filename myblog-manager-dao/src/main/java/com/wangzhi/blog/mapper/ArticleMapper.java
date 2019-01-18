package com.wangzhi.blog.mapper;

import com.wangzhi.pojo.Article;
import org.apache.ibatis.annotations.Param;

public interface ArticleMapper {
    void insertArticle(Article article);

    void deleteArticleById(Integer id);

    void deleteArticleByIds(Integer[] id);

    void updateArticle(Article article);

    Integer countArticleWithCategory(@Param("id") Integer id);

    Integer countArticleByUserId(@Param("userId") Integer userId);
}
