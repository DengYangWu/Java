package com.system.service;

import java.util.List;

import com.system.po.StudentCustom;

/**
 * Studentѧ��Service��
 */
public interface StudentService {

    //����id������ѧ����Ϣ
    void updataById(Integer id, StudentCustom studentCustom) throws Exception;

    //����idɾ��ѧ����Ϣ
    void removeById(Integer id) throws Exception;

    //��ȡ��ҳ��ѯѧ����Ϣ
    List<StudentCustom> findByPaging(Integer toPageNo) throws Exception;

    //����ѧ����Ϣ
    Boolean save(StudentCustom studentCustoms) throws Exception;

    //��ȡѧ������
    int getCountStudent() throws Exception;

    //����id��ȡѧ����Ϣ
    StudentCustom findById(Integer id) throws Exception;

    //��������ģ����ѯ
    List<StudentCustom> findByName(String name) throws Exception;

    // һ�Զ��ѯ����ѯ��ѧ����ѡ����Ϣ
    StudentCustom findStudentAndSelectCourseListByName(String name) throws Exception;

}