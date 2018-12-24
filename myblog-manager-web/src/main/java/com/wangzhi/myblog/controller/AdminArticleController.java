package com.wangzhi.myblog.controller;

import com.wangzhi.myblog.service.ArticleService;
import com.wangzhi.myblog.service.CategoryService;
import com.wangzhi.myblog.service.TagService;
import com.wangzhi.pojo.Article;
import com.wangzhi.pojo.Category;
import com.wangzhi.pojo.custom.ArticleCustomVo;
import com.wangzhi.pojo.custom.CategoryCustom;
import com.wangzhi.pojo.custom.TagCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/article")
public class AdminArticleController {
    @Autowired
    private TagService tagService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ArticleService articleService;
    //首页显示文章
    @RequestMapping("")
    public ModelAndView allArticleList(){
        ModelAndView mv = new ModelAndView();
        //文章首页显示
        Integer pageSize=10;
        List<ArticleCustomVo> articleCustomVoList = articleService.getArticleListByPage(1,1,pageSize);
        mv.addObject("publishedArticleListVoList",articleCustomVoList);
        //不分页显示 草稿列表
        List<ArticleCustomVo> draftArticleList = articleService.getArticleListByPage(0,null,null);
        mv.addObject("draftArticleList",draftArticleList);
        mv.setViewName("Admin/Article/index");
        return mv;
    }
    //文章分页显示
    @RequestMapping("/page" )
    public ModelAndView allArticleList(@RequestParam(required = false)String title, @RequestParam(required = false)Integer pageNum, @RequestParam(required = false)Integer pageSize){
        ModelAndView mv = new ModelAndView();
        if (pageNum==null){
            pageNum=1;
        }
        if(pageSize==null){
            pageSize=10;
        }
        //文章首页显示
        List<ArticleCustomVo> articleCustomVoList = articleService.getArticleListByPage(1,pageNum,pageSize);
        mv.addObject("publishedArticleListVoList",articleCustomVoList);
        //不分页显示 草稿列表
        List<ArticleCustomVo> draftArticleList = articleService.getArticleListByPage(0,null,null);
        mv.addObject("draftArticleList",draftArticleList);
        mv.setViewName("/Admin/Article/index");
        return mv;
    }

    @RequestMapping("/insert")
    public ModelAndView insertArticle(){
        ModelAndView mv=new ModelAndView();
        List<CategoryCustom> categoryCustomList=categoryService.getCategoryList(1);
        mv.addObject("categoryCustomList",categoryCustomList);
        List<TagCustom> tagCustomList=tagService.getTagList(1);
        mv.addObject("tagCustomList",tagCustomList);
        mv.setViewName("Admin/Article/insert");
        return mv;
    }
    @RequestMapping("/insertSubmit")
    public String insertArticle(Article article){
        article.setArticlePostTime(new Date());
        article.setArticleUpdateTime(new Date());
        article.setArticleIsComment(1);
        article.setArticleViewCount(0);
        article.setArticleLikeCount(0);
        article.setArticleCommentCount(0);
        article.setArticleOrder(1);
        articleService.insertArticle(article);
        return "redirect:/admin/article";
    }
    @RequestMapping("/edit/{articleId}")
    public ModelAndView editArticle(@PathVariable("articleId")Integer articleId){
        ModelAndView mv=new ModelAndView();
        Article article = articleService.getArticleById(1, articleId);
        mv.addObject("articleCustom",article);
        List<CategoryCustom> categoryCustomList=categoryService.getCategoryList(1);
        mv.addObject("categoryCustomList",categoryCustomList);
        List<TagCustom> tagCustomList=tagService.getTagList(1);
        mv.addObject("tagCustomList",tagCustomList);
        mv.setViewName("/Admin/Article/edit");
        return mv;
    }
    @RequestMapping("/delete/{id}")
    public void deleteArticle(@PathVariable("id")Integer id){
        articleService.deleteArticleById(id);
    }
    @RequestMapping("/deleteBatch")
    public void deleteArticleByIds(String ids){
        String[] idsArr=ids.split(",");
        Integer[] id=new Integer[idsArr.length];
        for(int i=0;i<idsArr.length;i++){
            id[i]=Integer.valueOf(idsArr[i]);
        }
        articleService.deleteArticleByIds(id);
    }
    @RequestMapping("/editSubmit")
    public String editSubmit(Article article){
        articleService.updateArticle(article);
        return "redirect:/admin/article";
    }
}
