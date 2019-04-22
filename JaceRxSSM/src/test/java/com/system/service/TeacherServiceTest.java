package com.system.service;

import com.system.po.TeacherCustom;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TeacherServiceTest {
    private ApplicationContext applicationContext;
    @Before
    public void SetUp(){
        applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext-dao.xml",
                "spring/applicationContext-service.xml");
    }
    @Test
    public void findByPaging(){
        TeacherService teacherService=(TeacherService) applicationContext.getBean("teacherServiceImpl");
        
    }
}
