package com.system.service.impl;

import com.system.mapper.CollegeMapper;
import com.system.mapper.StudentMapper;
import com.system.mapper.StudentMapperCustom;
import com.system.po.*;
import com.system.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Student
 */
@Service
public class StudentServiceImpl implements StudentService {

    //ʹ��spring �Զ�ע��
    @Autowired
    private StudentMapperCustom studentMapperCustom;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private CollegeMapper collegeMapper;

    public void updataById(Integer id, StudentCustom studentCustom) throws Exception {
        studentMapper.updateByPrimaryKey(studentCustom);
    }

    public void removeById(Integer id) throws Exception {
        studentMapper.deleteByPrimaryKey(id);
    }

    public List<StudentCustom> findByPaging(Integer toPageNo) throws Exception {
        PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);

        List<StudentCustom> list = studentMapperCustom.findByPaging(pagingVO);

        return list;
    }

    public Boolean save(StudentCustom studentCustoms) throws Exception {
        Student stu = studentMapper.selectByPrimaryKey(studentCustoms.getUserid());
        if (stu == null) {
            studentMapper.insert(studentCustoms);
            return true;
        }

        return false;
    }

    //����ѧ������
    public int getCountStudent() throws Exception {
        //�Զ����ѯ����
        StudentExample studentExample = new StudentExample();
        //ͨ��criteria�����ѯ����
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andUseridIsNotNull();

        return studentMapper.countByExample(studentExample);
    }

    public StudentCustom findById(Integer id) throws Exception {

        Student student  = studentMapper.selectByPrimaryKey(id);
        StudentCustom studentCustom = null;
        if (student != null) {
            studentCustom = new StudentCustom();
            //�࿽��
            BeanUtils.copyProperties(student, studentCustom);
        }

        return studentCustom;
    }

    //ģ����ѯ
    public List<StudentCustom> findByName(String name) throws Exception {

        StudentExample studentExample = new StudentExample();
        //�Զ����ѯ����
        StudentExample.Criteria criteria = studentExample.createCriteria();

        criteria.andUsernameLike("%" + name + "%");

        List<Student> list = studentMapper.selectByExample(studentExample);

        List<StudentCustom> studentCustomList = null;

        if (list != null) {
            studentCustomList = new ArrayList<StudentCustom>();
            for (Student s : list) {
                StudentCustom studentCustom = new StudentCustom();
                //�࿽��
                BeanUtils.copyProperties(s, studentCustom);
                //��ȡ�γ���
                College college = collegeMapper.selectByPrimaryKey(s.getCollegeid());
                studentCustom.setcollegeName(college.getCollegename());

                studentCustomList.add(studentCustom);
            }
        }

        return studentCustomList;
    }

    @Override
    public StudentCustom findStudentAndSelectCourseListByName(String name) throws Exception {

        StudentCustom studentCustom = studentMapperCustom.findStudentAndSelectCourseListById(Integer.parseInt(name));

        List<SelectedCourseCustom> list = studentCustom.getSelectedCourseList();

        // �жϸÿγ��Ƿ�����
        for (SelectedCourseCustom s : list) {
            if (s.getMark() != null) {
                s.setOver(true);
            }
        }
        return studentCustom;
    }
}