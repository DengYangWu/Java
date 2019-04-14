package com.system.service;

import com.system.po.CourseCustom;

import java.util.List;

/**
 * CourseService�γ���Ϣ.
 */
public interface CourseService {
    //����id���¿γ���Ϣ
    void upadteById(Integer id, CourseCustom courseCustom) throws Exception;

    //����idɾ���γ���Ϣ
    Boolean removeById(Integer id) throws Exception;

    //��ȡ��ҳ��ѯ�γ���Ϣ
    List<CourseCustom> findByPaging(Integer toPageNo) throws Exception;

    //����γ���Ϣ
    Boolean save(CourseCustom couseCustom) throws Exception;

    //��ȡ�γ�����
    int getCountCouse() throws Exception;

    //����id��ѯ
    CourseCustom findById(Integer id) throws Exception;

    //�������ֲ�ѯ
    List<CourseCustom> findByName(String name) throws Exception;

    //���ݽ�ʦid���ҿγ�
    List<CourseCustom> findByTeacherID(Integer id) throws Exception;
}