package com.wangzhi.myblog.controller;

import com.wangzhi.myblog.service.ArticleService;
import com.wangzhi.pojo.Article;
import com.wangzhi.pojo.custom.ArticleDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @RequestMapping("/article/{articleId}")
    public ModelAndView ArticleDetailView(@PathVariable("articleId")Integer articleId){
        ModelAndView mv=new ModelAndView();
        ArticleDetailVo articleDetailVo= articleService.getArticleDetailVoById(articleId);
        if(articleDetailVo!=null){
            mv.addObject("articleDetailVo",articleDetailVo);
            //相关文章
            Article article=articleService.getArticleById(1,articleId);
            List<Article> similarArticleList=articleService.articleListWithSameCategory(1,article.getArticleParentCategoryId(),article.getArticleChildCategoryId());
            mv.addObject("similarArticleList",similarArticleList);
            //猜你喜欢
            List<Article> mostViewArticleList = articleService.getArticleByViewCount(1,5);
            mv.addObject("mostViewArticleList",mostViewArticleList);
            //获取下一篇文章
            Article afterArticle=articleService.getAfterArticle(1,articleId);
            mv.addObject("afterArticle",afterArticle);
            //获取下一篇文章
            Article prevArticle=articleService.getPreviousArticle(1,articleId);
            mv.addObject("preArticle",prevArticle);
        }

        mv.setViewName("/Home/Page/articleDetail");
        return mv;
    }
}
