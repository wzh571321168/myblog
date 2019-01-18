package com.wangzhi.myblog.controller;

import com.wangzhi.myblog.service.AdminUserService;
import com.wangzhi.pojo.custom.UserCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/user")
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;
    @RequestMapping("")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        List<UserCustom> userList = adminUserService.getUserList();
        mv.addObject("userCustomList",userList);
        mv.setViewName("/Admin/User/index");
        return mv;
    }
    @RequestMapping("/profile/{id}")
    public ModelAndView profile(@PathVariable("id")Integer id){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/Admin/User/profile");
        return mv;
    }
}
