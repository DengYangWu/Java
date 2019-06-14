package com.twitter.controller;


import com.twitter.pojo.Admins;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {
//    //跳转到登陆界面
//    @RequestMapping(value = "/loginUI",method = {RequestMethod.GET})
//    public String loginUI()throws Exception{
//        return "../../login";
//    }
    //登录表单处理
    @RequestMapping(value = "/login",method = {RequestMethod.POST})
    public String login(Admins admins, Model model){
        //System.out.println("name"+admins.getAname());
        //System.out.println("name"+admins.getApwd());
        //shiro实现登录
    try {
   UsernamePasswordToken token = new UsernamePasswordToken(admins.getAname(),
            admins.getApwd());
    Subject subject = SecurityUtils.getSubject();
    subject.login(token);
    if(subject!=null){
        return "/main";
    }

    } catch (DisabledAccountException e){
        model.addAttribute("message",e);
        return "../error";
        //return "/login";
    } catch (AccountException e1){
        model.addAttribute("message",e1);
        return "../error";
        //return "/login";
    }


        return "/login";
    }
}
