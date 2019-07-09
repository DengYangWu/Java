package com.example.demo.mapper;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestBody;


@RunWith(SpringRunner.class)
@SpringBootTest
public class HrMapperTest {
    @Autowired(required=false)
    private HrMapper hrMapper;
        @Test
        public void text(){
            try {
                System.out.println(123);
                hrMapper.loadUserByUsername("admin");
            }catch (Exception e){
                System.out.println("---"+e);
            }

        }


}