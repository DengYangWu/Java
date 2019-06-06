package com.giit.www.system.service;

import com.giit.www.entity.Role;
import com.giit.www.system.dao.RoleDao;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class RoleServiceTest {
    private ApplicationContext applicationContext;
    @Before
    public void setUp(){
        applicationContext=new ClassPathXmlApplicationContext("spring.xml");
    }
    @Test
    public void findOne(){
        RoleService roleService=(RoleService)applicationContext.getBean("roleServiceImpl");
        roleService.findRoles(5L);
        System.out.println(roleService.findRoles(5L));
    }

}