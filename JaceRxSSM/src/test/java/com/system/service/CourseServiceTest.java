package com.system.service;

import com.system.po.Course;
import com.system.po.CourseCustom;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CourseServiceTest {
    private ApplicationContext applicationContext;
    @Before
    public void setUp()throws  Exception{
        applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext-dao.xml",
                "spring/applicationContext-service.xml");
    }
    @Test
    public void findById()throws Exception{
        CourseService courseService=(CourseService) applicationContext.getBean("courseServiceImpl");

        CourseCustom courseCustom=courseService.findById(1);
        System.out.println(courseCustom);
    }
    @Test
    public void findByTeacherID()throws Exception{
        CourseService courseService=(CourseService) applicationContext.getBean("courseServiceImpl");
        List<CourseCustom> courseCustom=courseService.findByTeacherID(1002);
        System.out.println(courseCustom);
    }
}
