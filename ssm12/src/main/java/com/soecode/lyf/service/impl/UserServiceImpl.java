package com.soecode.lyf.service.impl;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soecode.lyf.dao.UserMapper;
import com.soecode.lyf.entity.User;
import com.soecode.lyf.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserMapper userMapper;
	
	public User getUserByName(String username) {
		// TODO Auto-generated method stub
		return userMapper.getUserByName(username);
	}
	public List<User> getList(){
		return userMapper.queryAll();
		
	}
	
}
