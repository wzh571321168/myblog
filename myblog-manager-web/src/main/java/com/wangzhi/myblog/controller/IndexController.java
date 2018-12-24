package com.wangzhi.myblog.controller;

import com.wangzhi.myblog.service.*;
import com.wangzhi.pojo.*;
import com.wangzhi.pojo.custom.ArticleCustomVo;
import com.wangzhi.pojo.custom.CategoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private PictureService pictureService;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private LinkService linkService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private PicCategoryService picCategoryService;
    @ModelAttribute
    public void init(Model model){
        List<Notice> noticeList = noticeService.getNoticeList();
        model.addAttribute("noticeCustomList",noticeList);
        List<Link> linkList = linkService.getLinkList();
        model.addAttribute("linkCustomList",linkList);
        List<Menu> menuList=menuService.getMenuList(1);
        model.addAttribute("menuCustomList",menuList);
        List<CategoryCustom> categoryList = categoryService.getCategoryList(1);
        model.addAttribute("categoryList",categoryList);
        List<PicCategoy> picCategoryList = picCategoryService.getPicCategoryList();
        model.addAttribute("picCategoryList",picCategoryList);
    }
    @RequestMapping("/")
    public ModelAndView getHome(){
        ModelAndView mv = new ModelAndView();
        List<ArticleCustomVo> articleListByPage = articleService.getArticleListByPage(1, 1, 10);
        mv.addObject("articleListVoList",articleListByPage);
        List<Picture> pictureList=pictureService.getPictureList();
        mv.addObject("pictureList",pictureList);
        mv.setViewName("/Home/index");
        return mv;
    }
    @RequestMapping("/page")
    public ModelAndView homePage( @RequestParam(required = false)Integer pageNum, @RequestParam(required = false)Integer pageSize){
        ModelAndView mv = new ModelAndView();
        List<ArticleCustomVo> articleCustomVoList = articleService.getArticleListByPage(1,pageNum,pageSize);
        mv.addObject("articleListVoList",articleCustomVoList);
        mv.setViewName("/Home/index");
        return mv;
    }
    //文章访问量数增加
    @RequestMapping(value = "/article/addView/{id}",method = {RequestMethod.POST})
    @ResponseBody
    public Integer increaseViewCount(@PathVariable("id") Integer id)
            throws Exception {
        Article article = articleService.getArticleById(1, id);
        int articleCount = article.getArticleViewCount();
        article.setArticleViewCount(articleCount + 1);
        articleService.updateArticle(article);
        return articleCount+1;
    }
}
