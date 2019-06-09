package com.giit.www.system.service;

import org.junit.Before;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UserServiceTest {
    private ApplicationContext applicationContext;
    @Before
    public void setUp(){
        applicationContext=new ClassPathXmlApplicationContext("spring.xml");
    }
    @Test
    public void findName(){
        UserService userService=(UserService)applicationContext.getBean("userServiceImpl");
        userService.findName("admin");
        System.out.println(userService.findName("admin"));
    }
    @Test
    public void findNameById(){
        UserService userService=(UserService)applicationContext.getBean("userServiceImpl");
        userService.findNameById("admin");
        System.out.println(userService.findName("admin"));
    }

}