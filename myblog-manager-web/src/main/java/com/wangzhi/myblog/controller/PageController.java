package com.wangzhi.myblog.controller;

import com.wangzhi.myblog.service.NoticeService;
import com.wangzhi.myblog.service.PageService;
import com.wangzhi.pojo.Notice;
import com.wangzhi.pojo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
    @Autowired
    private PageService pageService;
    @Autowired
    private NoticeService noticeService;
    @RequestMapping("/{key}")
    public ModelAndView pageDetaliView(@PathVariable("key")String key){
        ModelAndView mv=new ModelAndView();
        Page page = pageService.getPageByKey(1, key);
        mv.addObject("pageCustom",page);
        mv.setViewName("/Home/Page/page");
        return mv;
    }
    @RequestMapping("/notice/{noticeId}")
    public ModelAndView getNoticeById(@PathVariable("noticeId")Integer noticeId){
        ModelAndView mv=new ModelAndView();
        Notice notice=noticeService.getNoticeById(noticeId);
        mv.addObject("noticeCustom",notice);
        mv.setViewName("/Home/Page/noticeDetail");
        return mv;
    }

}
