package com.wangzhi.myblog.controller;

import com.wangzhi.myblog.service.LinkService;
import com.wangzhi.pojo.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/link")
public class AdminLinkController {
    @Autowired
    private LinkService linkService;
    @RequestMapping("")
    public ModelAndView linkIndex(){
        ModelAndView mv=new ModelAndView();
        List<Link> linkList=linkService.getLinkList();
        mv.addObject("linkCustomList",linkList);
        mv.setViewName("/Admin/Link/index");
        return mv;
    }
    @RequestMapping("/edit/{linkId}")
    public ModelAndView editLink(@PathVariable("linkId")Integer linkId){
        ModelAndView mv=new ModelAndView();
        Link link = linkService.getLinkById(linkId);
        mv.addObject("linkCustom",link);
        mv.setViewName("/Admin/Link/edit");
        return mv;
    }
    @RequestMapping("/editSubmit")
    public String editSubmit(Link link){
        link.setLinkUpdateTime(new Date());
        linkService.updateLink(link);
        return "redirect:/admin/link";
    }
    @RequestMapping("/insert")
    public ModelAndView insertLink(){
        ModelAndView mv=new ModelAndView();
        List<Link> linkList=linkService.getLinkList();
        mv.addObject("linkCustomList",linkList);
        mv.setViewName("/Admin/Link/insert");
        return mv;
    }
    @RequestMapping("/insertSubmit")
    public String insertSubmit(Link link){
        link.setLinkCreateTime(new Date());
        link.setLinkStatus(1);
        linkService.insertLink(link);
        return "redirect:/admin/link";
    }
}
