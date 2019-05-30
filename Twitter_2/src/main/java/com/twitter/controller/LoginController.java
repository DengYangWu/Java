package com.twitter.controller;


import com.twitter.pojo.Admins;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {
    //登录表单处理
    @RequestMapping(value = "/login",method = {RequestMethod.POST})
    public String login(Admins admins){
        System.out.println("name"+admins.getAname());
        //shiro实现登录
        UsernamePasswordToken token=new UsernamePasswordToken(admins.getAname(),
                admins.getApwd());
        Subject subject= SecurityUtils.getSubject();
        subject.login(token);
        return "main";
    }
}
