package com.soecode.lyf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.soecode.lyf.entity.User;

public interface UserMapper {

	User getUserByName(String username);
	List<User> queryAll();
	int insertAppointment(@Param("username")String username,@Param("password") String password);
}
