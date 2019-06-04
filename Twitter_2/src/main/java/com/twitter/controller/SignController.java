package com.twitter.controller;

import com.twitter.pojo.Admins;
import com.twitter.servlet.AdminsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Controller
public class SignController {
    @Autowired
    private AdminsService adminsService;
    @RequestMapping(value = "/signup",method = RequestMethod.POST)
    public String sign(Model model, Admins admins){


        Timestamp ts=new Timestamp(new Date().getTime());

        Admins admins1=adminsService.findByName(admins.getAname());
        if(admins1!=null){
            model.addAttribute("message","用户已存在！请登录或更改用户名");
            return "../error";
        }else{
        System.out.println("注册");
        admins.setAname(admins.getAname());
        admins.setApwd(admins.getApwd());
        admins.setAtime(ts);
        admins.setAstate(1);
        admins.setApower(1);
        adminsService.insertAll(admins);
            return "main";
        }

    }
    @RequestMapping(value = "/examine",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> usernameOrpwdExist(String username,
                                     HttpServletRequest request, HttpServletResponse response){
        //map集合用来存放返回值
        Map<String,String> map = new HashMap<String, String>();
        System.out.println(username);
        Admins admins=adminsService.findByName(username);
        System.out.println(admins);
        if(admins!=null){
             map.put("result","存在");
        }else{
             map.put("result","不存在");
        }
        return map;
    }
}
