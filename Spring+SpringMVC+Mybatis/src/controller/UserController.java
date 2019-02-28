package controller;


import java.util.List;

import javax.annotation.Resource;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pojo.User;
import service.UserService;

@Controller
public class UserController {
	//@Autowired() @Qualifier("userSerivce")
	//@Resource(name="UserService")
	private UserService userSerivce;
	public UserService getUserSerivce() {
		return userSerivce;
	}
	public void setUserSerivce(UserService userSerivce) {
		this.userSerivce = userSerivce;
	}
	/*
	 * ¸ù¾ÝID²éÑ¯
	 * */
	@RequestMapping("/queryById.do")
	public ModelAndView queryById(HttpServletRequest request) {
		
		ModelAndView mv=new ModelAndView();
		//int id=request.getParameter("id");
		System.out.println("123");
		try {
			List<User> user=userSerivce.selectByPrimaryKey();
			System.out.println("321");
			mv.addObject("var",user);
			mv.setViewName("show");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
}
