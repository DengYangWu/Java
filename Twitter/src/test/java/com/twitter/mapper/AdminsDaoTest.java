package com.twitter.mapper;

import com.twitter.pojo.Admins;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.*;

public class AdminsDaoTest {

    private ApplicationContext applicationContext;
    @Before
    public void setUp()throws Exception{
        applicationContext = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
    }
    @Test
    public void insertAll()throws Exception{
        AdminsDao admin= (AdminsDao) applicationContext.getBean("adminsDao");
        Admins admins=new Admins();
        admins.setAname("dyw");
        admins.setApwd("123");
        Timestamp time2 = new Timestamp(new Date().getTime());
        admins.setAtime(time2);
        admins.setAstate(1);
        admins.setApower(1);
        admin.insertAll(admins);
    }
}