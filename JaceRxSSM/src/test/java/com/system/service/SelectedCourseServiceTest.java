package com.system.service;

import com.system.po.SelectedCourseCustom;
import com.system.po.Selectedcourse;
import com.system.po.StudentCustom;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.util.List;

public class SelectedCourseServiceTest {
    private ApplicationContext applicationContext;
    @Before
    public void SetUp(){
        applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext-dao.xml",
                "spring/applicationContext-service.xml");
    }

    @Test
    public void findByCourseID()throws Exception{
        SelectedCourseService  selectedCourseCustom=(SelectedCourseService )applicationContext.getBean("selectedCourseServiceImpl");
        List<SelectedCourseCustom> list=selectedCourseCustom.findByCourseID(5);
        System.out.println(list);
    }
    @Test
    public void countByCourseID()throws Exception{
        SelectedCourseService  selectedCourseCustom=(SelectedCourseService )applicationContext.getBean("selectedCourseServiceImpl");
        int i=selectedCourseCustom.countByCourseID(5);
        System.out.println(i);
    }
    @Test
    public void findOne()throws Exception{
        SelectedCourseService  selectedCourseCustom=(SelectedCourseService)applicationContext.getBean("selectedCourseServiceImpl");
        SelectedCourseCustom selectedCourseCustom1=new SelectedCourseCustom();
        selectedCourseCustom1.setCourseid(1);
        selectedCourseCustom1.setStudentid(10001);
        SelectedCourseCustom sec=selectedCourseCustom.findOne(selectedCourseCustom1);
        System.out.println(sec);
    }
    @Test
    public void remote()throws Exception{
        SelectedCourseService selectedCourseService=(SelectedCourseService)applicationContext.getBean("selectedCourseServiceImpl");
        SelectedCourseCustom selectedCourseCustom=new SelectedCourseCustom();
        //selectedCourseCustom.setStudentid(10001);
        //selectedCourseService.remove(2);
    }
    @Test
    public void save()throws Exception{
        SelectedCourseService selectedCourseService=(SelectedCourseService)applicationContext.getBean("selectedCourseServiceImpl");
        SelectedCourseCustom selectedCourseCustom=new SelectedCourseCustom();

        selectedCourseCustom.setCourseid(6);
        selectedCourseCustom.setStudentid(10001);
        selectedCourseCustom.setMark(null);
        selectedCourseService.save(selectedCourseCustom);

    }
    @Test
    public void updateOne()throws Exception{
        SelectedCourseService selectedCourseService=(SelectedCourseService)applicationContext.getBean("selectedCourseServiceImpl");
        SelectedCourseCustom selectedCourseCustom=new SelectedCourseCustom();
        selectedCourseCustom.setCourseid(3);
        selectedCourseCustom.setStudentid(10001);
        selectedCourseCustom.setMark(20);
        selectedCourseService.updateOne(selectedCourseCustom);

    }
}
