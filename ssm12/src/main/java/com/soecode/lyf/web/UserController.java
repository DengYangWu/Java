package com.soecode.lyf.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.soecode.lyf.entity.User;
import com.soecode.lyf.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserService userService;
	@RequestMapping(value="/list",method=RequestMethod.GET)
	private ModelAndView show(ModelAndView model,Model m) {
		
//		String username="amdin";
//		User list=userService.getUserByName(username);
		List<User> list=userService.getList();
		model.setViewName("list");
		model.addObject("var",list);
//		m.addAttribute("list",list);
//		return "list";
		return model;
	}
	
}
