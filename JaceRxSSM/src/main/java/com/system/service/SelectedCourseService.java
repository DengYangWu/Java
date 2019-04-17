package com.system.service;

import com.system.po.SelectedCourseCustom;

import java.util.List;

public interface SelectedCourseService {
    List<SelectedCourseCustom> findByCourseID(Integer id) throws Exception;

    //获取该课程学生数
    Integer countByCourseID(Integer id) throws Exception;

    //查询指定学生成绩
    SelectedCourseCustom findOne(SelectedCourseCustom selectedCourseCustom) throws Exception;
    //根据ID删除学生成绩
    Integer remote(Integer id)throws Exception;
}
