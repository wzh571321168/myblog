package com.wangzhi.blog.mapper.custom;

import com.wangzhi.pojo.custom.CommentCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentCustomMapper {
    //根据文章的id获取该文章的评论
    List<CommentCustom> getCommentCustomByArticleId(Integer articleId);

    List<CommentCustom> getCommentCustomList(@Param("status") Integer status);
}
