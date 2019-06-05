package com.giit.www.system.dao;

import com.giit.www.entity.Role;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class RoleDaoTest {
    private ApplicationContext applicationContext;
    @Before
    public void setUp(){
        applicationContext=new ClassPathXmlApplicationContext("spring.xml");
    }
    @Test
    public void findOne(){
        RoleDao roleDao=(RoleDao)applicationContext.getBean("roleDao");
        Role role=roleDao.findOne(6L);
        System.out.println(role);
    }
}