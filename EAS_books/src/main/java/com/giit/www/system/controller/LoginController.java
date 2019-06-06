package com.giit.www.system.controller;

import com.giit.www.entity.User;
import com.giit.www.system.service.UserService;
import org.apache.shiro.SecurityUtils;

import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "login.do",method ={RequestMethod.POST})
    public String login(HttpServletRequest request, Model model, HttpSession session,User user){
        System.out.println(user.getUsername()+"-----------------------------");

           try {
                UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),
                        user.getPassword());
                Subject subject = SecurityUtils.getSubject();
                //用户认证状态
                // boolean isAuthenticated = subject.isAuthenticated();
                String principal = (String) subject.getPrincipal();
                subject.login(token);
                System.out.println(principal);
                //session.setAttribute("username", principal);
                if (subject.hasRole("admin")) {
                    return "admin/main";
                }else if(subject.hasRole("teacher")){
                    return "teacher/main";
                }else if(subject.hasRole("student")){
                    return "student/main";
                }else{
                    return "redirect:supplier.do/supplier.view";
                }
                //if no exception, that's it, we're done!
            } catch ( UnknownAccountException uae) {
                System.out.println("用户不存在");
                //username wasn't in the system, show them an error message?
            } catch ( IncorrectCredentialsException ice) {
                System.out.println("密码错误");
                //password didn't match, try again?
            } catch ( LockedAccountException lae) {
                System.out.println("该用户名的帐户已锁定-无法登录");
                //account for that username is locked - can't login.  Show them a message?

        } catch ( AuthenticationException ae) {
                System.out.println("其他错误");
            //unexpected condition - error?
        }

        return "redirect:/login.jsp";

    }
}
