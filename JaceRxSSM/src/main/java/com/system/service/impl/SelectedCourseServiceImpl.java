package com.system.service.impl;

import com.system.mapper.SelectedcourseMapper;
import com.system.mapper.StudentMapper;
import com.system.po.*;
import com.system.service.SelectedCourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SelectedCourseServiceImpl implements com.system.service.SelectedCourseService {
    @Autowired
    private SelectedcourseMapper selectedcourseMapper;

    @Autowired
    private StudentMapper studentMapper;

    //更加ID查询成绩
    @Override
    public List<SelectedCourseCustom> findByCourseID(Integer id) throws Exception {
        SelectedcourseExample example = new SelectedcourseExample();
        SelectedcourseExample.Criteria criteria = example.createCriteria();
        criteria.andCourseidEqualTo(id);

        List<Selectedcourse> list = selectedcourseMapper.selectByExample(example);

        List<SelectedCourseCustom> secList = new ArrayList<SelectedCourseCustom>();
        for (Selectedcourse s: list) {
            SelectedCourseCustom sec = new SelectedCourseCustom();

            BeanUtils.copyProperties(s, sec);

            //判断是否完成类该课程
            if (sec.getMark() != null) {
                sec.setOver(true);
            }
            Student student = studentMapper.selectByPrimaryKey(sec.getStudentid());
            StudentCustom studentCustom = new StudentCustom();
            BeanUtils.copyProperties(student, studentCustom);

            sec.setStudentCustom(studentCustom);
            //System.out.println("sec.getMark()="+sec.setOver(true));
            secList.add(sec);

        }

        return secList;
    }
    //获取该课程学生数
    @Override
    public Integer countByCourseID(Integer id) throws Exception {
        SelectedcourseExample example=new SelectedcourseExample();
        SelectedcourseExample.Criteria criteria=example.createCriteria();
        criteria.andCourseidEqualTo(id);
        return selectedcourseMapper.countByExample(example);
    }

    //查询指定学生成绩
    @Override
    public SelectedCourseCustom findOne(SelectedCourseCustom selectedCourseCustom) throws Exception {
        SelectedcourseExample example = new SelectedcourseExample();
        SelectedcourseExample.Criteria criteria = example.createCriteria();

        criteria.andCourseidEqualTo(selectedCourseCustom.getCourseid());
        criteria.andStudentidEqualTo(selectedCourseCustom.getStudentid());

        List<Selectedcourse> list = selectedcourseMapper.selectByExample(example);


        if (list.size() > 0) {
            SelectedCourseCustom sc = new SelectedCourseCustom();
            BeanUtils.copyProperties(list.get(0), sc);

            Student student = studentMapper.selectByPrimaryKey(selectedCourseCustom.getStudentid());
            StudentCustom studentCustom = new StudentCustom();
            BeanUtils.copyProperties(student, studentCustom);

            sc.setStudentCustom(studentCustom);

            return sc;
        }

        return null;
    }
    @Override
    public void remove(SelectedCourseCustom selectedCourseCustom) throws Exception {
        SelectedcourseExample example = new SelectedcourseExample();
        SelectedcourseExample.Criteria criteria = example.createCriteria();

        criteria.andCourseidEqualTo(selectedCourseCustom.getCourseid());
        criteria.andStudentidEqualTo(selectedCourseCustom.getStudentid());

        selectedcourseMapper.deleteByExample(example);
    }
    public void save(SelectedCourseCustom selectedCourseCustom) throws Exception {
        selectedcourseMapper.insert(selectedCourseCustom);
    }
    public List<Selectedcourse> findAll(SelectedCourseCustom selectedCourseCustom)throws Exception{
        SelectedcourseExample selectedcourseExample=new SelectedcourseExample();
        SelectedcourseExample.Criteria criteria=selectedcourseExample.createCriteria();
        criteria.andCourseidIsNotNull();

        return selectedcourseMapper.selectByExample(selectedcourseExample);
    }
    public void updateOne(SelectedCourseCustom selectedCourseCustom)throws Exception{
        SelectedcourseExample selectedcourseExample=new SelectedcourseExample();
        SelectedcourseExample.Criteria criteria=selectedcourseExample.createCriteria();
        criteria.andCourseidEqualTo(selectedCourseCustom.getCourseid());
        criteria.andStudentidEqualTo(selectedCourseCustom.getStudentid());

        selectedcourseMapper.updateByExample(selectedCourseCustom,selectedcourseExample);
    }
    public List<SelectedCourseCustom> findByStudentID(Integer id) throws Exception {
        return null;
    }
}
