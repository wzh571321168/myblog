package com.wangzhi.myblog.controller;

import com.wangzhi.myblog.service.PageService;
import com.wangzhi.pojo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/page")
public class AdminPageController {
    @Autowired
    private PageService pageService;
    @RequestMapping("")
    public ModelAndView page(){
        ModelAndView mv=new ModelAndView();
        List<Page> pageList = pageService.getPageList();
        mv.addObject("pageCustomList",pageList);
        mv.setViewName("/Admin/Page/index");
        return mv;
    }
    @RequestMapping("/edit/{pageId}")
    public ModelAndView editPage(@PathVariable("pageId")Integer pageId){
        ModelAndView mv=new ModelAndView();
        Page page=pageService.getPageById(pageId);
        mv.addObject("pageCustom",page);
        mv.setViewName("/Admin/Page/edit");
        return mv;
    }
    @RequestMapping("/editSubmit")
    public String editSubmit(Page page){
        page.setPageUpdateTime(new Date());
        pageService.editPage(page);
        return "redirect:/admin/page";
    }
    @RequestMapping("/insert")
    public String insertPage(){
        return "/Admin/Page/insert";
    }
    @RequestMapping("/insertSubmit")
    public String insertSubmit(Page page){
        page.setPageCreateTime(new Date());
        page.setPageUpdateTime(new Date());
        page.setPageCommentCount(0);
        page.setPageStatus(1);
        page.setPageViewCount(0);
        pageService.insertPage(page);
        return "redirect:/admin/page";
    }
}
