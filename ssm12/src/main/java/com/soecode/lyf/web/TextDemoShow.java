package com.soecode.lyf.web;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.soecode.lyf.dao.UserMapper;
import com.soecode.lyf.entity.User;

public class TextDemoShow extends TextDemo{
	@Autowired
	private UserMapper userMapper;
	
//	@Test
//	public void textQueryAll() throws Exception{
//		String username="123";
//		User u=userMapper.getUserByName(username);
//		System.out.println(u);
//	}
//	@Test
//	public void insertAppointment() throws Exception{
//		String username="44";
//		String password="89";
//		int insert=userMapper.insertAppointment(username, password);
//		System.out.println("insert="+insert);
//	}
	@Test
	public void queryAll() throws Exception {
		List<User> u = userMapper.queryAll();
		for (User user : u) {
			System.out.println(user.getPassword());
		}
	}
}
