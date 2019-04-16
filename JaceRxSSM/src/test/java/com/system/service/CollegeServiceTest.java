package com.system.service;

import com.system.po.College;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CollegeServiceTest {
    private ApplicationContext applicationContext;

    @Before
    public void setUp()throws Exception{
        applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/applicationContext-dao.xml",
                "spring/applicationContext-service.xml"});
    }
    @Test
    public void finAll()throws Exception{
        CollegeService collegeService=(CollegeService) applicationContext.getBean("collegeServiceImpl");
        List<College> list=collegeService.finAll();
        System.out.println(list);
    }
}
