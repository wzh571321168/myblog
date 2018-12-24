package com.wangzhi.myblog.controller;

import com.wangzhi.myblog.service.ArticleService;
import com.wangzhi.myblog.service.CategoryService;
import com.wangzhi.pojo.Category;
import com.wangzhi.pojo.custom.CategoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/category")
public class AdminCategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ArticleService articleService;
    @RequestMapping("")
    public ModelAndView categoryList(){
        ModelAndView mv=new ModelAndView();
        List<CategoryCustom> categoryCustomList=categoryService.getCategoryList(null);
        mv.addObject("categoryCustomList",categoryCustomList);
        mv.setViewName("/Admin/Category/index");
        return mv;
    }
    @RequestMapping("/insertSubmit")
    public String insertSubmit(Category category){
        category.setCategoryStatus(1);
        category.setCategoryOrder(1);
        categoryService.insertSubmit(category);
        return "redirect:/admin/category";
    }
    @RequestMapping(value = "/delete/{id}")
    public String deleteCategory(@PathVariable("id") Integer id) throws Exception {
        int count = articleService.countArticleWithCategory(id);
        if (count == 0) {
            categoryService.deleteCategory(id);
        }
        return "redirect:/admin/category";
    }
}
