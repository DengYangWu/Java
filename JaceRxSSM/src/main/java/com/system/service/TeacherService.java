package com.system.service;

import com.system.po.TeacherCustom;

import java.util.List;

public interface TeacherService {
    List<TeacherCustom> findByPaging(Integer toPageNo)throws Exception;
    Boolean save(TeacherCustom teacherCustom)throws Exception;
    int getCountTeacher()throws Exception;
    TeacherCustom findById(Integer id)throws Exception;
    List<TeacherCustom> findByName(String name)throws Exception;
}
