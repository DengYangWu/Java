package com.giit.www.system.dao;

import com.giit.www.system.service.LimitTheLoginService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class LimitTheLoginDaoTest {
    private ApplicationContext applicationContext;
    @Before
    public void setUp(){
        applicationContext=new ClassPathXmlApplicationContext("spring.xml");
    }
    @Test
    public void findDate(){
        LimitTheLoginService limitTheLoginService=(LimitTheLoginService)applicationContext.getBean("limitTheLoginServiceImpl");
        System.out.println(limitTheLoginService.findAllLoginDate(1));
    }
}