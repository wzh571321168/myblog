package com.wangzhi.myblog.controller;

import com.wangzhi.myblog.service.NoticeService;
import com.wangzhi.pojo.Notice;
import org.apache.xpath.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/notice")
public class AdminNoticeController {
    @Autowired
    private NoticeService noticeService;
    @RequestMapping("")
    public ModelAndView indexNotice(){
        ModelAndView mv=new ModelAndView();
        List<Notice> noticeList=noticeService.getNoticeList();
        mv.addObject("noticeCustomList",noticeList);
        mv.setViewName("/Admin/Notice/index");
        return mv;
    }
    @RequestMapping("/edit/{noticeId}")
    public ModelAndView editNotice(@PathVariable("noticeId")Integer noticeId){
        ModelAndView mv=new ModelAndView();
        Notice notice = noticeService.getNoticeById(noticeId);
        mv.addObject("noticeCustom",notice);
        mv.setViewName("/Admin/Notice/edit");
        return mv;
    }
    @RequestMapping("/editSubmit")
    public String editSubmit(Notice notice){
        notice.setNoticeUpdateTime(new Date());
        noticeService.updateNotice(notice);
        return "redirect:/admin/notice";
    }
    @RequestMapping("/insert")
    public ModelAndView insertNotice(Notice notice){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("/Admin/Notice/insert");
        return mv;
    }
    @RequestMapping("/insertSubmit")
    public String insertSubmit(Notice notice){
        notice.setNoticeUpdateTime(new Date());
        notice.setNoticeCreateTime(new Date());
        notice.setNoticeStatus(1);
        notice.setNoticeOrder(1);
        noticeService.insertNotice(notice);
        return "redirect:/admin/notice";
    }
}
