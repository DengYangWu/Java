package com.twitter.controller;

import com.twitter.pojo.Admins;
import com.twitter.servlet.AdminsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.util.Date;


@Controller
public class SignController {
    @Autowired
    private AdminsService adminsService;
    @RequestMapping(value = "/signup",method = RequestMethod.POST)
    public String sign(Model model, Admins admins){
        System.out.println("注册");
        Timestamp ts=new Timestamp(new Date().getTime());
        admins.setAname(admins.getAname());
        admins.setApwd(admins.getApwd());
        admins.setAtime(ts);
        admins.setAstate(1);
        admins.setApower(1);
        adminsService.insertAll(admins);
        return "main";
    }
    @RequestMapping(value = "/examine",method = RequestMethod.POST)
    public String usernameOrpwdExist(){
        System.out.println("123");
        return "main";
    }
}
