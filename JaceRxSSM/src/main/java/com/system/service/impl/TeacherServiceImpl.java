package com.system.service.impl;

import com.system.mapper.CollegeMapper;
import com.system.mapper.TeacherMapper;
import com.system.mapper.TeacherMapperCustom;
import com.system.po.*;
import com.system.service.TeacherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapperCustom teacherMapperCustom;

    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private CollegeMapper collegeMapper;
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
        if(tea == null){
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


    public List<TeacherCustom> findByName(String name) throws Exception {
        TeacherExample teacherExample = new TeacherExample();
        //自定义查询条件
        TeacherExample.Criteria criteria = teacherExample.createCriteria();

        criteria.andUsernameLike("%" + name + "%");

        List<Teacher> list = teacherMapper.selectByExample(teacherExample);

        List<TeacherCustom> teacherCustomList = null;

        if (list != null) {
            teacherCustomList = new ArrayList<TeacherCustom>();
            for (Teacher t : list) {
                TeacherCustom teacherCustom = new TeacherCustom();
                //类拷贝
                BeanUtils.copyProperties(t, teacherCustom);
//                //获取课程名
//                College college = collegeMapper.selectByPrimaryKey(t.getCollegeid());
//                teacherCustom.setcollegeName(college.getCollegename());

                teacherCustomList.add(teacherCustom);
            }
        }

        return teacherCustomList;
    }
    public void updateById(Integer id,TeacherCustom teacherCustom)throws Exception{
        teacherMapper.updateByPrimaryKey(teacherCustom);
    }
    public void removeById(Integer id){
        teacherMapper.deleteByPrimaryKey(id);
    }

    public List<Teacher> findAll()throws Exception{
        TeacherExample teacherExample=new TeacherExample();
        TeacherExample.Criteria criteria=teacherExample.createCriteria();
        criteria.andCollegeidIsNotNull();
        return teacherMapper.selectByExample(teacherExample);
    }
}
