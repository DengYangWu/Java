package com.system.service;

import com.system.po.PagingVO;
import com.system.po.SelectedCourseCustom;
import com.system.po.Student;
import com.system.po.StudentCustom;
import org.aspectj.lang.annotation.RequiredTypes;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

public class StudentServiceTest {
    private ApplicationContext applicationContext;
    @Before
    public void SetUp(){
        applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext-dao.xml",
                "spring/applicationContext-service.xml");
    }
    @Test
    public void updateById()throws Exception{
        StudentService studentService=(StudentService) applicationContext.getBean("studentServiceImpl");
        StudentCustom studentCustom=new StudentCustom();
        studentCustom.setUserid(10007);
        studentCustom.setUsername("老王");
        //指定时间格式
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-M-d");
        //指定一个日期
        Date date=dateFormat.parse("1990-03-06");
        studentCustom.setBirthyear(date);
        studentCustom.setCollegeid(1);
        studentCustom.setSex("男");
        studentCustom.setGrade(new Date());

        studentService.updataById(10007,studentCustom);
    }
    @Test
    public void removeById()throws Exception{
        StudentService studentService=(StudentService)applicationContext.getBean("studentServiceImpl");
        studentService.removeById(10006);
    }
    @Test
    public void findByPaging()throws Exception{
        StudentService studentService=(StudentService)applicationContext.getBean("studentServiceImpl");
        List<StudentCustom> studentCustomList=studentService.findByPaging(1);
        System.out.println(studentCustomList);
    }
    @Test
    public void save()throws Exception{
        StudentService studentService=(StudentService)applicationContext.getBean("studentServiceImpl");
        StudentCustom student=new StudentCustom();
        student.setUserid(10006);
        student.setUsername("天花");
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-M-d");
        Date date = dateFormat.parse("1991-01-01");
        student.setBirthyear(date);
        student.setCollegeid(1);
        student.setGrade(new Date());
        Boolean aBoolean=studentService.save(student);
        System.out.println(aBoolean);
    }
    @Test
    public void getCountStudent()throws Exception{
        StudentService studentService=(StudentService)applicationContext.getBean("studentServiceImpl");
        int studentCount=studentService.getCountStudent();
        System.out.println(studentCount);
    }
    @Test
    public void findById()throws Exception{
        StudentService studentService=(StudentService)applicationContext.getBean("studentServiceImpl");
        StudentCustom studentCustom=studentService.findById(10005);
        System.out.println(studentCustom);
    }
    @Test
    public void findByName()throws Exception{
        StudentService studentService=(StudentService)applicationContext.getBean("studentServiceImpl");
        List<StudentCustom> studentCustoms=studentService.findByName("五");
        System.out.println(studentCustoms);
    }
    @Test
    public void findStudentAndSelectCourseListByName()throws Exception{
        StudentService studentService=(StudentService)applicationContext.getBean("studentServiceImpl");
        String name="10001";
        StudentCustom studentCustom = studentService.findStudentAndSelectCourseListByName(name);
        //List<SelectedCourseCustom> list=studentCustom.getSelectedCourseList();
        System.out.println("--------List"+studentCustom);

    }


}
