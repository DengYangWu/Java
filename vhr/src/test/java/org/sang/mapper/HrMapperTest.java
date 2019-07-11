package org.sang.mapper;

import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sang.bean.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class HrMapperTest {
    @Autowired(required = false)
    private HrMapper hrMapper;
    @Test
    public void text1(){
        System.out.println(123);
        //List<Hr> hr=hrMapper.getall();
        Hr hr = hrMapper.loadUserByUsername("admin");
        System.out.println("------------------------------"+hr.getName());
    }
}