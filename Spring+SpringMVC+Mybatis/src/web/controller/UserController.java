package web.controller;


import java.util.List;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import web.pojo.User;
import web.service.UserService;

@Controller
public class UserController {
	@Resource
	private UserService userSerivce;

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
