package com.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.system.po.Role;

public interface RoleMapper {
		int countByExample(RoleMapper example);

	    int deleteByExample(RoleMapper example);

	    int deleteByPrimaryKey(Integer roleid);

	    int insert(Role record);

	    int insertSelective(Role record);

	    List<Role> selectByExample(RoleMapper example);

	    Role selectByPrimaryKey(Integer roleid);

	    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleMapper example);

	    int updateByExample(@Param("record") Role record, @Param("example") RoleMapper example);

	    int updateByPrimaryKeySelective(Role record);

	    int updateByPrimaryKey(Role record);
}
