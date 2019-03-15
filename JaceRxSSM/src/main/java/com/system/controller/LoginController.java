package com.system.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.system.po.Userlogin;

@Controller
public class LoginController {
	//��½��ת
//	@RequestMapping(value="/login",method= {RequestMethod.GET})
//	public String loginUI() throws Exception{
//		return "../../login";
//	}
	//��½������
	@RequestMapping(value="/login",method= {RequestMethod.POST})
	public String login(Userlogin userlogin) throws Exception{
		//shiroʵ�ֵ�½
		UsernamePasswordToken token=new UsernamePasswordToken(userlogin.getUsername()
				,userlogin.getPassword());
		Subject subject=SecurityUtils.getSubject();
		//�����ȡ�����û������ǵ�¼ʧ�ܣ�����¼ʧ�ܵĻ�����ֱ���׳��쳣
		subject.login(token);

        if (subject.hasRole("admin")) { //����������û�����������ʾҳ��˵�
            return "redirect:/admin/showStudent";
        } else if (subject.hasRole("teacher")) {
            return "redirect:/teacher/showCourse";
        } else if (subject.hasRole("student")) {
            return "redirect:/student/showCourse";
        }
		return "/login";
	}
}
