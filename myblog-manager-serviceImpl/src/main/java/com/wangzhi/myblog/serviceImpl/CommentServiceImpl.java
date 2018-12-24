package com.wangzhi.myblog.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.wangzhi.blog.mapper.custom.ArticleCustomMapper;
import com.wangzhi.blog.mapper.custom.CommentCustomMapper;
import com.wangzhi.myblog.service.CommentService;

import com.wangzhi.pojo.custom.ArticleCustom;
import com.wangzhi.pojo.custom.CommentCustom;
import com.wangzhi.pojo.custom.CommentCustomVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentCustomMapper commentCustomMapper;
    @Autowired
    private ArticleCustomMapper articleCustomMapper;
    @Override
    public List<CommentCustomVo> getCommentCustomVoList(Integer status, Integer pageNow, Integer pageSize) {
        List<CommentCustomVo> commentCustomVoList=new ArrayList<>();
        PageHelper.startPage(pageNow,pageSize);
        List<CommentCustom> commentCustomList=commentCustomMapper.getCommentCustomList(status);
        PageInfo<CommentCustom> pageInfo=new PageInfo<>(commentCustomList);
        for (int i=0;i<commentCustomList.size();i++){
            CommentCustomVo commentCustomVo=new CommentCustomVo();
            ArticleCustom articleCustom = articleCustomMapper.getArticleCustomById(commentCustomList.get(i).getCommentArticleId());
            commentCustomVo.setArticleCustom(articleCustom);
            commentCustomVo.setCommentCustom(commentCustomList.get(i));
            commentCustomVo.setPageInfo(pageInfo);
            commentCustomVoList.add(commentCustomVo);
        }
        return commentCustomVoList;
    }
}
