package com.system.mapper;

import java.util.List;

import com.system.po.PagingVO;
import com.system.po.StudentCustom;

public interface StudentMapperCustom {

    //��ҳ��ѯѧ����Ϣ
    List<StudentCustom> findByPaging(PagingVO pagingVO) throws Exception;

    //��ѯѧ����Ϣ������ѡ����Ϣ
    StudentCustom findStudentAndSelectCourseListById(Integer id) throws Exception;

}