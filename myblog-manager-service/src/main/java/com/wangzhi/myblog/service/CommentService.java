package com.wangzhi.myblog.service;

import com.wangzhi.pojo.custom.CommentCustomVo;

import java.util.List;

public interface CommentService {
    List<CommentCustomVo> getCommentCustomVoList(Integer status,Integer pageNow,Integer pageSize);
}
