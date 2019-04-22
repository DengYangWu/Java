package com.system.service;

import com.system.po.TeacherCustom;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TeacherServiceTest {
    private ApplicationContext applicationContext;
    @Before
    public void SetUp(){
        applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext-dao.xml",
                "spring/applicationContext-service.xml");
    }
    @Test
    public void findByPaging()throws Exception{
        TeacherService teacherService=(TeacherService) applicationContext.getBean("teacherServiceImpl");
        
    }
    @Test
    public void findByName()throws Exception{
        TeacherService teacherService=(TeacherService) applicationContext.getBean("teacherServiceImpl");
        List<TeacherCustom> list=teacherService.findByName("软");
        System.out.println(list);
    }
}
