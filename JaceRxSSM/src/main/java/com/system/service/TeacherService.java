package com.system.service;

import com.system.po.TeacherCustom;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

public interface TeacherService {
    void updateById(Integer id,TeacherCustom teacherCustom)throws Exception;
    void removeById(Integer id)throws Exception;
    List<TeacherCustom> findByPaging(Integer toPageNo)throws Exception;
    Boolean save(TeacherCustom teacherCustom)throws Exception;
    int getCountTeacher()throws Exception;
    TeacherCustom findById(Integer id)throws Exception;
    List<TeacherCustom> findByName(String name)throws Exception;
}
