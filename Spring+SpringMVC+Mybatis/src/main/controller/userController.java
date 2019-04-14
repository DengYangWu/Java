package main.controller;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import main.pojo.User;
import main.service.UserService;

@RestController
public class userController {

	//private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserService userService;
	@RequestMapping("/queryById.do")
	private ModelAndView show(Model m,ModelAndView mode){

			List<User> userlist=userService.findAll();
	        //m.addAttribute("var",userlist);
			mode.addObject("var", userlist);
			mode.setViewName("show");
		
	        return mode;
	}
}
