package com.twitter.controller;


import com.twitter.pojo.Admins;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;

import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



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
            System.out.println(token);
            if(subject.isAuthenticated()){
                System.out.println("登录成功！");
                model.addAttribute("username",admins.getAname());
                return "redirect:/main";
            }

        }catch (IncorrectCredentialsException e3){
            System.out.println("密码错误！");
            return "../../login";
        }catch (DisabledAccountException e){
            model.addAttribute("message",e);
//        return "../error";
            return "../../login";
        } catch (ExcessiveAttemptsException e2)
        {
            System.out.println("帐号被锁定1小时");
            e2.printStackTrace();
        } catch (AccountException e1){
            model.addAttribute("message",e1);
            return "../../login";
        }


        return "../../login";

    }

    //登陆后处理
    @RequestMapping("/main")
    public String loginAfter(){
        System.out.println("登陆成功！");
        return "/main";
    }

    //记住我
    @RequestMapping(value = "/remember",method = RequestMethod.POST)
    public String remember(String name,String pass,HttpServletRequest request, HttpServletResponse response){
        UsernamePasswordToken token = new UsernamePasswordToken(name, pass);

        token.setRememberMe(true);
        System.out.println("记住我");
        System.out.println(name);
        System.out.println(token.isRememberMe());
        return "../../login";
    }

}