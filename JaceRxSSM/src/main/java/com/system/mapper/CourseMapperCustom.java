package com.system.mapper;

import java.util.List;

import com.system.po.CourseCustom;
import com.system.po.PagingVO;

public interface CourseMapperCustom {

    //��ҳ��ѯѧ����Ϣ
    List<CourseCustom> findByPaging(PagingVO pagingVO) throws Exception;

}