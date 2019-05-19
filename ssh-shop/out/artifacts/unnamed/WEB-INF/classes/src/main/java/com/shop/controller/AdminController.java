package com.shop.controller;

import com.shop.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class AdminController {
    @Resource
    private AdminService adminService;

    @RequestMapping(value="/admin")
    public void admin(Integer aid){
        System.out.println(123);
        System.out.println("admin="+adminService.findAdminByAid(aid));
    }
}
