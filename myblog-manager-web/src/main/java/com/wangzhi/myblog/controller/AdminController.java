package com.wangzhi.myblog.controller;



import com.wangzhi.myblog.service.TagService;
import com.wangzhi.myblog.service.UserService;
import com.wangzhi.myblog.util.IpUtils;
import com.wangzhi.myblog.util.LoginUser;
import com.wangzhi.pojo.User;
import com.wangzhi.pojo.custom.TagCustom;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private TagService tagService;
    //管理员首页显示
    @RequestMapping("/admin")
    public ModelAndView AdminIndex(){
        ModelAndView mv=new ModelAndView();
        List<TagCustom> tagCustomList=tagService.getTagCustomList();
        mv.addObject("tagCustomList",tagCustomList);
        mv.setViewName("Admin/index");
        return mv;
    }
    //登录界面
    @RequestMapping("login")
    public String login(){
        return "Admin/login";
    }
    //登录验证
    @RequestMapping(value = "/loginConfirm")
    @ResponseBody
    public String loginConfim(LoginUser loginUser, HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> map=new HashMap<>();
        String usernameOrEmail=loginUser.getUsername();
        String password=loginUser.getPassword();
        String rememberme=loginUser.getRememberme();
        //根据用户名或者邮箱获取用户
        User user = userService.getUserByNameOrEmail(usernameOrEmail);
        if(user==null){
            map.put("code",0);
            map.put("msg","用户名无效");
        }else if (!password.equals(user.getUserPass())){
            map.put("code",0);
            map.put("msg","密码错误");
        }else {
            map.put("code",1);
            map.put("msg","");
            request.getSession().setAttribute("user",user);
            if(rememberme!=null){
                Cookie nameCookie=new Cookie("username",usernameOrEmail);
                nameCookie.setMaxAge(60*60*24*7);
                Cookie passwordCookie=new Cookie("password",password);
                passwordCookie.setMaxAge(60*60*24*7);
                response.addCookie(nameCookie);
                response.addCookie(passwordCookie);
            }
            user.setUserLastLoginTime(new Date());
            user.setUserLastLoginIp(IpUtils.getIp(request));
            userService.updateUser(user);
        }
        String res = new JSONObject(map).toString();
        return res;
    }
    //退出登录
    @RequestMapping("/admin/loginout")
    public String loginOut(HttpSession session){
        session.removeAttribute("user");
        session.invalidate();
        return "redirect:/login";
    }

}
