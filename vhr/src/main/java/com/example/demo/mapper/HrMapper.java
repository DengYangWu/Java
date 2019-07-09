package com.example.demo.mapper;


import com.example.demo.pojo.Hr;
import com.example.demo.pojo.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HrMapper {
    Hr loadUserByUsername(String username);
    List<Role> getRolesByHrId(Long id);
    List<Hr> getall();
}
