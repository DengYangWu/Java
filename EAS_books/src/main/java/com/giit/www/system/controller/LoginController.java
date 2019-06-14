package com.giit.www.system.controller;

import com.giit.www.CredentialsMatcher.RetryLimitMatcher;
import com.giit.www.entity.LimitTheLogin;
import com.giit.www.entity.Timetable;
import com.giit.www.entity.User;
import com.giit.www.system.service.LimitTheLoginService;
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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Controller
public class LoginController {
    @Resource
    private UserService userService;
    @Resource
    private LimitTheLoginService limitTheLoginService;
    @RequestMapping(value = "login.do",method ={RequestMethod.POST})
    public String login(HttpServletRequest request, Model model, HttpSession session,User user){
        System.out.println(user.getUsername()+"-----------------------------");
//        LogManager.me().executeLog(LogTaskFactory.loginLog(user.getUsername(), "登录错误次数超过五次", getIp()));
           try {
               //时间戳
               SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
               Date now = new Date();
               Calendar nowTime = Calendar.getInstance();
               nowTime.add(Calendar.MINUTE, 60);
               Date afterDate=nowTime.getTime();
               //Date afterDate = (Date) sdf.format(nowTime.getTime());
               //Date date=sdf.format(afterDate);
               //记录登录次数
               int count = 1;

               User user1=userService.findName(user.getUsername());
               if (user1 != null) {
                   Timetable timetable = new Timetable();
                   LimitTheLogin limitTheLogin = new LimitTheLogin();
                   int id = userService.findNameById(user.getUsername());
                   System.out.println("用户ID:"+id);
                   limitTheLogin.setIduser(id);

                   limitTheLogin.setCountlogin(count);
                   limitTheLogin.setDatelogin(afterDate);
                   limitTheLoginService.insertCount(limitTheLogin);

                   //限制登录次数
                   //登录总数
                   int count_sql=limitTheLoginService.findAllId(id);



                   if (count_sql >= 5) {
                       System.out.println("登录次数过于频繁！");

                       System.out.println("date"+limitTheLoginService.findAllLoginDate(id));
                   }
               }
                   //查询是否有用户
                   UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),
                           user.getPassword());
                   Subject subject = SecurityUtils.getSubject();
                   //用户认证状态
                   // boolean isAuthenticated = subject.isAuthenticated();
                   String principal = (String) subject.getPrincipal();
                   subject.login(token);
                   System.out.println("----------------------" + count);
                   System.out.println(principal);
                   //session.setAttribute("username", principal);
                   if (subject.hasRole("admin")) {
                       return "admin/main";
                   } else if (subject.hasRole("teacher")) {
                       return "teacher/main";
                   } else if (subject.hasRole("student")) {
                       return "student/main";
                   } else {
                       return "redirect:supplier.do/supplier.view";
                   }

                   //if no exception, that's it, we're done!
               } catch(UnknownAccountException uae){
                   System.out.println("用户不存在");
                   //username wasn't in the system, show them an error message?
               } catch(IncorrectCredentialsException ice){
                   System.out.println("密码错误");
                   //password didn't match, try again?
               } catch(LockedAccountException lae){
                   System.out.println("该用户名的帐户已锁定-无法登录");
                   //account for that username is locked - can't login.  Show them a message?

               } catch(AuthenticationException ae){
                   System.out.println("其他错误");
                   //unexpected condition - error?
               }


        return "redirect:/login.jsp";

    }
}
