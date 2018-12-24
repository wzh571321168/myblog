package com.wangzhi.myblog.controller;

import com.wangzhi.myblog.service.CommentService;
import com.wangzhi.pojo.custom.CommentCustomVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/comment")
public class AdminCommentControllrt {
    @Autowired
    private CommentService commentService;
    @RequestMapping("")
    public ModelAndView index(){
        ModelAndView mv=new ModelAndView();
        List<CommentCustomVo> commentCustomVoList=commentService.getCommentCustomVoList(null,1,10);
        mv.addObject("commentListVoList",commentCustomVoList);
        mv.setViewName("/Admin/Comment/index");
        return mv;
    }
}
