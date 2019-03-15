package com.system.mapper;

import java.util.List;

import com.system.po.CourseCustom;
import com.system.po.PagingVO;

public interface CourseMapperCustom {

    //分页查询学生信息
    List<CourseCustom> findByPaging(PagingVO pagingVO) throws Exception;

}