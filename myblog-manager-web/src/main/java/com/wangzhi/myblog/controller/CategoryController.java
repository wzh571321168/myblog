package com.wangzhi.myblog.controller;

import com.wangzhi.myblog.service.ArticleService;
import com.wangzhi.myblog.service.CategoryService;
import com.wangzhi.pojo.custom.ArticleCustomVo;
import com.wangzhi.pojo.custom.CategoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CategoryService categoryService;
    @RequestMapping("/category/{id}")
    public ModelAndView ArticleByCategoryId(@PathVariable("id")Integer id){
        ModelAndView mv=new ModelAndView();
        CategoryCustom categoryCustom = categoryService.getCategoryCustmById(id);
        mv.addObject("categoryCustom",categoryCustom);
        Integer pageSize=10;
        List<ArticleCustomVo> articleListVoList=articleService.getArticleCustomVoListById(1,1,pageSize,id);
        mv.addObject("articleListVoList",articleListVoList);
        mv.setViewName("Home/Page/articleListByCategory");
        return mv;
    }

}
