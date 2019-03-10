package main.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import main.pojo.User;
import main.service.UserService;

@Controller
public class userController {

	private UserService userService;
	@RequestMapping("/queryById.do")
	public ModelAndView show(ModelAndView model) {
		System.out.printf("123");
		//User u=new User();
		ModelAndView modelAndView = new ModelAndView();
		try {
			List<?> list=userService.selectByPrimaryKey();
			modelAndView.setViewName("show");
			modelAndView.addObject("var",list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return modelAndView;
	}
}
