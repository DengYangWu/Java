package com.twitter.controller;

import com.twitter.pojo.Adlogin;
import com.twitter.pojo.Admins;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    //登录表单处理
    @RequestMapping(value = "/login",method = {RequestMethod.POST})
    public String login(Admins admins,@RequestParam("aname") String aname, @RequestParam("password") String password, HttpSession session){
        System.out.println("name"+aname);
        System.out.println("name"+admins.getAname());
        return "redirect:/jsp/main";
    }
}
