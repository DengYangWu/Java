package com.system.mapper;

import com.system.po.Student;
import com.system.po.StudentExample;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class StudentMapperTest {
    private ApplicationContext applicationContext;
    @Before
    public void setUp(){
        applicationContext=new ClassPathXmlApplicationContext("spring/applicationContext-dao.xml");
    }
    @Test
    public void selectByExample() throws Exception{
        StudentMapper studentMapper=(StudentMapper)applicationContext.getBean("studentMapper");
        //custom condition query object
        StudentExample studentExample=new StudentExample();
        StudentExample.Criteria criteria=studentExample.createCriteria();
        //custom query contition
        //String userName = "黄";
        try {

            criteria.andUsernameLike("%黄%");
            List<Student> list =studentMapper.selectByExample(studentExample);
            String username="黄";
            List<Student> l=studentMapper.like(username);
            System.out.println(list);
        } catch (Exception exception) {
            System.out.println("realName在进行UTF-8编码时出错," + exception.toString());
        }

    }
}

