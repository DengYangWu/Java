package com.system.service.impl;

import com.system.mapper.TeacherMapper;
import com.system.mapper.TeacherMapperCustom;
import com.system.po.*;
import com.system.service.TeacherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapperCustom teacherMapperCustom;

    @Autowired
    private TeacherMapper teacherMapper;
    @Override
    public List<TeacherCustom> findByPaging(Integer toPageNo)throws Exception{

        PagingVO pagingVO=new PagingVO();
        pagingVO.setToPageNo(toPageNo);
        List<TeacherCustom> teacherCustoms=teacherMapperCustom.findByPaging(pagingVO);
        return teacherCustoms;
    }
    @Override
    public Boolean save(TeacherCustom teacherCustom)throws Exception{
        Teacher tea=teacherMapper.selectByPrimaryKey(teacherCustom.getUserid());
        if(tea != null){
            teacherMapper.insert(teacherCustom);
            return true;
        }
        return false;
    }
    @Override
    public int getCountTeacher()throws Exception{
        //自定义查询对象
        TeacherExample teacherExample=new TeacherExample();
        //通过criteria构造查询条件
        TeacherExample.Criteria criteria=teacherExample.createCriteria();
        criteria.andUseridIsNotNull();

        return teacherMapper.countByExample(teacherExample);
    }

    public TeacherCustom findById(Integer teacherid){
        Teacher id=teacherMapper.selectByPrimaryKey(teacherid);
        TeacherCustom teacherCustom=null;
        if(id != null){
            teacherCustom = new TeacherCustom();
            BeanUtils.copyProperties(id,teacherCustom);
        }
        return teacherCustom;
    }

    public List<TeacherCustom> findByName(String name)throws Exception{
        TeacherExample teacherExample=new TeacherExample();
        TeacherExample.Criteria criteria=teacherExample.createCriteria();
        criteria.andUsernameLike(name);
        List<Teacher> teacherCustoms=teacherMapper.selectByExample(teacherExample);
        List<TeacherCustom> teacherCustoms1=null;
        if(teacherCustoms!=null){
            for(Teacher t:teacherCustoms){
                TeacherCustom teacherCustom=new TeacherCustom();
                //类拷贝
                BeanUtils.copyProperties(t,teacherCustom);
                //获取课程名
                teacherCustoms1.add(teacherCustom);
            }
        }
        return teacherCustoms1;
    }
}
