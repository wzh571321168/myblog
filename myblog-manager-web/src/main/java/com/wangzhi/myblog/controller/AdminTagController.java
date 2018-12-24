package com.wangzhi.myblog.controller;

import com.wangzhi.myblog.service.TagService;
import com.wangzhi.pojo.Tag;
import com.wangzhi.pojo.custom.TagCustom;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/tag")
public class AdminTagController {
    @Autowired
    private TagService tagService;

    @RequestMapping("")
    public ModelAndView index(){
        ModelAndView mv=new ModelAndView();
        List<TagCustom> tagCustomList=tagService.getTagCustomList();
        mv.addObject("tagCustomList",tagCustomList);
        mv.setViewName("/Admin/Tag/index");
        return mv;
    }
    @RequestMapping("insertSubmit")
    public String insertTag(Tag tag){
        tag.setTagStatus(1);
        tagService.insertTag(tag);
        return "redirect:/admin/tag";
    }
    @RequestMapping("getAllTagecharts")
    @ResponseBody
    public List<TagCustom> getAllTagecharts(){
        Map<String,Object> map=new HashMap<>();
        List<TagCustom> tagCustomList=tagService.getTagCustomList();
        return tagCustomList;



    }
}
